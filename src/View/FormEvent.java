package View;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String age;
    private String position;
    private String imgPath;
    private String phoneNumber;




    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String firstName, String lastName, String gender, String address,String age, String position, String imgPath, String phoneNumber) {
        super(source);
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.age = age;
        this.position = position;
        this.imgPath = imgPath;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String number) {
        this.phoneNumber = number;
    }
}
