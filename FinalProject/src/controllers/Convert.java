package controllers;

import models.Customer;
import models.DBCustomer;
import models.DBOrder;
import models.Order;

import java.util.ArrayList;

// This class is used to pick the specified customer and change it from DBCustomer to Customer
public class Convert {

    public Convert() {

    }

    public Customer getCustomerNameFromDB(DBConnect db, String customerName) {
        Customer customer = new Customer();
        ArrayList<DBCustomer> dbCustomerList = db.getCustomerData(customerName);


        for(DBCustomer dbCustomer : dbCustomerList) {
            //if(dbCustomer.getCustomerName().equals(customerName)) {
                customer.setId(dbCustomer.getId());
                customer.setCustomerName(dbCustomer.getCustomerName());
                customer.setAddress(dbCustomer.getAddress());
                customer.setOrderNumber(dbCustomer.getOrderNumber());

            //}
        }

        return customer;
    }

    public Customer getCustomerIdFromDB(DBConnect db, int customerId) {
        Customer customer = new Customer();
        ArrayList<DBCustomer> dbCustomerList = db.getCustomerData(customerId);

        if(customerId < 1 || customerId > 4) {
            // left blank to allow view to handle that
        } else {
            for (DBCustomer dbCustomer : dbCustomerList) {
                    customer.setId(dbCustomer.getId());
                    customer.setCustomerName(dbCustomer.getCustomerName());
                    customer.setAddress(dbCustomer.getAddress());
                    customer.setOrderNumber(dbCustomer.getOrderNumber());
            }
        }

        return customer;
    }

    public Order getOrderFromDB(DBConnect db, int orderId, int customerId) {
        Order order = new Order();
        ArrayList<DBOrder> orderList = db.getOrderData(customerId);

        for(DBOrder dbOrders : orderList) {
                order.setOrderId(dbOrders.getOrderId());
                order.setCustomerId(dbOrders.getCustomerId());
                order.setItemOne(dbOrders.getItemOne());
                order.setItemTwo(dbOrders.getItemTwo());
                order.setItemThree(dbOrders.getItemThree());
        }
        return order;
    }

}
