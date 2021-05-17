package Controller;

import Model.Database;
import Model.Employee;
import View.FormEvent;

import java.sql.SQLException;
import java.util.List;

public class Controller {
    Database db = new Database();

    public List<Employee> getEmployee(){
       return db.getEmployee();

    };
    public void save() throws SQLException {
        db.save();
    }

    public void load() throws SQLException {
        db.load();
    }

    public void connect() throws Exception {
        db.connect();
    }
    public void delete(int id) throws  SQLException{
        db.delete(id);
    }
    public void reset() throws  SQLException{
        db.reset();

    }
    public void update(int id) throws  SQLException{
        db.addEmployee(db.update(id));
    }
    public void editBtn(String firstName,String lastName,String gender,String address,String age,String position,String phoneNumber,String imgPath) {
        db.setEmployeeData( firstName, lastName, gender, address, age, position, phoneNumber, imgPath);
    }

    public void close(){
        db.disconnect();
    }

    public void addEmployee(FormEvent ev){
        String firstName = ev.getFirstName();
        String lastName = ev.getLastName();
        String gender = ev.getGender();
        String address = ev.getAddress();
        String age = ev.getAge();
        String position = ev.getPosition();
        String phoneNumber = ev.getPhoneNumber();
        String imgPath = ev.getImgPath();

        Employee employee = new Employee(firstName,lastName,gender,address,age,position,imgPath,phoneNumber);
        db.addEmployee(employee);


    }

    public void removeEmployee(int index){
        db.removeEmployee(index);
    }
}
