package sistemaobserverstateifood;

import sistemaobserverstateifood.abstractions.Order;
import sistemaobserverstateifood.entities.OrderDetails;

public class OrderFactory {
    public static Order getOrder(String orderClass, OrderDetails orderDetails) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("sistemaobserverstateifood.orders." + orderClass);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Pedido inexistente");
        }

        if (!(objeto instanceof Order)) {
            throw new IllegalArgumentException("Pedido inválido");
        }

        Order order = (Order) objeto;

        order.setOrderDetails(orderDetails);

        return order;
    }
}
