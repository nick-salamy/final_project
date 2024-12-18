package views;
import controllers.Convert;
import controllers.DBConnect;
import models.Customer;
import models.Order;

import java.util.ArrayList;
import java.util.Scanner;
public class Display {
    private Scanner s = new Scanner(System.in);

    public Display() {

    }

    public void intoMessage(DBConnect db) {
        int userAns;
        System.out.println("Would you lke to search for a customer(1) // or create new order(2) to be implemented ");
        userAns = s.nextInt();

        switch(userAns) {
            case 1 -> searchCustomer(db);
            //case 2 -> createNewOrder(db);
        }
    }

    private void searchCustomer(DBConnect db) {
        String viewOrder;
        Customer customer;
        Order order;
        System.out.println("Would you like to search by customer name(1) or ID(2): (Choose by ID if you don't know customer name)");
        int userAns = s.nextInt();

        switch(userAns) {
            case 1:
                Convert convertOne = new Convert();
                System.out.println("Please enter customer name with proper capitalization: ");
                s.nextLine();
                String custName = s.nextLine();
               customer = convertOne.getCustomerNameFromDB(db, custName);
               if(customer.getCustomerName() == null)
               {
                   System.out.println("Invalid customer name, please search by ID to find customer name");
               } else {
                   System.out.println(customer);
                   System.out.println("Would you like to view order? (y/n)");
                   if(s.nextLine().equalsIgnoreCase("y")) {
                       order = convertOne.getOrderFromDB(db, customer.getOrderNumber(), customer.getId());
                       System.out.println(order);
                   }
               }
               break;
            case 2:
                Convert convert = new Convert();
                System.out.println("Please enter customer id: (1-4)");
                s.nextLine();
                int custId = s.nextInt();
                if(custId > 4 || custId < 1) {
                    System.out.println("Invalid customer id please try again.");
                }
                customer = convert.getCustomerIdFromDB(db, custId);
                if(customer.getId() == 0) {

                } else {
                    System.out.println(customer);
                    System.out.println("Would you like to view order? (y/n)");
                    s.nextLine();
                    viewOrder = s.nextLine();
                    if(viewOrder.toLowerCase().equals("y")) {
                       order =  convert.getOrderFromDB(db, customer.getOrderNumber(), customer.getId());
                       System.out.println(order);
                    }

                }
                break;
            default:
                System.out.println("Input not valid, please try again");
        }
    }
}
