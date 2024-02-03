package LOANPACKAGE;

import java.io.Serializable;

public class Loan implements Serializable {
    private int cosId ;
    private int loanId;
    private double loanAmount;
    private int months;
    private int monthlyPayment;
    public enum LoanStatus {PENDING , APPROAVED , REJECTED};
    private LoanStatus loanStatus;

    public Loan(int cosId, int loanId, double loanAmount, int months , int monthlyPayment) {
        this.cosId = cosId;
        this.loanId = loanId;
        this.loanAmount = loanAmount;
        this.months = months;
        this.monthlyPayment = monthlyPayment;
        this.loanStatus = LoanStatus.PENDING;
    }

    public int getCosId() {
        return cosId;
    }

    public int getLoanId() {
        return loanId;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public int getMonths() {
        return months;
    }

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "cosId=" + cosId +
                ", loanId=" + loanId +
                ", loanAmount=" + loanAmount +
                ", months=" + months +
                ", monthly payment= " + monthlyPayment +
                ", loan status= " + loanStatus +
                '}';
    }
}
