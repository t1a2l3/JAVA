package CHECKBOOKPackage;

import java.io.Serializable;
import java.util.Random;

public class CheckBook implements Serializable {
    private final  int CheckBookid ;
    private String accountNumber;
    private int EndingCheckNumber;
    private int StartingCheckNumber;
    private String CheckBookNumber;
    private int TotalChecks;
    private String costumeraccountNumber;
    private String CostumerName;
    private static int counter = 0;
    private Check[] checks = new Check[100];

    public CheckBook(String accountNumber , String checkBookNumber, int totalChecks, String costumerName) {
        CheckBookid = ++counter;
        StartingCheckNumber = 0;
        EndingCheckNumber = TotalChecks;
        CheckBookNumber = checkBookNumber;
        TotalChecks = totalChecks;
        costumeraccountNumber = this.accountNumber;
        CostumerName = costumerName;
        this.accountNumber = accountNumber;
        for(int i = 1 ; i < 100 ; i++){
            checks[i] = new Check(i);
        }
    }

    private String getAccountNumber(){
        return accountNumber;
    }
    public int getTotalChecks() {
        return TotalChecks;
    }

    public void setTotalChecks(int totalChecks) {
        TotalChecks = totalChecks;
    }

    public int getCheckBookid() {
        return CheckBookid;
    }

    public String getCheckBookNumber() {
        return CheckBookNumber;
    }

    public String getCostumeraccountNumber() {
        return costumeraccountNumber;
    }

    public String getCostumerName() {
        return CostumerName;
    }

    @Override
    public String toString() {
        return "CheckBook{" +
                "CheckBookid=" + CheckBookid +
                ", accountNumber='" + accountNumber + '\'' +
                ", CheckBookNumber='" + CheckBookNumber + '\'' +
                ", TotalChecks=" + TotalChecks +
                ", costumeraccountNumber='" + costumeraccountNumber + '\'' +
                ", CostumerName='" + CostumerName + '\'' +
                '}';
    }
}
