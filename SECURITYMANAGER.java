package EmployeeManagement;

import java.time.LocalDate;

public class SECURITYMANAGER extends Employee{
    public SECURITYMANAGER(int id , String Name , String FatherName, LocalDate DateOfBirth, int Age, String Gender , String Email, MARITALSTATUS MaritalStatus, String Password, String Address , String city, int PINCODE, String State, int PhoneNumber , int Salary , LocalDate jobStartDate , String dutyTiming){
        super(id , Name , FatherName , DateOfBirth , Age , Gender , Email , MaritalStatus , Password , Address , city , PINCODE , State , PhoneNumber , Salary , jobStartDate , dutyTiming, EmployeeRole.SECURITYMANAGER);
    }
}

