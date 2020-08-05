package pizzaDemo;

public class Pizzashipped extends AbstractEvent {

    private Long id;
    private String pizzaId;
    private String pizzaDeliveryStatus;

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
    public String getPizzaDeliveryStatus() {
        return pizzaDeliveryStatus;
    }

    public void setPizzaDeliveryStatus(String pizzaDeliveryStatus) {
        this.pizzaDeliveryStatus = pizzaDeliveryStatus;
    }
}