package Presentation;

import CostumerManagement.Costumer;
import DataStorageLayer.CounterReadWrite;
import DataStorageLayer.LoanReadWrite;
import EXCEPTIONS.OwnExceptions;
import LOANPACKAGE.Loan;

import java.util.ArrayList;

public class LoanMethodsP {
    // A Costumer Can Apply For loan using this Method
    public static void ApplyingforLoan(int amount ,Costumer costumer) throws Exception{
        System.out.print("For how many months you need Loan : ");
        int month = OwnExceptions.integerinput();
        double InterestRate;
        while(month < 1){
            System.out.println("Please Enter the duration greater then or equal to 1 month!");
            month = OwnExceptions.integerinput();
        }
        if (month <= 12) {
            InterestRate = 0.04; // 8% per month
        } else if (month > 12 && month <= 24) {
            InterestRate = 0.06; // 6% per month
        } else {
            InterestRate = 0.08; // 4% per month
        }
        System.out.println("The Interest Rate on this loan is : " + (InterestRate*amount)/month + " per month");
        int monthlyPayment =(int) ((amount / month) + (amount * InterestRate)/month);
        double interest = (InterestRate*amount);
        Loan loan = new Loan(costumer.getId() , CounterReadWrite.Counter("LOAN"), amount+interest , month , monthlyPayment);
        LoanReadWrite.applyingForLoan(loan);
    }
    // A Loan Manager Can Approve or reject loans using these methods
    public static void approvingLoan() throws Exception{
        ArrayList<Loan> Loans = LoanReadWrite.pendingLoanData();
        for(Loan loan : Loans){
            System.out.println(loan);
        }
        System.out.print("Enter the Id of Loan to approve : ");
        int LoanId = OwnExceptions.integerinput();
        LoanReadWrite.approvingLoan(LoanId , Loans);
    }
    public static void rejectingLoan() throws Exception{
        ArrayList<Loan> Loans = LoanReadWrite.pendingLoanData();
        for(Loan loan : Loans){
            System.out.println(loan);
        }
        System.out.print("Enter the Id of Loan to reject : ");
        int LoanId = OwnExceptions.integerinput();
        LoanReadWrite.rejectingLoan(LoanId , Loans);
    }
    // Method to display all type of loans
    public static void displayLoans(){
        try {
            System.out.print("Enter corresponding Number \n1. PendingLoans \n2. Approaved Loans \n3. Rejected Loans : ");
            int loanChoice = OwnExceptions.integerinput();
            while (loanChoice < 1 || loanChoice > 3) {
                System.out.print("Enter the Number between 1 to 3 : ");
                loanChoice = OwnExceptions.integerinput();
            }
            LoanReadWrite.displayLoans(loanChoice);
        }catch (Exception e){
            System.out.println("Error Occured while Reading");
        }
    }
}
