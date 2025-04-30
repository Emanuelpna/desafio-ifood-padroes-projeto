package sistemaobserverstateifood.orders;

import sistemaobserverstateifood.abstractions.Order;
import sistemaobserverstateifood.abstractions.OrderState;
import sistemaobserverstateifood.entities.OrderDetails;
import sistemaobserverstateifood.orderstates.PendingOrderState;

import java.util.Observable;

public class SupermarketOrder extends Observable implements Order {
    private OrderState orderState;
    private OrderDetails orderDetails;

    @Override
    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    @Override
    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
        this.orderDetails.setOrderOrigin("Supermarket");
    }

    @Override
    public OrderState getOrderState() {
        return orderState;
    }

    @Override
    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public void placeOrder() {
        if (this.orderState != null) {
            throw new IllegalStateException("Pedido já foi realizado");
        }

        orderState = PendingOrderState.getInstance();
        orderDetails.setOrderState(orderState.getStateName());

        setChanged();
        notifyObservers(orderDetails);
    }

    @Override
    public void startOrderPreparation() {
        boolean changed = orderState.startOrderPreparation(this);

        if (!changed) {
            throw new IllegalStateException("Não foi possível iniciar preparação desse pedido");
        }

        orderDetails.setOrderState(orderState.getStateName());

        setChanged();
        notifyObservers(orderDetails);
    }

    @Override
    public void deliver() {
        boolean changed = orderState.deliver(this);

        if (!changed) {
            throw new IllegalStateException("Não foi possível enviar esse pedido para entrega");
        }

        orderDetails.setOrderState(orderState.getStateName());

        setChanged();
        notifyObservers(orderDetails);
    }

    @Override
    public void markAsArrived() {
        boolean changed = orderState.markAsArrived(this);

        if (!changed) {
            throw new IllegalStateException("Não foi possível marcar esse pedido como chegou no destino");
        }

        orderDetails.setOrderState(orderState.getStateName());

        setChanged();
        notifyObservers(orderDetails);
    }

    @Override
    public void markAsReceived() {
        boolean changed = orderState.markAsReceived(this);

        if (!changed) {
            throw new IllegalStateException("Não foi possível marcar esse pedido como recebido no destino");
        }

        orderDetails.setOrderState(orderState.getStateName());

        setChanged();
        notifyObservers(orderDetails);
    }

    @Override
    public void reject() {
        boolean changed = orderState.reject(this);

        if (!changed) {
            throw new IllegalStateException("Não foi possível rejeitar esse pedido");
        }

        orderDetails.setOrderState(orderState.getStateName());

        setChanged();
        notifyObservers(orderDetails);
    }

    @Override
    public void markAsNotAnswered() {
        boolean changed = orderState.markAsNotAnswered(this);

        if (!changed) {
            throw new IllegalStateException("Não foi possível marcar esse pedido como não atendido no destino");
        }

        orderDetails.setOrderState(orderState.getStateName());

        setChanged();
        notifyObservers(orderDetails);
    }

    @Override
    public void cancel() {
        boolean changed = orderState.cancel(this);

        if (!changed) {
            throw new IllegalStateException("Não foi possível cancelar esse pedido");
        }

        orderDetails.setOrderState(orderState.getStateName());

        setChanged();
        notifyObservers(orderDetails);
    }
}
