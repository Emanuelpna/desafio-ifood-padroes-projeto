package sistemaobserverstateifood;

import org.junit.jupiter.api.Test;
import sistemaobserverstateifood.abstractions.Order;
import sistemaobserverstateifood.entities.OrderDetails;

import static org.junit.jupiter.api.Assertions.*;

class StoreTypeOrderTest {
    @Test
    void createRestaurantOrder() {
        OrderDetails orderDetails = new OrderDetails("X-Burger", 25.4, 2, null);

        Order order = OrderFactory.getOrder("RestaurantOrder", orderDetails);

        assertEquals("Restaurant", order.getOrderDetails().getOrderOrigin());
    }

    @Test
    void createSupermarketOrder() {
        OrderDetails orderDetails = new OrderDetails("X-Burger", 25.4, 2, null);

        Order order = OrderFactory.getOrder("SupermarketOrder", orderDetails);

        assertEquals("Supermarket", order.getOrderDetails().getOrderOrigin());
    }

    @Test
    void createDrugstoreOrder() {
        OrderDetails orderDetails = new OrderDetails("X-Burger", 25.4, 2, null);

        Order order = OrderFactory.getOrder("DrugstoreOrder", orderDetails);

        assertEquals("Drugstore", order.getOrderDetails().getOrderOrigin());
    }

    @Test
    void failToCreateBeershopOrder() {
        try {
            OrderDetails orderDetails = new OrderDetails("X-Burger", 25.4, 2, null);

            Order order = OrderFactory.getOrder("BeershopOrder", orderDetails);

            fail();
        } catch (IllegalArgumentException exception) {
            assertEquals("Pedido inexistente", exception.getMessage());
        }
    }
}