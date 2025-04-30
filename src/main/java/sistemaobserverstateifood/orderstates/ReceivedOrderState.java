package sistemaobserverstateifood.orderstates;

import sistemaobserverstateifood.abstractions.OrderState;

public class ReceivedOrderState extends OrderState {
    private ReceivedOrderState() {
    }

    private static ReceivedOrderState instance = new ReceivedOrderState();

    public static ReceivedOrderState getInstance() {
        return instance;
    }

    @Override
    public String getStateName() {
        return "Received";
    }

}
