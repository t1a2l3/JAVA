package Presentation;

import BusinessLogicLayer.CostumerOperations.ChallanMethodsB;
import BusinessLogicLayer.CostumerOperations.CostumerLoginB;
import BusinessLogicLayer.CostumerUpdationB;
import BusinessLogicLayer.CostumerOperations.BillMethodsB;
import BusinessLogicLayer.WithdrawB;
import CostumerManagement.Costumer;
import DataStorageLayer.BillsDataReadWrite;
import DataStorageLayer.FundsDataRead;
import DataStorageLayer.TransactionHistory;
import EXCEPTIONS.OwnExceptions;
import java.util.ArrayList;
import java.util.Scanner;
public class CostumerLoginMenu_and_PayMethodsP {
    public static  void costumerLogin(Scanner sc){
        try {
            System.out.print("Enter your Account Type : \n1. Saving Account \n2. Checking Account \n3. Fixed Deposit Account : ");
            int dataChoice = OwnExceptions.integerinput();
            while(dataChoice < 1 || dataChoice > 3){
                System.out.print("Please Enter between 1 and 4 : ");
                dataChoice = OwnExceptions.integerinput();
            }
            Costumer account = LogingfromFile(dataChoice);
            if(account != null){
                System.out.println("Logged In!!!");
                CostumerLoginMenu_and_PayMethodsP.CostumerMenu(account);
            }else {
                CostumerForgotPasswordP.fogetPasswordMain();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    private static Costumer LogingfromFile(int AccountChoice) throws Exception{
        Costumer account ;
        System.out.print("Enter Your Gmail : ");
        String Gmail = OwnExceptions.gmailinput();
        System.out.print("Enter Your Password : ");
        String Password = OwnExceptions.passwordinput();
        switch (AccountChoice){
            case 1 -> account =  CostumerLoginB.LoginSavingAccount(Gmail , Password);
            case 2 -> account =  CostumerLoginB.LoginCheckingAccount(Gmail , Password);
            default -> account = CostumerLoginB.LoginFixedDepositAccount(Gmail , Password);
        }
        return account;
    }
    private static void CostumerMenu(Costumer costumer){
        try {
            System.out.println("Welcome Back!!!");
            System.out.print("Enter Corresponding Number\n1. Pay Bill\n2. Pay Challan\n3. Transfer Funds\n4. Apply for Loan \n5. Check transaction History \n6. Change Data : ");
            int costumerChoice = OwnExceptions.integerinput();
            while(costumerChoice != 0) {
                switch (costumerChoice) {
                    case 1 -> payBill(costumer);
                    case 2 -> payChallan(costumer);
                    case 3 -> transferFunds(costumer);
                    case 4 -> applyLoan(costumer);
                    case 5 -> TransactionHistory.displayTransactionHistory(costumer);
                    case 6 -> DataChangeCosandEmpP.costumerDataChange(new Scanner(System.in) , costumer);
                    // Make Method For Transaction
                }
                System.out.print("Enter Corresponding Number\n1. Pay Bill\n2. Pay Challan\n3. Transfer Funds\n4. Apply for Loan \n5. Check transaction History \n6. Change Data : ");
                costumerChoice = OwnExceptions.integerinput();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    private static void applyLoan(Costumer costumer) throws Exception{
        System.out.print("Enter the Loan amount : ");
        int amount = OwnExceptions.integerinput();
        while(amount < 1000){
            System.out.print("Please enter the Minimum amount greater than 1000 : ");
            amount = OwnExceptions.integerinput();
        }
        LoanMethodsP.ApplyingforLoan(amount , costumer);
    }
    private static void payBill(Costumer costumer) {
        try {
            System.out.print("Enter the corresponding number for Bill Type\n1. ELECTRICITY BILL\n2. GAS BILL\n3. WATER BILL\n4. INTERNET BILL\n5. TELEPHONE BILL : ");
            int billtype = OwnExceptions.integerinput();
            while(billtype < 1 || billtype > 5){
                System.out.print("Please Enter Number between 1 and 5 : ");
                billtype = OwnExceptions.integerinput();
            }
            CostumerLoginMenu_and_PayMethodsP.payBill(costumer , billtype);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    private static void payBill(Costumer costumer , int billChoice) throws Exception{
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arrayList = BillsDataReadWrite.gettingToPayBillData(billChoice);
        if(arrayList.size() != 0){
            System.out.println("Enter the id of Your Bill : ");
            String billId = sc.next();
            String bill = BillMethodsB.checkingandreturingbill(arrayList , billId);
            if(bill != null){
                System.out.println(bill);
                System.out.print("Enter the PIN to pay the Bill : ");
                int PIN = OwnExceptions.integerinput();
                if(PIN == costumer.getPIN()){
                    arrayList.remove(bill);
                    BillsDataReadWrite.updatingPaidBillFile(billChoice , bill);
                    BillsDataReadWrite.updatingToPayBillData(billChoice , arrayList);
                    String parts[] = bill.split(" " , 4);
                    int returned = WithdrawB.withdraw(Double.parseDouble(parts[3]) , costumer);
                    if(returned == 1){
                        CostumerUpdationB.AccountUpdation(costumer);
                        System.out.println("Bill is Paid SuccessFully");
                        System.out.println("Your Remaining balance is : " + costumer.getTotal_Balance());
                        System.out.println("Your Remaining withdrawal limit is : " + costumer.getWithdrawalLimit());
                    }else if(returned == 0){
                        System.out.println("Your do not have sufficient money in your account");
                    } else {
                        System.out.println("Your Withdrawal limit is exeeded");
                    }
                    BillMethodsB.writingTransactionHistory(billChoice,bill,costumer);
                }else{
                    System.out.println("You Entered wrong PIN!!!");
                }
            }else{
                arrayList.clear();
                arrayList = BillsDataReadWrite.gettingPaidBillsDataToSayPay(billChoice);
                bill = BillMethodsB.checkingandreturingbill(arrayList , billId);
                if(bill != null){
                    System.out.println("Bill is already paid");
                }
                else {
                    System.out.println("Bill is not Found!!!");
                }
            }
        }
    }
    private static void payChallan(Costumer costumer){
        try {
            System.out.print("Enter the Id of Challan : ");
            int challanid = OwnExceptions.integerinput();
            ArrayList<String> arrayList = ChallanPayP.challanData();
            String challan = ChallanPayP.getChallan(challanid , arrayList);
            if(challan!= null) {
                System.out.println(challan);
                System.out.print("Enter PIN : ");
                int PIN = OwnExceptions.integerinput();
                if (PIN == costumer.getPIN()) {
                    ChallanPayP.updatingPaidFile(challan);
                    ChallanPayP.updatingchallanData(challan,arrayList);
                    ChallanMethodsB.writingTransactionHistory(challan,costumer);
                    String parts[] = challan.split(" " , 4);
                    int returned = WithdrawB.withdraw(Double.parseDouble(parts[3]) , costumer);
                    if(returned == 1){
                        CostumerUpdationB.AccountUpdation(costumer);
                        System.out.println("Challan Paid");
                        System.out.println("Your Remaining balance is : " + costumer.getTotal_Balance());
                        System.out.println("Your Remaining withdrawal limit is : " + costumer.getWithdrawalLimit());
                    }else if(returned == 0){
                        System.out.println("Your do not have sufficient money in your account");
                    } else {
                        System.out.println("Your Withdrawal limit is exeeded");
                    }
                }else{
                    System.out.println("Incorrect PIN");
                }
            }else{
                System.out.println("Challan not found!!!");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    private static void transferFunds(Costumer costumer) throws Exception{
        System.out.println("The Organizations are : ");
        ArrayList<String> arrayList = FundsDataRead.transferFundsData();
        for(String account : arrayList){
            System.out.println(account);
        }
        fundsTransferP.TransferingFund(costumer , arrayList);
    }
}

