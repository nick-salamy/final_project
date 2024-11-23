import controllers.DBConnect;
import models.DBCustomer;
import views.Display;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DBConnect db = new DBConnect("finalproject.db");
        Display display = new Display();

        display.intoMessage(db);


    }
}