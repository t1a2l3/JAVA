package EmployeeManagement;
import CostumerManagement.Person;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee extends Person {
    private final int id;
    private int Salary;
    private LocalDate JobStartDate;
    private String Password;
    private String dutyTiming;
    public enum EmployeeRole {MANAGER , ACCOUNTMANAGER , LOANMANAGER , RECPIENT , SECURITYMANAGER, LOCKERMANAGER};
    private EmployeeRole EmployeeJob ;
    public Employee(int id , String Name , String FatherName, LocalDate DateOfBirth,int Age, String Gender , String Email, CostumerManagement.Person.MARITALSTATUS MaritalStatus,String Password, String Address , String city, int PIN, String State, int PhoneNumber , int Salary , LocalDate jobStartDate , String dutyTiming,EmployeeRole employeeJob){
        super(Name , FatherName , DateOfBirth ,Age, Gender , Email , MaritalStatus , Address , city , PIN , State , PhoneNumber);
        this.id = id;
        this.Salary = Salary;
        this.Password = Password;
        this.JobStartDate = jobStartDate;
        this.dutyTiming = dutyTiming;
        this.EmployeeJob = employeeJob;
    }
    public Employee(int id , String Name , String Email , String Password , int PIN , int Salary){
        super(Name , Email , PIN);
        this.id = id;
        this.Password = Password;
        this.Salary = Salary;
    }
    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public LocalDate getJobStartDate() {
        return JobStartDate;
    }

    public void setJobStartDate(LocalDate jobStartDate) {
        JobStartDate = jobStartDate;
    }

    public String getDutyTiming() {
        return dutyTiming;
    }

    public void setDutyTiming(String dutyTiming) {
        this.dutyTiming = dutyTiming;
    }
    public int getId(){
        return id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return super.toString() +
                "id=" + id +
                ", Salary=" + Salary +
                ", JobStartDate=" + JobStartDate +
                ", Password='" + Password +
                ", dutyTiming='" + dutyTiming +
                "Job Role : " + this.EmployeeJob + "\n";
    }
}
