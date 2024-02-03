package CostumerServices;

import java.io.Serializable;
import java.time.LocalDate;

class Transaction implements Serializable {
    enum TRASACTION {CHECK , WITHDRAW , TRANSFER};
    private LocalDate DateandTime;
    private TRASACTION TransactionType;
    private double ammount ;
    enum DESCRIPTION {FAMILYSUPPORT , EDUCATION , FEE , ZAKAT , FUND , OTHERS};
    private DESCRIPTION description;
    private String accountNumber;
    public Transaction(String accountNumber,LocalDate dateandTime, TRASACTION transactionType, double ammount, DESCRIPTION description) {
        this.accountNumber = accountNumber;
        DateandTime = dateandTime;
        TransactionType = transactionType;
        this.ammount = ammount;
        this.description = description;
    }


    public LocalDate getDateandTime() {
        return DateandTime;
    }

    public TRASACTION getTransactionType() {
        return TransactionType;
    }

    public double getAmmount() {
        return ammount;
    }

    public DESCRIPTION getDescription() {
        return description;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "AccountNumber=" + accountNumber +
                ", DateandTime=" + DateandTime +
                ", TransactionType=" + TransactionType +
                ", ammount=" + ammount +
                ", description=" + description +
                '}';
    }
}
