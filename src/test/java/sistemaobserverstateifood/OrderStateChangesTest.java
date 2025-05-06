package sistemaobserverstateifood;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sistemaobserverstateifood.abstractions.Order;
import sistemaobserverstateifood.entities.OrderDetails;
import sistemaobserverstateifood.orderstates.*;

import static org.junit.jupiter.api.Assertions.*;

class OrderStateChangesTest {
    public Order order;
    public Costumer costumer;
    public OrderDetails orderDetails;

    @BeforeEach
    void setUp() {
        orderDetails = new OrderDetails("X-Burger", 25.4, 2, null);
        order = OrderFactory.getOrder("RestaurantOrder", orderDetails);
        costumer = new Costumer();

        costumer.placeOrder(order);
    }

    //region PlacingOrder
    @Test
    void placeNewRestaurantOrder() {
        assertEquals("Pending", order.getOrderState().getStateName());
        assertEquals("OrderDetails{productName=X-Burger, productPrice=25.4, productQuantity=2, orderState=Pending, orderOrigin=Restaurant}", costumer.getLastOrderUpdate());
    }

    @Test
    void placeAlreadyPendingRestaurantOrder() {
        try {
            order.placeOrder();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Pedido já foi realizado", exception.getMessage());
        }
    }

    @Test
    void placeAlreadyPreparingRestaurantOrder() {
        try {
            order.setOrderState(PreparingOrderState.getInstance());

            order.placeOrder();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Pedido já foi realizado", exception.getMessage());
        }
    }

    @Test
    void placeAlreadyDeliveringRestaurantOrder() {
        try {
            order.setOrderState(DeliveringOrderState.getInstance());

            order.placeOrder();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Pedido já foi realizado", exception.getMessage());
        }
    }

    @Test
    void placeAlreadyArrivedRestaurantOrder() {
        try {
            order.setOrderState(ArrivedOrderState.getInstance());

            order.placeOrder();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Pedido já foi realizado", exception.getMessage());
        }
    }

    @Test
    void placeAlreadyRejectedRestaurantOrder() {
        try {
            order.setOrderState(RejectedOrderState.getInstance());

            order.placeOrder();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Pedido já foi realizado", exception.getMessage());
        }
    }

    @Test
    void placeAlreadyReceivedRestaurantOrder() {
        try {
            order.setOrderState(ReceivedOrderState.getInstance());

            order.placeOrder();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Pedido já foi realizado", exception.getMessage());
        }
    }

    @Test
    void placeAlreadyNoAnsweredRestaurantOrder() {
        try {
            order.setOrderState(NoAnswerOrderState.getInstance());

            order.placeOrder();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Pedido já foi realizado", exception.getMessage());
        }
    }

    @Test
    void placeAlreadyCancelledRestaurantOrder() {
        try {
            order.setOrderState(CancelledOrderState.getInstance());

            order.placeOrder();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Pedido já foi realizado", exception.getMessage());
        }
    }
    //endregion

    //region StartingOrderPreparation
    @Test
    void startRestaurantOrderPreparationOfPendingOrder() {
        order.startOrderPreparation();

        assertEquals("Preparing", order.getOrderState().getStateName());
        assertEquals("OrderDetails{productName=X-Burger, productPrice=25.4, productQuantity=2, orderState=Preparing, orderOrigin=Restaurant}", costumer.getLastOrderUpdate());
    }

    @Test
    void startRestaurantOrderPreparationOfPreparingOrder() {
        try {
            order.setOrderState(PreparingOrderState.getInstance());

            order.startOrderPreparation();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível iniciar preparação desse pedido", exception.getMessage());
        }
    }

    @Test
    void startRestaurantOrderPreparationOfDeliveringOrder() {
        try {
            order.setOrderState(DeliveringOrderState.getInstance());

            order.startOrderPreparation();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível iniciar preparação desse pedido", exception.getMessage());
        }
    }

    @Test
    void startRestaurantOrderPreparationOfArrivedOrder() {
        try {
            order.setOrderState(ArrivedOrderState.getInstance());

            order.startOrderPreparation();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível iniciar preparação desse pedido", exception.getMessage());
        }
    }

    @Test
    void startRestaurantOrderPreparationOfRejectedOrder() {
        order.setOrderState(RejectedOrderState.getInstance());

        order.startOrderPreparation();

        assertEquals("Preparing", order.getOrderState().getStateName());
        assertEquals("OrderDetails{productName=X-Burger, productPrice=25.4, productQuantity=2, orderState=Preparing, orderOrigin=Restaurant}", costumer.getLastOrderUpdate());
    }

