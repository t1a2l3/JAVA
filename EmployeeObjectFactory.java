package BusinessLogicLayer.ObjectsFactories;
import CostumerManagement.Person;
import EmployeeManagement.Employee;
import com.sun.jdi.event.StepEvent;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeObjectFactory {
    public static Employee Creation(int ObjectChoice , int id , String Name , String FatherName, LocalDate DateOfBirth, int Age, String Gender , String Email, Person.MARITALSTATUS MaritalStatus, String Password, String Address , String city, int PINCODE, String State, int PhoneNumber , int Salary , LocalDate jobStartDate , String dutyTiming){
        switch (ObjectChoice){
            case 1 ->{return new EmployeeManagement.LOANMANAGER(id , Name , FatherName , DateOfBirth , Age , Gender , Email , MaritalStatus , Password , Address , city , PINCODE , State , PhoneNumber , Salary , jobStartDate , dutyTiming);}
            case 2 -> {return new EmployeeManagement.LOCKERMANAGER(id , Name , FatherName , DateOfBirth , Age , Gender , Email , MaritalStatus , Password , Address , city , PINCODE , State , PhoneNumber , Salary , jobStartDate , dutyTiming);}
            case 3 ->{return new EmployeeManagement.ACCOUNTMANAGER(id , Name , FatherName , DateOfBirth , Age , Gender , Email , MaritalStatus , Password , Address , city , PINCODE , State , PhoneNumber , Salary , jobStartDate , dutyTiming);}
            case 4 ->{return new EmployeeManagement.RECIPIENT(id , Name , FatherName , DateOfBirth , Age , Gender , Email , MaritalStatus , Password , Address , city , PINCODE , State , PhoneNumber , Salary , jobStartDate , dutyTiming);}
            case 5 ->{return new EmployeeManagement.SECURITYMANAGER(id , Name , FatherName , DateOfBirth , Age , Gender , Email , MaritalStatus , Password , Address , city , PINCODE , State , PhoneNumber , Salary , jobStartDate , dutyTiming);}
            default ->{return new EmployeeManagement.MANAGER(id , Name , FatherName , DateOfBirth , Age , Gender , Email , MaritalStatus , Password , Address , city , PINCODE , State , PhoneNumber , Salary , jobStartDate , dutyTiming);}
        }
    }
}

