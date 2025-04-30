package sistemaobserverstateifood.orderstates;

import sistemaobserverstateifood.abstractions.OrderState;

public class NoAnswerOrderState extends OrderState {
    private NoAnswerOrderState() {
    }

    private static NoAnswerOrderState instance = new NoAnswerOrderState();

    public static NoAnswerOrderState getInstance() {
        return instance;
    }

    @Override
    public String getStateName() {
        return "NoAnswer";
    }

}
