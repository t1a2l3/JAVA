package Presentation;

import BusinessLogicLayer.CostumerUpdationB;
import BusinessLogicLayer.EmployeeUpdationB;
import CostumerManagement.Costumer;
import EXCEPTIONS.OwnExceptions;
import EmployeeManagement.Employee;

import java.util.Scanner;

public class DataChangeCosandEmpP {
    public static void costumerDataChange(Scanner sc, Costumer costumer) throws Exception{
        System.out.println("Press 1 to Change Your Name \nPress 2 to Change your Password \nPress 3 to Change your PIN: ");
        int changeChoice = sc.nextInt();
        switch (changeChoice){
            case 1 ->{
                System.out.print("Enter your New Name : ");
                String name = OwnExceptions.stringinput();
                costumer.setName(name);
            }
            case 2 ->{
                boolean flag = false;
                while(!flag) {
                    System.out.println("Enter your New Password : ");
                    String password1 = OwnExceptions.passwordinput();
                    System.out.println("Enter the Confirm Password : ");
                    String password2 = OwnExceptions.passwordinput();
                    if (password1.equals(password2)) {
                        costumer.setPassword(password1);
                        flag = true;
                    }
                }
            }
            case 3 ->{
                boolean flag = false;
                while(!flag) {
                    System.out.println("Enter your New PIN : ");
                    int PIN1 = OwnExceptions.integerinput();
                    System.out.println("Enter the Confirm PIN : ");
                    int PIN2 = OwnExceptions.integerinput();
                    if (PIN1 == PIN2) {
                        costumer.setPIN(PIN1);
                        flag = true;
                    }
                }
            }
        }
        CostumerUpdationB.AccountUpdation(costumer);
    }
    public static void employeeDataChange(Scanner sc, Employee employee) throws Exception{
        System.out.println("Press 1 to Change Your Name \nPress 2 to Change your Password \nPress 3 to Change your PIN: ");
        int changeChoice = sc.nextInt();
        switch (changeChoice){
            case 1 ->{
                System.out.print("Enter your New Name : ");
                String name = OwnExceptions.stringinput();
                employee.setName(name);
            }
            case 2 ->{
                boolean flag = false;
                while(!flag) {
                    System.out.println("Enter your New Password : ");
                    String password1 = OwnExceptions.passwordinput();
                    System.out.println("Enter the Confirm Password : ");
                    String password2 = OwnExceptions.passwordinput();
                    if (password1.equals(password2)) {
                        employee.setPassword(password1);
                        flag = true;
                    }
                }
            }
            case 3 ->{
                boolean flag = false;
                while(!flag) {
                    System.out.println("Enter your New PIN : ");
                    int PIN1 = OwnExceptions.integerinput();
                    System.out.println("Enter the Confirm PIN : ");
                    int PIN2 = OwnExceptions.integerinput();
                    if (PIN1 == PIN2) {
                        employee.setPIN(PIN1);
                        flag = true;
                    }
                }
            }
        }
        EmployeeUpdationB.EmployeeUpdation(employee);
    }

}
