package CostumerManagement;

import java.io.*;
import java.time.LocalDate;

import ATMPackage.*;
import BusinessLogicLayer.CostumerAccessoriesB.AtmMethodsB;
import BusinessLogicLayer.CostumerAccessoriesB.CheckBookMethodsB;
import CHECKBOOKPackage.CheckBook;
import DataStorageLayer.VAULTSMethods;
import VAULTPackage.Locker;

import static BusinessLogicLayer.CostumerAccessoriesB.CosAccNumCreationB.generateRandomAccountNumber;
import static java.lang.Integer.parseInt;

public class Costumer extends Person implements Serializable{
    private double Total_Balance;
    private boolean Is_Atm_Card;
    private String Password;
    private boolean Is_Locker;
    private boolean Check_book;
    private String SecurityQuestion ;
    private AtmCard ATM;
    private Locker LOCKER;
    private int POSTALCODE;
    public enum RELIGION {ISLAM , HINDU , CHRISTIANS , SIKH};
    private RELIGION Religion;
    private double Income ;
    public enum EDUCATIONALQUALIFICATION {BACHELORS , MASTERS, MPHIL, PHD};
    private EDUCATIONALQUALIFICATION Education;
    public enum OCCUPATION {SALARIED , SELFEMPLOYEE , UNEMPLOYEED , STUDENT};
    private OCCUPATION Occupation;
    private boolean SeniorCitizen ;
    private boolean ExistingAccount;
    private String AccountNumber;
    private CheckBook CHECKBOOK;

    private final int id;
    public enum AccountType {SAVING , CHECKING ,FIXEDDEPOSIT};
    public Costumer(int id, String Name, String FatherName, LocalDate DateOfBirth, int Age, String Gender, String Email, MARITALSTATUS MaritalStatus, String Address, String city, int PIN, String State, int PhoneNumber, double total_Balance, boolean is_Atm_Card, String password, boolean is_Locker, boolean check_book, String securityQuestion, int POSTALCODE, RELIGION religion, double income, EDUCATIONALQUALIFICATION education, OCCUPATION occupation, boolean seniorCitizen, boolean existingAccount) {
        super(Name, FatherName, DateOfBirth,Age,Gender, Email, MaritalStatus, Address, city, PIN, State, PhoneNumber);
        this.id = id;
        Total_Balance = total_Balance;
        Is_Atm_Card = is_Atm_Card;
        Password = password;
        Is_Locker = is_Locker;
        Check_book = check_book;
        SecurityQuestion = securityQuestion;
        this.POSTALCODE = POSTALCODE;
        Religion = religion;
        Income = income;
        Education = education;
        Occupation = occupation;
        SeniorCitizen = seniorCitizen;
        ExistingAccount = existingAccount;
        AccountNumber = generateRandomAccountNumber();
        if(is_Atm_Card == true){
            setATM(new AtmCard(this.getName() ,this.AccountNumber, this.getPIN() , AtmMethodsB.generateRandomATMCardNumber() , Presentation.CostumerAccessories.AtmMethodsP.generatingCardType() , LocalDate.now().plusYears(10), 40000 , this.getTotal_Balance()));
        }
        if(check_book){
            this.setCHECKBOOK(new CheckBook(AccountNumber , CheckBookMethodsB.generateRandomCheckbookID() , 100 , this.getName()));
        }
        if(isIs_Locker()){
            VAULTSMethods.AssignLocker("SINGLEKEY" ,this);
        }
    }
    public Costumer(int id , String Name, String Email, String Password, int PIN, double total_Balance,String securityQuestion) {
        super(Name, Email , PIN);
        this.id = id;
        this.Password = Password;
        this.Total_Balance = total_Balance;
        this.setSecurityQuestion(securityQuestion);
        AccountNumber = generateRandomAccountNumber();
    }


    public void addbalance(int ammount){
        this.setTotal_Balance(this.getTotal_Balance() + ammount);
    }
    public void withdraw(double ammounttowithdraw){
        System.out.println("withdraw method in Costumer Class");
    }
    public String getAccountNumber() {
        return AccountNumber;
    }

    public CheckBook getCHECKBOOK() {
        return CHECKBOOK;
    }
    public void setCHECKBOOK(CheckBook CHECKBOOK) {
        this.CHECKBOOK = CHECKBOOK;
    }

    public void setAccountNumber(String accountNumber) {
        this.AccountNumber = accountNumber;
    }
    public double getTotal_Balance() {
        return Total_Balance;
    }
    public Locker getLOCKER() {
        return LOCKER;
    }
    public void setLOCKER(Locker LOCKER) {
        this.LOCKER = LOCKER;
    }
    public void setTotal_Balance(double total_Balance) {
        Total_Balance = total_Balance;
    }

    public boolean isIs_Atm_Card() {
        return Is_Atm_Card;
    }

    public void setIs_Atm_Card(boolean is_Atm_Card) {
        Is_Atm_Card = is_Atm_Card;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isIs_Locker() {
        return Is_Locker;
    }

    public void setIs_Locker(boolean is_Locker) {
        Is_Locker = is_Locker;
    }

    public boolean isCheck_book() {
        return Check_book;
    }

    public void setCheck_book(boolean check_book) {
        Check_book = check_book;
    }

    public String getSecurityQuestion() {
        return SecurityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        SecurityQuestion = securityQuestion;
    }

    public int getPOSTALCODE() {
        return POSTALCODE;
    }

    public void setPOSTALCODE(int POSTALCODE) {
        this.POSTALCODE = POSTALCODE;
    }

    public RELIGION getReligion() {
        return Religion;
    }

    public void setReligion(RELIGION religion) {
        Religion = religion;
    }

    public double getIncome() {
        return Income;
    }

    public void setIncome(double income) {
        Income = income;
    }

    public EDUCATIONALQUALIFICATION getEducation() {
        return Education;
    }

    public void setEducation(EDUCATIONALQUALIFICATION education) {
        Education = education;
    }

    public OCCUPATION getOccupation() {
        return Occupation;
    }

    public void setOccupation(OCCUPATION occupation) {
        Occupation = occupation;
    }

    public boolean isSeniorCitizen() {
        return SeniorCitizen;
    }

    public void setSeniorCitizen(boolean seniorCitizen) {
        SeniorCitizen = seniorCitizen;
    }

    public boolean isExistingAccount() {
        return ExistingAccount;
    }

    public void setExistingAccount(boolean existingAccount) {
        ExistingAccount = existingAccount;
    }

    public AtmCard getATM() {
        return ATM;
    }

    public void setATM(AtmCard ATM) {
        this.ATM = ATM;
    }

    public int getWithdrawalLimit() {
        return 0;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return  super.toString() +
                ", Id= " + id +
                ", Total_Balance=" + Total_Balance +
                ", Is_Atm_Card=" + Is_Atm_Card +
                ", Password='" + Password + '\'' +
                ", Is_Locker=" + Is_Locker +
                ", Check_book=" + Check_book +
                ", SecurityQuestion='" + SecurityQuestion + '\'' +
                ", ATM=" + ATM +
                ", LOCKER=" + LOCKER +
                ", POSTALCODE=" + POSTALCODE +
                ", Religion=" + Religion +
                ", Income=" + Income +
                ", Education=" + Education +
                ", Occupation=" + Occupation +
                ", SeniorCitizen=" + SeniorCitizen +
                ", ExistingAccount=" + ExistingAccount +
                ", AccountNumber='" + AccountNumber +
                ", CHECKBOOK=" + CHECKBOOK;
    }
}
