package pizzaDemo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Pizzamypage_table")
public class Pizzamypage {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String pizzaId;
        private String pizzaStatus;
        private String paymentStatus;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getPizzaId() {
            return pizzaId;
        }

        public void setPizzaId(String pizzaId) {
            this.pizzaId = pizzaId;
        }
        public String getPizzaStatus() {
            return pizzaStatus;
        }

        public void setPizzaStatus(String pizzaStatus) {
            this.pizzaStatus = pizzaStatus;
        }
        public String getPaymentStatus() {
            return paymentStatus;
        }

        public void setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
        }

}
