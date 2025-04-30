package sistemaobserverstateifood.entities;

public class OrderDetails {
    private String productName;
    private double productPrice;
    private int productQuantity;
    private String orderState;

    private String orderOrigin;

    public OrderDetails(String productName, double productPrice, int productQuantity, String orderState) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.orderState = orderState;
    }

    public OrderDetails(String productName, double productPrice, int productQuantity, String orderState, String orderOrigin) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.orderState = orderState;
        this.orderOrigin = orderOrigin;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderOrigin() {
        return orderOrigin;
    }

    public void setOrderOrigin(String orderOrigin) {
        this.orderOrigin = orderOrigin;
    }

    @Override
    public String toString() {
        return "OrderDetails{productName=" + productName + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + ", orderState=" + orderState + ", orderOrigin=" + orderOrigin + "}";
    }
}
