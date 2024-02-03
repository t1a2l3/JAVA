package Presentation;

import BusinessLogicLayer.CostumerUpdationB;
import BusinessLogicLayer.CostumerOperations.FundsMethodsB;
import BusinessLogicLayer.WithdrawB;
import CostumerManagement.Costumer;
import EXCEPTIONS.OwnExceptions;

import java.util.ArrayList;

public class fundsTransferP {
    public static void TransferingFund(Costumer costumer, ArrayList<String> arrayList) throws Exception{
        System.out.print("Enter the number corresponding to Organization : ");
        int organization = OwnExceptions.integerinput();
        while(organization < 1 || organization > 5){
            System.out.print("Enter between 1 and 5 : ");
            organization = OwnExceptions.integerinput();
        }
        System.out.println(arrayList.get(organization-1));
        System.out.print("Enter the amount you want to Fund : ");
        int amount = OwnExceptions.integerinput();
        System.out.print("Enter the password to transfer Fund : ");
        int PIN = OwnExceptions.integerinput();
        if(PIN == costumer.getPIN()){
            FundsMethodsB.writingTransactionHistory(arrayList.get(organization-1) , amount, costumer);
            int returned = WithdrawB.withdraw(amount , costumer);
            if(returned == 1){
                System.out.println("Funds transferred");
                CostumerUpdationB.AccountUpdation(costumer);
                System.out.println("Your Remaining balance is : " + costumer.getTotal_Balance());
                System.out.println("Your Remaining withdrawal limit is : " + costumer.getWithdrawalLimit());
            }else if(returned == 0){
                System.out.println("Your do not have sufficient money in your account");
            } else {
                System.out.println("Your Withdrawal limit is exeeded");
            }
        }else{
            System.out.println("Incorrect PIN!!!");
        }
    }
}
