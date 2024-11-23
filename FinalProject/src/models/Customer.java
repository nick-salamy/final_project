package models;

import java.util.ArrayList;

public class Customer{
    private int id, orderNumber;
    private String customerName, address;

    public Customer() {

    }
    public Customer(int id, String customerName, String address, int orderNumber) {
        this.id = id;
        this.customerName = customerName;
        this.address = address;
        this.orderNumber = orderNumber;
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

    public String toString() {
        return "Customer name: " + customerName + "\n Customer id: " + id + "\n Address: " + address + "\nOrder number: "
                + orderNumber;
    }
}
