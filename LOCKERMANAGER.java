package EmployeeManagement;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class LOCKERMANAGER extends Employee{
    public LOCKERMANAGER(int id , String Name , String FatherName, LocalDate DateOfBirth, int Age, String Gender , String Email, MARITALSTATUS MaritalStatus, String Password, String Address , String city, int PINCODE, String State, int PhoneNumber , int Salary , LocalDate jobStartDate , String dutyTiming){
        super(id , Name , FatherName , DateOfBirth , Age , Gender , Email , MaritalStatus , Password , Address , city , PINCODE , State , PhoneNumber , Salary , jobStartDate , dutyTiming, EmployeeRole.LOCKERMANAGER);
    }
}

