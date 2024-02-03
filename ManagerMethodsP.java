package Presentation;

import BusinessLogicLayer.ObjectsFactories.EmployeeObjectFactory;
import CostumerManagement.Person;
import DataStorageLayer.EmployeeReadWrite;
import EXCEPTIONS.OwnExceptions;
import EmployeeManagement.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerMethodsP {
    public static void addEmployee(Scanner sc) throws Exception{
        System.out.print("Enter your Name : ");
        String name = OwnExceptions.stringinput();
        System.out.print("Enter the Name of Father : ");
        String fatherName = OwnExceptions.stringinput();
        System.out.print("Enter the Day : ");
        int day = OwnExceptions.integerinput();
        while(day < 0 || day > 30 ){
            System.out.println("Enter the Day between 1 and 30 : ");
            day = OwnExceptions.integerinput();
        }
        System.out.print("Enter the Month : ");
        int month = OwnExceptions.integerinput();
        while(month < 0 || month > 12 ){
            System.out.println("Enter the Day between 1 and 30 : ");
            month = OwnExceptions.integerinput();
        }
        System.out.print("Enter the Year : ");
        int year = OwnExceptions.integerinput();
        while(year < 1950 || year > 2023){
            System.out.println("Enter the Day between 1 and 30 : ");
            year = OwnExceptions.integerinput();
        }
        System.out.print("Enter the age : ");
        int age = OwnExceptions.integerinput();
        System.out.print("Enter Gender : ");
        String gender = OwnExceptions.stringinput();
        System.out.print("Enter Email : ");
        String email = OwnExceptions.gmailinput();
        System.out.print("Enter the Marital Status : ");
        String maritalStatus = OwnExceptions.stringinput();
        while(!(maritalStatus.equals("MARRIED") || maritalStatus.equals("UNMARRIED") || maritalStatus.equals("OTHER"))){
            maritalStatus = OwnExceptions.stringinput();
        }
        Person.MARITALSTATUS MaritalStatus = Person.MARITALSTATUS.valueOf(maritalStatus);
        System.out.print("Enter the password : ");
        String password = OwnExceptions.passwordinput();
        System.out.print("Enter the address : ");
        String Address = sc.next();
        System.out.print("Enter the city : ");
        String city = OwnExceptions.stringinput();
        System.out.print("Enter the PIN : ");
        int PINCODE = OwnExceptions.integerinput();
        System.out.print("Enter the State : ");
        String state = OwnExceptions.stringinput();
        System.out.print("Enter the phone Number : ");
        int phoneNumber = OwnExceptions.integerinput();
        System.out.print("Enter the Salary : ");
        int Salary = OwnExceptions.integerinput();
        LocalDate jobStartDate = LocalDate.now();
        System.out.print("Enter the duty timings : ");
        String dutyTime = sc.next();
        System.out.print("Enter the Role of Employee \n1. LOAN MANAGER \n2. LOCKER MANAGER \n3. ACCOUNT MANAGER\n4. RECIPIENT\n5. SECURITY MANAGER : ");
        int role = OwnExceptions.integerinput();
        while(role < 1 || role > 5){
            System.out.print("Enter the Role of Employee \n1. LOAN MANAGER \n2. LOCKER MANAGER \n3. ACCOUNT MANAGER\n4. RECIPIENT\n5. SECURITY MANAGER : ");
            System.out.print("\nPlease enter between 1 and 5 : ");
            role = OwnExceptions.integerinput();
        }
        Employee employee = EmployeeObjectFactory.Creation(role , 1 , name , fatherName , LocalDate.of(year , month , day) , age , gender , email , MaritalStatus , password , Address , city , PINCODE , state , phoneNumber , Salary , jobStartDate , dutyTime);
        EmployeeReadWrite.EmployeeSaving(employee);
    }
    public static void displayEmployees() throws Exception{
        ArrayList<Employee> arrayList = new ArrayList<>();
        arrayList = (ArrayList<Employee>) EmployeeReadWrite.EmployeeRead();
        System.out.println("1. MANAGERS : ");
        for(Employee array : arrayList){
            if(array instanceof MANAGER){
                System.out.println(array);
            }
        }
        System.out.println("2. LOAN MANAGERS : ");
        for(Employee array : arrayList){
            if(array instanceof LOANMANAGER){
                System.out.println(array);
            }
        }
        System.out.println("3. LOCKER MANAGERS : ");
        for(Employee array : arrayList){
            if(array instanceof LOCKERMANAGER){
                System.out.println(array);
            }
        }
        System.out.println("4. SECURITY MANAGERS : ");
        for(Employee array : arrayList){
            if(array instanceof SECURITYMANAGER){
                System.out.println(array);
            }
        }
        System.out.println("5. RECIPIENT : ");
        for(Employee array : arrayList){
            if(array instanceof RECIPIENT){
                System.out.println(array);
            }
        }
        System.out.println("6. ACCOUNT MANAGERS : ");
        for(Employee array : arrayList){
            if(array instanceof ACCOUNTMANAGER){
                System.out.println(array);
            }
        }
    }
}