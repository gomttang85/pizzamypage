package pizzaDemo;

import pizzaDemo.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class PizzamypageViewHandler {


    @Autowired
    private PizzamypageRepository pizzamypageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPizzaordered_then_CREATE_1 (@Payload Pizzaordered pizzaordered) {
        try {
            if (pizzaordered.isMe()) {
                List<Pizzamypage> pizzamypageList = pizzamypageRepository.findByPizzaId(pizzaordered.getPizzaId());
                if(pizzamypageList.size() < 1){
                    // view 객체 생성
                    Pizzamypage pizzamypage = new Pizzamypage();
                    // view 객체에 이벤트의 Value 를 set 함
                    pizzamypage.setPizzaId(pizzaordered.getPizzaId());
                    pizzamypage.setPizzaStatus(pizzaordered.getOrderStatus());
                    // view 레파지 토리에 save
                    pizzamypageRepository.save(pizzamypage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenPizzashipped_then_UPDATE_1(@Payload Pizzashipped pizzashipped) {
        try {
            if (pizzashipped.isMe()) {
                // view 객체 조회
                List<Pizzamypage> pizzamypageList = pizzamypageRepository.findByPizzaId(pizzashipped.getPizzaId());
                for(Pizzamypage pizzamypage : pizzamypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    pizzamypage.setPizzaStatus(pizzashipped.getPizzaDeliveryStatus());
                    // view 레파지 토리에 save
                    pizzamypageRepository.save(pizzamypage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPizzadeliverycanceled_then_UPDATE_2(@Payload Pizzadeliverycanceled pizzadeliverycanceled) {
        try {

            if (pizzadeliverycanceled.isMe()) {
                // view 객체 조회
                List<Pizzamypage> pizzamypageList = pizzamypageRepository.findByPizzaId(pizzadeliverycanceled.getPizzaId());
                for(Pizzamypage pizzamypage : pizzamypageList){

                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    pizzamypage.setPizzaStatus(pizzadeliverycanceled.getPizzaDeliveryStatus());
                    // view 레파지 토리에 save
                    pizzamypageRepository.save(pizzamypage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPizzasettled_then_CREATE_2(@Payload Pizzasettled pizzasettled) {
        try {

            if("SETTLED".equals(pizzasettled.getPaymentStatus())){
                if (pizzasettled.isMe()) {
                    // view 객체 생성
                    Pizzamypage pizzamypage = new Pizzamypage();
                    // view 객체에 이벤트의 Value 를 set 함
                    pizzamypage.setPizzaId(pizzasettled.getPizzaId());
                    pizzamypage.setPaymentStatus(pizzasettled.getPaymentStatus());
                    // view 레파지 토리에 save
                    pizzamypageRepository.save(pizzamypage);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenPizzapaymentcanceled_then_UPDATE_4(@Payload Pizzapaymentcanceled pizzapaymentcanceled) {
        try {

            if ("CANCELED".equals(pizzapaymentcanceled.getPaymentStatus())) {

                // view 객체 조회
                List<Pizzamypage> pizzamypageList = pizzamypageRepository.findByPizzaId(pizzapaymentcanceled.getPizzaId());

                for(Pizzamypage pizzamypage : pizzamypageList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    pizzamypage.setPaymentStatus(pizzapaymentcanceled.getPaymentStatus());
                    // view 레파지 토리에 save
                    pizzamypageRepository.save(pizzamypage);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}