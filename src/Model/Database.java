package Model;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.*;

public class Database {
    private static final String username = "root";
    private static final String password = "111096";
    private static final String dataConnect = "jdbc:mysql://localhost:3306/database";
    private Connection con;

    Connection sqlConn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q;

    public void connect() throws Exception {

        if (con != null) return;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver not found");
        }

        con = DriverManager.getConnection(dataConnect, username, password);

        System.out.println("Connected: " + con);
    }

    public void disconnect() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException throwables) {
                System.out.println("Can't close connection");
            }
        }

    }


    private final ArrayList<Employee> employee;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String age;
    private String position;
    private String phoneNumber;
    private String imgPath;

    public Database() {
        employee = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        this.employee.add(employee);
    }

    public ArrayList<Employee> getEmployee() {
        return employee;

    }

    public void save() throws SQLException {

        String checkSql = "select count(*) as count from employee where id=?";
        PreparedStatement checkStmt = con.prepareStatement(checkSql);

        String insertSql = "insert into employee (id,first_name,last_name,gender,address,age,position,picture,number) values (?,?,?,?,?,?,?,?,?)";

        PreparedStatement insertStatement = con.prepareStatement(insertSql);

        String updateSql = "update employee set first_name = ?,last_name = ?,gender = ?,address = ?,age = ?,position = ?,picture = ? ,number = ? where id = ?";
        PreparedStatement updateStatement = con.prepareStatement(updateSql);


        for (Employee employee : employee) {
            int id = employee.getId();
            String firstName = employee.getFirstName();
            String lastName = employee.getLastName();
            String gender = employee.getGender();
            String address = employee.getAddress();
            String age = employee.getAge();
            String position = employee.getPosition();
            String imgPath = employee.getImgPath();
            String phoneNumber = employee.getPhoneNumber();

            checkStmt.setInt(1, id);

            ResultSet checkResult = checkStmt.executeQuery();
            checkResult.next();

            int count = checkResult.getInt(1);

            System.out.println("ID: " + id);


            if (count == 0) {
                System.out.println("Inserting employee with ID " + id);
                int col = 1;

                insertStatement.setInt(col++, id);
                insertStatement.setString(col++, firstName);
                insertStatement.setString(col++, lastName);
                insertStatement.setString(col++, gender);
                insertStatement.setString(col++, address);
                insertStatement.setString(col++, age);
                insertStatement.setString(col++, position);
                insertStatement.setString(col++, imgPath);
                insertStatement.setString(col++, phoneNumber);

                insertStatement.executeUpdate();
                System.out.println("insert");

            } else {
                System.out.println("Updating employee with ID " + id);
                int col = 1;

                updateStatement.setString(col++, firstName);
                updateStatement.setString(col++, lastName);
                updateStatement.setString(col++, gender);
                updateStatement.setString(col++, address);
                updateStatement.setString(col++, age);
                updateStatement.setString(col++, position);
                updateStatement.setString(col++, imgPath);
                updateStatement.setString(col++, phoneNumber);
                updateStatement.setInt(col++, id);

                updateStatement.executeUpdate();
            }

            System.out.println("Count for person with ID " + id + " is " + count);
        }
        updateStatement.close();
        insertStatement.close();
        checkStmt.close();
    }

    public Employee update(int id) {
//        String firstName = JOptionPane.showInputDialog(null, "Enter first name", "Updating", JOptionPane.QUESTION_MESSAGE);
//        String lastName = JOptionPane.showInputDialog(null, "Enter last name", "Updating", JOptionPane.QUESTION_MESSAGE);
//        String gender = JOptionPane.showInputDialog(null, "Enter gender", "Updating", JOptionPane.QUESTION_MESSAGE);
//        String address = JOptionPane.showInputDialog(null, "Enter address", "Updating", JOptionPane.QUESTION_MESSAGE);
//        String age = JOptionPane.showInputDialog(null, "Enter age", "Updating", JOptionPane.QUESTION_MESSAGE);
//        String position = JOptionPane.showInputDialog(null, "Enter position", "Updating", JOptionPane.QUESTION_MESSAGE);
//        String phoneNumber = JOptionPane.showInputDialog(null, "Enter Phone Number", "Updating", JOptionPane.QUESTION_MESSAGE);
//        String imgPath = JOptionPane.showInputDialog(null, "Enter Image Path", "Updating", JOptionPane.QUESTION_MESSAGE);


        return new Employee(id, firstName, lastName, gender, address, age, position, phoneNumber, imgPath);


    }

    public void removeEmployee(int index) {
        employee.remove(index);
    }

    public void load() throws SQLException {
        employee.clear();

        String sql = "select id,first_name,last_name,gender,address,age,position,picture,number from employee order by id";
        Statement selectStatement = con.createStatement();

        ResultSet results = selectStatement.executeQuery(sql);

        while (results.next()) {
            int id = results.getInt("id");
            String first_name = results.getString("first_name");
            String last_name = results.getString("last_name");
            String gender = results.getString("gender");
            String address = results.getString("address");
            String age = results.getString("age");
            String position = results.getString("position");
            String number = results.getString("number");
            String picture = results.getString("picture");


            Employee employee1 = new Employee(id, first_name, last_name, gender, address, age, position,picture,number);
            employee.add(employee1);


        }

        results.close();
        selectStatement.close();


    }

    public void delete(int id) throws SQLException {
        Statement statement = con.createStatement();
        statement.executeUpdate("delete from employee where id = " + id);

        statement.close();
    }

    public void reset() throws SQLException {
        Statement statement = con.createStatement();
        statement.executeUpdate("delete from employee");

        new Employee().resetCounter();

        statement.close();

    }
    public void setEmployeeData(String firstName,String lastName,String gender,String address,String age,String position,String phoneNumber,String imgPath){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.age = age;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.imgPath = imgPath;

    }
};

