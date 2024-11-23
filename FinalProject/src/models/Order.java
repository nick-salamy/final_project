package models;

public class Order {
    int orderId, customerId;
    String itemOne, itemTwo, itemThree;
    public Order() {

    }

    public Order(String itemOne, String itemTwo, String itemThree, int orderId, int CustomerId) {
        this.itemOne = itemOne;
        this.itemTwo = itemTwo;
        this.itemThree = itemThree;
        this.orderId = orderId;
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getItemOne() {
        return itemOne;
    }

    public void setItemOne(String itemOne) {
        this.itemOne = itemOne;
    }

    public String getItemTwo() {
        return itemTwo;
    }

    public void setItemTwo(String itemTwo) {
        this.itemTwo = itemTwo;
    }

    public String getItemThree() {
        return itemThree;
    }

    public void setItemThree(String itemThree) {
        this.itemThree = itemThree;
    }

    public String toString() {
        return "Customer id: " + customerId + "\nOrder id: " + orderId + "\nItems: " + itemOne + ", " + itemTwo + ", " + itemThree;
    }
}
