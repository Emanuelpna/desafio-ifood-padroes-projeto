package sistemaobserverstateifood.abstractions;

import sistemaobserverstateifood.entities.OrderDetails;

import java.util.Observer;

public interface Order {
    OrderDetails getOrderDetails();
    void setOrderDetails(OrderDetails orderDetails);

    OrderState getOrderState();
    void setOrderState(OrderState orderState);

    void addObserver(Observer o);

    void placeOrder();
    void startOrderPreparation();
    void deliver();
    void markAsArrived();
    void markAsReceived();
    void reject();
    void markAsNotAnswered();
    void cancel();
}
