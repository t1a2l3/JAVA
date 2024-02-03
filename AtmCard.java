package ATMPackage;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class AtmCard implements Serializable {
    private final int id;
    private static int counter = 0;
    private String OwnerName ;
    private int OwnerId;
    private int PIN;
    private String CardNumber ;
    public enum CARDTYPE {VISACARD , MASTERCARD , DEBITCARD , CREDITCARD , VIRTUALCARD};
    private CARDTYPE CardType;
    private LocalDate Expiry_Date;
    private double Credit_Limit;
    private double Current_Balance;
    private String ownerAccNumber;

    public AtmCard(String ownerName,String ownerAccNumber, int PIN, String cardNumber, CARDTYPE cardType, LocalDate expiry_Date, double credit_Limit, double current_Balance) {
        id = ++counter;
        OwnerName = ownerName;
        this.PIN = PIN;
        CardNumber = cardNumber;
        CardType = cardType;
        Expiry_Date = expiry_Date;
        Credit_Limit = credit_Limit;
        Current_Balance = current_Balance;
        this.ownerAccNumber = ownerAccNumber;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public int getPIN() {
        return PIN;
    }

    public void setPIN(int PIN) {
        this.PIN = PIN;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public CARDTYPE getCardType() {
        return CardType;
    }

    public void setCardType(CARDTYPE cardType) {
        CardType = cardType;
    }

    public LocalDate getExpiry_Date() {
        return Expiry_Date;
    }

    public void setExpiry_Date(LocalDate expiry_Date) {
        Expiry_Date = expiry_Date;
    }

    public double getCredit_Limit() {
        return Credit_Limit;
    }

    public void setCredit_Limit(double credit_Limit) {
        Credit_Limit = credit_Limit;
    }

    public double getCurrent_Balance() {
        return Current_Balance;
    }

    public void setCurrent_Balance(double current_Balance) {
        Current_Balance = current_Balance;
    }

    @Override
    public String toString() {
        return "AtmCard{" +
                "OwnerName='" + OwnerName + '\'' +
                "Account Number= " + ownerAccNumber + '\'' +
                ", OwnerId=" + OwnerId +
                ", PIN=" + PIN +
                ", CardNumber='" + CardNumber + '\'' +
                ", CardType=" + CardType +
                ", Expiry_Date=" + Expiry_Date +
                ", Credit_Limit=" + Credit_Limit +
                ", Current_Balance=" + Current_Balance +
                '}';
    }
}

