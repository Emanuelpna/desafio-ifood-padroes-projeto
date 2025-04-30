package sistemaobserverstateifood.orderstates;

import sistemaobserverstateifood.abstractions.Order;
import sistemaobserverstateifood.abstractions.OrderState;

public class ArrivedOrderState extends OrderState {
    private ArrivedOrderState() {
    }

    private static ArrivedOrderState instance = new ArrivedOrderState();

    public static ArrivedOrderState getInstance() {
        return instance;
    }

    @Override
    public String getStateName() {
        return "Arrived";
    }

    @Override
    public boolean reject(Order order) {
        order.setOrderState(RejectedOrderState.getInstance());
        return true;
    }

    @Override
    public boolean markAsNotAnswered(Order order) {
        order.setOrderState(NoAnswerOrderState.getInstance());
        return true;
    }

    @Override
    public boolean markAsReceived(Order order) {
        order.setOrderState(ReceivedOrderState.getInstance());
        return true;
    }
}
