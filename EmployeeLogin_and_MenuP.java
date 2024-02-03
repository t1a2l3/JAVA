package Presentation;

import DataStorageLayer.EmployeeReadWrite;
import EXCEPTIONS.OwnExceptions;
import EmployeeManagement.*;
import Presentation.CostumerAccessories.VAULTSMethodsP;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeLogin_and_MenuP {
    public static void employeeLogin(Scanner sc) throws Exception{
        Employee employee= EmployeeLogin_and_MenuP.employeeLoginDetailsGetting();
        if(employee == null){
            System.out.println("Either the Gmail or the password is Wrong\nExiting Program!!!");
            return;
        }
        System.out.print("Press 1 to Updata Data\nPress 2 to Visit UserMenu : ");
        int UserChoice = OwnExceptions.integerinput();
        if(UserChoice == 1){
            DataChangeCosandEmpP.employeeDataChange(new Scanner(System.in) , employee);
        }else {
            employeeMenu(employee);
        }
    }
    private static void employeeMenu(Employee employee) throws Exception{
        Scanner sc = new Scanner(System.in);
        if(employee instanceof MANAGER){

        } else if (employee instanceof LOCKERMANAGER) {
            System.out.print("Locker Manager : Press 1 to display vault\n Press 0 to exit : ");
            int employeeChoice = OwnExceptions.integerinput();
            while(!(employeeChoice == 1 || employeeChoice == 0)){
                System.out.print("Enter either 1 and 0 : ");
                employeeChoice = OwnExceptions.integerinput();
            }
            while(employeeChoice != 0) {
                if (employeeChoice == 1) {
                    VAULTSMethodsP.displayVault();
                } else {
                    return;
                }
                System.out.print("Press 1 to display vault\n Press 0 to exit : ");
                employeeChoice = OwnExceptions.integerinput();
            }
        }
        else if (employee instanceof LOANMANAGER) {
            System.out.print("Loan Manager.\n1. Press 1 to Approve loan \n2. Press 2 to reject Loan \n3. Press 3 to Check loans \n 4. Press 0 to exit: ");
            int employeeChoice = OwnExceptions.integerinput();
            while(!(employeeChoice == 0 || employeeChoice == 1 || employeeChoice == 2 || employeeChoice == 3 || employeeChoice == 4 || employeeChoice == 5)){
                System.out.print("Enter either 1, 2, 3, 4 and 5 : ");
                employeeChoice = OwnExceptions.integerinput();
            }
            while(employeeChoice != 0) {
                switch (employeeChoice) {
                    case 1 -> LoanMethodsP.approvingLoan();
                    case 2 -> LoanMethodsP.rejectingLoan();
                    case 3 -> LoanMethodsP.displayLoans();
                }
                System.out.print("1. Press 1 to Approve loan \n2. Press 2 to reject Loan \n3. Press 3 to Check loans \n 4. Press 0 to exit: ");
                employeeChoice = OwnExceptions.integerinput();
            }
        }
        else if (employee instanceof SECURITYMANAGER) {

        } else if (employee instanceof ACCOUNTMANAGER) {
            System.out.print("Account Manager.\nPress 0 to exit\nPress 1 to Add Costumers\nPress 2 to Display Costumers \n Press 3 to Delete Costumer Account : ");
            int employeeChoice = OwnExceptions.integerinput();
            while (employeeChoice != 0) {
                while (!(employeeChoice == 0 || employeeChoice == 1 || employeeChoice == 2 || employeeChoice == 3)) {
                    System.out.print("Enter either 1,2 or 3 : ");
                    employeeChoice = OwnExceptions.integerinput();
                }
                if (employeeChoice == 1) {
                    AccountManagerMethodsCreateReadDeleteAccountsP.costumerAccountCreation(sc);
                } else if (employeeChoice == 2) {
                    AccountManagerMethodsCreateReadDeleteAccountsP.costumerDataView(sc);
                } else {
                    if (AccountManagerMethodsCreateReadDeleteAccountsP.deleteAccount() == 1) {
                        System.out.println("Account is Deleted Successfully");
                    } else {
                        System.out.println("Account Not Found!!!");
                    }
                }
                System.out.print("Press 1 to Add Costumers\nPress 2 to Display Costumers \n Press 3 to Delete Costumer Account : ");
                employeeChoice = OwnExceptions.integerinput();
            }
        }
    }
    private static Employee employeeLoginDetailsGetting() throws Exception{
        ArrayList<Employee> arrayList = new ArrayList<>();
        System.out.print("Enter your Email Id : ");
        String emailId = OwnExceptions.gmailinput();
        System.out.print("Enter your Password : ");
        String password = OwnExceptions.passwordinput();
        arrayList = EmployeeReadWrite.EmployeeRead();
        for(Employee array : arrayList){
            if(array.getEmailAdress().equals(emailId)){
                if(array.getPassword().equals(password)){
                    System.out.println("Logged In");
                    return array;
                }
            }
        }
        return null;
    }
}
