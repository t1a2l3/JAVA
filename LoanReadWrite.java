package DataStorageLayer;

import BusinessLogicLayer.CostumerAccessoriesB.LoanMethodsB;
import BusinessLogicLayer.CostumerUpdationB;
import CostumerManagement.Costumer;
import LOANPACKAGE.Loan;

import java.io.*;
import java.util.ArrayList;

public class LoanReadWrite {
    // Reading All data of Pending Loans and adding the new one
    public static void applyingForLoan(Loan loan) throws Exception{
        File file = new File("./LOANS/PendingLoans.txt");
        ArrayList<Loan> arrayList = new ArrayList<>();
        if(file.isFile()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            arrayList = (ArrayList<Loan>) ois.readObject();
            ois.close();
        }
        arrayList.add(loan);
        sendingLoanForApproavel(arrayList);
    }
    // Writing the pending loans data read by applyingforloan method
    private static void sendingLoanForApproavel(ArrayList<Loan> loans) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./LOANS/PendingLoans.txt"));
        oos.writeObject(loans);
        oos.close();
    }
    // Selecting loan file to display the loans on screen
    public static File selectingLoanFile(int choice){
        switch (choice){
            case 1 ->{ return new File("./LOANS/PendingLoans.txt");}
            case 2 ->{ return new File("./LOANS/ApproavedLoans.txt");}
            default ->{ return new File("./LOANS/RejectedLoans.txt");}
        }
    }
    // It is receiving that file and then displaying it on the screen
    public static void displayLoans(int choice) throws Exception{
        File file = selectingLoanFile(choice);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        ArrayList<Loan> loan = (ArrayList<Loan>) ois.readObject();
        for(Loan l : loan){
            System.out.println(l);
        }
    }
    // Reading Pending Loans data and returning for approval
    public static ArrayList<Loan> pendingLoanData() throws Exception{
        File file = new File("./LOANS/PendingLoans.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        ArrayList<Loan> Loans =(ArrayList<Loan>) ois.readObject();
        ois.close();
        return Loans;
    }
    // adding the approved loan
    private static void updatingApprovedData(Loan loan) throws Exception{
        File file = new File("./LOANS/ApproavedLoans.txt");
        ArrayList<Loan> arrayList = new ArrayList<>();
        if(file.isFile()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            arrayList = (ArrayList<Loan>) ois.readObject();
            ois.close();
        }
        arrayList.add(loan);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./LOANS/ApproavedLoans.txt"));
        oos.writeObject(arrayList);
        oos.close();
    }

    public static void approvingLoan(int loanid ,ArrayList<Loan> loans) throws Exception{
        for(Loan loan : loans){
            if(loanid == loan.getLoanId()){
                loans.remove(loan);
                loan.getCosId();
                Costumer costumer = LoanMethodsB.getCosByIdForApproval(loan.getCosId());
                System.out.println(costumer.getTotal_Balance());
                costumer.addbalance((int)loan.getLoanAmount());
                System.out.println(costumer.getTotal_Balance());
                CostumerUpdationB.AccountUpdation(costumer);
                loan.setLoanStatus(Loan.LoanStatus.APPROAVED);
                updatingPendingLoans(loans);
                updatingApprovedData(loan);
                return;
            }
        }
    }

    // Updaing Pending Loan and Data
    private static void updatingPendingLoans(ArrayList<Loan> loans) throws Exception{
        ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("./LOANS/PendingLoans.txt"));
        ois.writeObject(loans);
        ois.close();
    }
    public static void rejectingLoan(int loanid ,ArrayList<Loan> loans) throws Exception{
        for(Loan loan : loans){
            if(loanid == loan.getLoanId()){
                loans.remove(loan);
                loan.setLoanStatus(Loan.LoanStatus.REJECTED);
                updatingPendingLoans(loans);
                updatingRejectedData(loan);
                return;
            }
        }
    }
    private static void updatingRejectedData(Loan loan) throws Exception{
        File file = new File("./LOANS/RejectedLoans.txt");
        ArrayList<Loan> arrayList = new ArrayList<>();
        if(file.isFile()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            arrayList = (ArrayList<Loan>) ois.readObject();
            ois.close();
        }
        arrayList.add(loan);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./LOANS/RejectedLoans.txt"));
        oos.writeObject(arrayList);
        oos.close();
    }

}