    @Test
    void startRestaurantOrderPreparationOfNoAnsweredOrder() {
        try {
            order.setOrderState(NoAnswerOrderState.getInstance());

            order.startOrderPreparation();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível iniciar preparação desse pedido", exception.getMessage());
        }
    }

    @Test
    void startRestaurantOrderPreparationOfReceivedOrder() {
        try {
            order.setOrderState(ReceivedOrderState.getInstance());

            order.startOrderPreparation();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível iniciar preparação desse pedido", exception.getMessage());
        }
    }

    @Test
    void startRestaurantOrderPreparationOfCancelledOrder() {
        try {
            order.setOrderState(CancelledOrderState.getInstance());

            order.startOrderPreparation();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível iniciar preparação desse pedido", exception.getMessage());
        }
    }
    //endregion

    //region DeliveringOrder
    @Test
    void deliverRestaurantOrderOfPendingOrder() {
        try {
            order.deliver();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível enviar esse pedido para entrega", exception.getMessage());
        }
    }

    @Test
    void deliverRestaurantOrderOfPreparingOrder() {
        order.setOrderState(PreparingOrderState.getInstance());

        order.deliver();

        assertEquals("Delivering", order.getOrderState().getStateName());
        assertEquals("OrderDetails{productName=X-Burger, productPrice=25.4, productQuantity=2, orderState=Delivering, orderOrigin=Restaurant}", costumer.getLastOrderUpdate());
    }

    @Test
    void deliverRestaurantOrderOfDeliveringOrder() {
        try {
            order.setOrderState(DeliveringOrderState.getInstance());

            order.deliver();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível enviar esse pedido para entrega", exception.getMessage());
        }
    }

    @Test
    void deliverRestaurantOrderOfArrivedOrder() {
        try {
            order.setOrderState(ArrivedOrderState.getInstance());

            order.deliver();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível enviar esse pedido para entrega", exception.getMessage());
        }
    }

    @Test
    void deliverRestaurantOrderOfRejectedOrder() {
        try {
            order.setOrderState(RejectedOrderState.getInstance());

            order.deliver();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível enviar esse pedido para entrega", exception.getMessage());
        }
    }

    @Test
    void deliverRestaurantOrderOfNoAnsweredOrder() {
        try {
            order.setOrderState(NoAnswerOrderState.getInstance());

            order.deliver();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível enviar esse pedido para entrega", exception.getMessage());
        }
    }

    @Test
    void deliverRestaurantOrderOfReceivedOrder() {
        try {
            order.setOrderState(ReceivedOrderState.getInstance());

            order.deliver();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível enviar esse pedido para entrega", exception.getMessage());
        }
    }

    @Test
    void deliverRestaurantOrderOfCancelledOrder() {
        try {
            order.setOrderState(CancelledOrderState.getInstance());

            order.deliver();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível enviar esse pedido para entrega", exception.getMessage());
        }
    }
    //endregion

    //region MarkingOrderAsArrived
    @Test
    void markPendingRestaurantOrderAsArrived() {
        try {
            order.markAsArrived();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como chegou no destino", exception.getMessage());
        }
    }

    @Test
    void markPreparingRestaurantOrderAsArrived() {
        try {
            order.setOrderState(PreparingOrderState.getInstance());

            order.markAsArrived();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como chegou no destino", exception.getMessage());
        }
    }

    @Test
    void markDeliveringRestaurantOrderAsArrived() {
        order.setOrderState(DeliveringOrderState.getInstance());

        order.markAsArrived();

        assertEquals("Arrived", order.getOrderState().getStateName());
        assertEquals("OrderDetails{productName=X-Burger, productPrice=25.4, productQuantity=2, orderState=Arrived, orderOrigin=Restaurant}", costumer.getLastOrderUpdate());
    }

    @Test
    void markArrivedRestaurantOrderAsArrived() {
        try {
            order.setOrderState(PreparingOrderState.getInstance());

            order.markAsArrived();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como chegou no destino", exception.getMessage());
        }
    }

    @Test
    void markRejectedRestaurantOrderAsArrived() {
        try {
            order.setOrderState(RejectedOrderState.getInstance());

            order.markAsArrived();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como chegou no destino", exception.getMessage());
        }
    }

    @Test
    void markNoAnswerRestaurantOrderAsArrived() {
        try {
            order.setOrderState(NoAnswerOrderState.getInstance());

            order.markAsArrived();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como chegou no destino", exception.getMessage());
        }
    }

