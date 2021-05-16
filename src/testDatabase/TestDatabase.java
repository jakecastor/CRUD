package testDatabase;

import Model.Database;
import Model.Employee;

import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDatabase {
    public static void main(String[] args){
        System.out.println("Running database test");

        Database db  = new Database();
        try {
            db.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            db.save();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            db.load();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        db.disconnect();

    }
}
