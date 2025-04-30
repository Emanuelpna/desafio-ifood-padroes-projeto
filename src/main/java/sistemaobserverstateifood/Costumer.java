package sistemaobserverstateifood;

import sistemaobserverstateifood.abstractions.Order;

import java.util.Observable;
import java.util.Observer;

public class Costumer implements Observer {
    private String lastOrderUpdate;
    private Order order;

    void placeOrder(Order order) {
        order.addObserver(this);

        order.placeOrder();
    }

    @Override
    public void update(Observable order, Object arg) {
        this.order = (Order) order;

        this.lastOrderUpdate = arg.toString();
    }

    public String getLastOrderUpdate() {
        return lastOrderUpdate;
    }
}