    @Test
    void markReceivedRestaurantOrderAsArrived() {
        try {
            order.setOrderState(ReceivedOrderState.getInstance());

            order.markAsArrived();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como chegou no destino", exception.getMessage());
        }
    }

    @Test
    void markCancelledRestaurantOrderAsArrived() {
        try {
            order.setOrderState(CancelledOrderState.getInstance());

            order.markAsArrived();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como chegou no destino", exception.getMessage());
        }
    }
    //endregion

    //region RejectingOrder
    @Test
    void rejectPendingRestaurantOrder() {
        try {
            order.reject();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível rejeitar esse pedido", exception.getMessage());
        }
    }

    @Test
    void rejectPreparingRestaurantOrder() {
        try {
            order.setOrderState(PreparingOrderState.getInstance());

            order.reject();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível rejeitar esse pedido", exception.getMessage());
        }
    }

    @Test
    void rejectDeliveringRestaurantOrder() {
        try {
            order.setOrderState(DeliveringOrderState.getInstance());

            order.reject();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível rejeitar esse pedido", exception.getMessage());
        }
    }

    @Test
    void rejectArrivedRestaurantOrder() {
        order.setOrderState(ArrivedOrderState.getInstance());

        order.reject();

        assertEquals("Rejected", order.getOrderState().getStateName());
        assertEquals("OrderDetails{productName=X-Burger, productPrice=25.4, productQuantity=2, orderState=Rejected, orderOrigin=Restaurant}", costumer.getLastOrderUpdate());
    }

    @Test
    void rejectRejectedRestaurantOrder() {
        try {
            order.setOrderState(RejectedOrderState.getInstance());

            order.reject();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível rejeitar esse pedido", exception.getMessage());
        }
    }

    @Test
    void rejectNoAnsweredRestaurantOrder() {
        try {
            order.setOrderState(NoAnswerOrderState.getInstance());

            order.reject();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível rejeitar esse pedido", exception.getMessage());
        }
    }

    @Test
    void rejectReceivedRestaurantOrder() {
        try {
            order.setOrderState(ReceivedOrderState.getInstance());

            order.reject();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível rejeitar esse pedido", exception.getMessage());
        }
    }

    @Test
    void rejectCancelledRestaurantOrder() {
        try {
            order.setOrderState(CancelledOrderState.getInstance());

            order.reject();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível rejeitar esse pedido", exception.getMessage());
        }
    }
    //endregion

    //region MarkingOrderAsNotAnswered
    @Test
    void markPendingRestaurantOrderAsNoAnswered() {
        try {
            order.markAsNotAnswered();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como não atendido no destino", exception.getMessage());
        }
    }

    @Test
    void markPreparingRestaurantOrderAsNoAnswered() {
        try {
            order.setOrderState(PreparingOrderState.getInstance());

            order.markAsNotAnswered();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como não atendido no destino", exception.getMessage());
        }
    }

    @Test
    void markDeliveringRestaurantOrderAsNoAnswered() {
        try {
            order.setOrderState(DeliveringOrderState.getInstance());

            order.markAsNotAnswered();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como não atendido no destino", exception.getMessage());
        }
    }

    @Test
    void markArrivedRestaurantOrderAsNoAnswered() {
        order.setOrderState(ArrivedOrderState.getInstance());

        order.markAsNotAnswered();

        assertEquals("NoAnswer", order.getOrderState().getStateName());
        assertEquals("OrderDetails{productName=X-Burger, productPrice=25.4, productQuantity=2, orderState=NoAnswer, orderOrigin=Restaurant}", costumer.getLastOrderUpdate());
    }

    @Test
    void markRejectedRestaurantOrderAsNoAnswered() {
        try {
            order.setOrderState(RejectedOrderState.getInstance());

            order.markAsNotAnswered();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como não atendido no destino", exception.getMessage());
        }
    }

    @Test
    void markNoAsweredRestaurantOrderAsNoAnswered() {
        try {
            order.setOrderState(NoAnswerOrderState.getInstance());

            order.markAsNotAnswered();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como não atendido no destino", exception.getMessage());
        }
    }

    @Test
    void markReceivedRestaurantOrderAsNoAnswered() {
        try {
            order.setOrderState(ReceivedOrderState.getInstance());

            order.markAsNotAnswered();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como não atendido no destino", exception.getMessage());
        }
    }

    @Test
    void markCancelledRestaurantOrderAsNoAnswered() {
        try {
            order.setOrderState(CancelledOrderState.getInstance());

            order.markAsNotAnswered();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como não atendido no destino", exception.getMessage());
        }
    }
    //endregion

