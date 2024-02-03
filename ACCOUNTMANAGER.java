package EmployeeManagement;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

public class ACCOUNTMANAGER extends Employee{
    public ACCOUNTMANAGER(int id , String Name , String FatherName, LocalDate DateOfBirth, int Age, String Gender , String Email, MARITALSTATUS MaritalStatus, String Password, String Address , String city, int PINCODE, String State, int PhoneNumber , int Salary , LocalDate jobStartDate , String dutyTiming){
        super(id , Name , FatherName , DateOfBirth , Age , Gender , Email , MaritalStatus , Password , Address , city , PINCODE , State , PhoneNumber ,  Salary , jobStartDate , dutyTiming, EmployeeRole.ACCOUNTMANAGER);
    }
}


