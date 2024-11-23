package controllers;

import models.DBCustomer;
import models.DBOrder;

import java.sql.*;
import java.util.ArrayList;

public class DBConnect {
    private String dbName, url;
    public DBConnect(String dbName) {
        this.dbName = dbName;
        this.url = "jdbc:sqlite:C:/sqlite/db/" + dbName;
    }

    public void createNewDatabase() {
        try(Connection con = DriverManager.getConnection(url)) {
            if(con != null) {
                System.out.println("Database created");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addTables() {
        String sql = "CREATE TABLE IF NOT EXISTS customer (\n" + " id integer PRIMARY KEY,\n" +
                " customerName text NOT NULL,\n" + " address text NOT NULL,\n" + " orderNumber integer NOT NULL\n" +
                ");";


        try(Connection con = DriverManager.getConnection(url)) {
        Statement statement = con.createStatement();
        statement.execute(sql);
        System.out.println("Table created");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<DBCustomer> getCustomerData() {
        String sql = "SELECT id, customerName, address, orderNumber FROM customer";
        ArrayList<DBCustomer> customerList = new ArrayList<DBCustomer>();

        try(Connection con = DriverManager.getConnection(url)) {
            Statement statement = con.createStatement();
            ResultSet customers = statement.executeQuery(sql);

            while(customers.next()) {
                int id = customers.getInt("id");
                String customerName = customers.getString("customerName");
                String address = customers.getString("address");
                int orderId = customers.getInt("orderNumber");
                DBCustomer customer = new DBCustomer(id, customerName, address, orderId);
                customerList.add(customer);
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    public ArrayList<DBOrder> getOrderData() {
        String sql = "SELECT orderid, productone, producttwo, prodocutthree, customerid FROM orders";
        ArrayList<DBOrder> orderList = new ArrayList<>();

        try(Connection con = DriverManager.getConnection(url)) {
            Statement statement = con.createStatement();
            ResultSet orders = statement.executeQuery(sql);

            while(orders.next()) {
                int orderId = orders.getInt("orderid");
                String itemOne = orders.getString("productone");
                String itemTwo = orders.getString("producttwo");
                String itemThree = orders.getString("prodocutthree");
                int custId = orders.getInt("customerid");

                DBOrder order = new DBOrder(itemOne, itemTwo, itemThree, orderId, custId);
                orderList.add(order);
            }
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        }
        return orderList;
    }
}