    //region ReceivingOrder
    @Test
    void receivePendingRestaurantOrder() {
        try {
            order.markAsReceived();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como recebido no destino", exception.getMessage());
        }
    }

    @Test
    void receivePreparingRestaurantOrder() {
        try {
            order.setOrderState(PreparingOrderState.getInstance());

            order.markAsReceived();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como recebido no destino", exception.getMessage());
        }
    }

    @Test
    void receiveDeliveringRestaurantOrder() {
        try {
            order.setOrderState(DeliveringOrderState.getInstance());

            order.markAsReceived();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como recebido no destino", exception.getMessage());
        }
    }


    @Test
    void receiveArrivedRestaurantOrder() {
        order.setOrderState(ArrivedOrderState.getInstance());

        order.markAsReceived();

        assertEquals("Received", order.getOrderState().getStateName());
        assertEquals("OrderDetails{productName=X-Burger, productPrice=25.4, productQuantity=2, orderState=Received, orderOrigin=Restaurant}", costumer.getLastOrderUpdate());
    }

    @Test
    void receiveRejectedRestaurantOrder() {
        try {
            order.setOrderState(RejectedOrderState.getInstance());

            order.markAsReceived();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como recebido no destino", exception.getMessage());
        }
    }

    @Test
    void receiveNoAnswerRestaurantOrder() {
        try {
            order.setOrderState(NoAnswerOrderState.getInstance());

            order.markAsReceived();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como recebido no destino", exception.getMessage());
        }
    }

    @Test
    void receiveReceivedRestaurantOrder() {
        try {
            order.setOrderState(ReceivedOrderState.getInstance());

            order.markAsReceived();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como recebido no destino", exception.getMessage());
        }
    }

    @Test
    void receiveCancelledRestaurantOrder() {
        try {
            order.setOrderState(CancelledOrderState.getInstance());

            order.markAsReceived();

            fail();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível marcar esse pedido como recebido no destino", exception.getMessage());
        }
    }
    //endregion

    //region CancelingOrder
    @Test
    void cancelPendingRestaurantOrder() {
        order.cancel();

        assertEquals("Cancelled", order.getOrderState().getStateName());
        assertEquals("OrderDetails{productName=X-Burger, productPrice=25.4, productQuantity=2, orderState=Cancelled, orderOrigin=Restaurant}", costumer.getLastOrderUpdate());
    }

    @Test
    void cancelPreparingRestaurantOrder() {
        order.setOrderState(PreparingOrderState.getInstance());

        order.cancel();

        assertEquals("Cancelled", order.getOrderState().getStateName());
        assertEquals("OrderDetails{productName=X-Burger, productPrice=25.4, productQuantity=2, orderState=Cancelled, orderOrigin=Restaurant}", costumer.getLastOrderUpdate());
    }

    @Test
    void cancelDeliveringRestaurantOrder() {
        order.setOrderState(DeliveringOrderState.getInstance());

        order.cancel();

        assertEquals("Cancelled", order.getOrderState().getStateName());
        assertEquals("OrderDetails{productName=X-Burger, productPrice=25.4, productQuantity=2, orderState=Cancelled, orderOrigin=Restaurant}", costumer.getLastOrderUpdate());
    }

    @Test
    void cancelArrivedRestaurantOrder() {
        try {
            order.setOrderState(ArrivedOrderState.getInstance());

            order.cancel();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível cancelar esse pedido", exception.getMessage());
        }
    }

    @Test
    void cancelRejectedRestaurantOrder() {
        order.setOrderState(RejectedOrderState.getInstance());

        order.cancel();

        assertEquals("Cancelled", order.getOrderState().getStateName());
        assertEquals("OrderDetails{productName=X-Burger, productPrice=25.4, productQuantity=2, orderState=Cancelled, orderOrigin=Restaurant}", costumer.getLastOrderUpdate());
    }

    @Test
    void cancelNotAnsweredRestaurantOrder() {
        try {
            order.setOrderState(NoAnswerOrderState.getInstance());

            order.cancel();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível cancelar esse pedido", exception.getMessage());
        }
    }

    @Test
    void cancelReceivedRestaurantOrder() {
        try {
            order.setOrderState(ReceivedOrderState.getInstance());

            order.cancel();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível cancelar esse pedido", exception.getMessage());
        }
    }

    @Test
    void cancelCancelledRestaurantOrder() {
        try {
            order.setOrderState(CancelledOrderState.getInstance());

            order.cancel();
        } catch (IllegalStateException exception) {
            assertEquals("Não foi possível cancelar esse pedido", exception.getMessage());
        }
    }
    //endregion
}