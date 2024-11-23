package models;

public class DBCustomer {
    private int id, orderNumber;
    private String customerName, address;

    public DBCustomer(int id, String customerName, String address, int orderNumber) {
        this.id = id;
        this.customerName = customerName;
        this.address = address;
        this.orderNumber = orderNumber;
    }

    public String toString() {
        return customerName + " Customer id: " + id + "\nAddress: " + address + "\nOrder number: " + orderNumber +"\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
