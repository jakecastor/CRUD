package Model;

public class Employee {
    private static int count = 1;

    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private String address;
    private String age;
    private String position;
    private String imgPath;
    private String phoneNumber;

    public Employee( String firstName, String lastName, String gender, String address, String age,String position, String imgPath, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.age = age;
        this.position = position;
        this.imgPath = imgPath;
        this.phoneNumber = phoneNumber;
        this.id = count++;

    }
    public Employee(int id, String firstName, String lastName, String gender, String address, String age,String position, String imgPath, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.age = age;
        this.position = position;
        this.imgPath = imgPath;
        this.phoneNumber = phoneNumber;
        this.id = id;
        count = id + 1;



    }
    public Employee() {}

    public void resetCounter(){
        count = 1;
    }
    public int getId() {
        return id;
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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString(){
        return id + ": " + firstName;
    }
}
