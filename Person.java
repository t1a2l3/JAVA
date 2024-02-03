package CostumerManagement;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {
    private String Name;
    private String FatherName;
    private String EmailAdress;
    private String Gender;
    public enum MARITALSTATUS {MARRIED , UNMARRIED , OTHER}
    private MARITALSTATUS MaritalStatus;
    private String Address;
    private int Age;
    private int PhoneNumber;
    private LocalDate DateOfBirth;
    private String City;
    private String State;
    private int PIN;        // Use while loging Account.
    public Person(String Name ,String FatherName,LocalDate DateOfBirth,int Age, String Gender , String Email, MARITALSTATUS MaritalStatus, String Address ,String city,int PIN,String State, int PhoneNumber){
        this.Name = Name;
        this.FatherName = FatherName;
        this.DateOfBirth = DateOfBirth;
        this.EmailAdress = Email;
        this.Gender = Gender;
        this.Age = Age;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.City = city;
        this.MaritalStatus = MaritalStatus;
        this.PIN = PIN;
        this.State = State;
    }

    public Person(String Name, String Email , int PIN){
        this.Name = Name;
        this.EmailAdress = Email;
        this.PIN = PIN;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmailAdress() {
        return EmailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        EmailAdress = emailAdress;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public MARITALSTATUS getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(MARITALSTATUS maritalStatus) {
        MaritalStatus = maritalStatus;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PINCODE) {
        this.PIN = PINCODE;
    }

    @Override
    public String toString() {
        return  "Name='" + Name  +
                ", FatherName='" + FatherName + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Age=" + Age +
                ", EmailAdress='" + EmailAdress + '\'' +
                ", PIN=" + PIN +
                ", MaritalStatus=" + MaritalStatus +
                ", Address='" + Address + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                ", DateOfBirth=" + DateOfBirth +
                ", City='" + City + '\'' +
                ", State='" + State;
    }
}

