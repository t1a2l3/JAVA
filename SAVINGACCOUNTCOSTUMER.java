package CostumerManagement;

import java.time.LocalDate;

public class SAVINGACCOUNTCOSTUMER extends Costumer {

        private double interestRate = 0.04;
        private int withdrawalLimit = 5; // Example monthly withdrawal limit
        private LocalDate localDate;

        public SAVINGACCOUNTCOSTUMER(int id , String Name, String FatherName, LocalDate DateOfBirth,int Age, String Gender, String Email, Person.MARITALSTATUS MaritalStatus, String Address, String city, int PINCODE, String State, int PhoneNumber, double total_Balance, boolean is_Atm_Card, String password, boolean is_Locker, boolean check_book, String securityQuestion, int PIN, Costumer.RELIGION religion, double income, Costumer.EDUCATIONALQUALIFICATION education, Costumer.OCCUPATION occupation, boolean seniorCitizen, boolean existingAccount , LocalDate localDate) {
            super(id , Name , FatherName , DateOfBirth ,Age, Gender , Email , MaritalStatus ,Address , city , PINCODE , State , PhoneNumber , total_Balance + total_Balance * 0.04 , is_Atm_Card , password , is_Locker , check_book , securityQuestion , PIN , religion , income , education , occupation , seniorCitizen , existingAccount);
            this.localDate = localDate;
        }
        public SAVINGACCOUNTCOSTUMER(int id ,String Name, String FatherName, LocalDate DateOfBirth,int Age , String Gender, String Email, Person.MARITALSTATUS MaritalStatus, String Address, String city, int PINCODE, String State, int PhoneNumber, double total_Balance, boolean is_Atm_Card, String password, boolean is_Locker, boolean check_book, String securityQuestion, int PIN, Costumer.RELIGION religion, double income, Costumer.EDUCATIONALQUALIFICATION education, Costumer.OCCUPATION occupation, boolean seniorCitizen, boolean existingAccount) {
            super(id , Name , FatherName , DateOfBirth ,Age, Gender , Email , MaritalStatus ,Address , city , PINCODE , State , PhoneNumber , total_Balance + total_Balance * 0.04 , is_Atm_Card , password , is_Locker , check_book , securityQuestion , PIN , religion , income , education , occupation , seniorCitizen , existingAccount);
            this.localDate = LocalDate.now();
        }
        public SAVINGACCOUNTCOSTUMER(int id, String Name, String Email, String Password, int PIN, double total_Balance,String securityQuestion) {
            super(id , Name , Email , Password , PIN ,total_Balance,securityQuestion);
            this.localDate = LocalDate.now();
        }
        @Override
        public int getWithdrawalLimit() {
            return withdrawalLimit;
        }
        public void setWithdrawalLimit(int withdrawalLimit) {
            this.withdrawalLimit = withdrawalLimit;
        }
        private LocalDate CurrentDate = LocalDate.now();

        @Override
        public String toString() {
            return super.toString() +
                    "interestRate=" + interestRate +
                    ", withdrawalLimit=" + withdrawalLimit;
        }

    public LocalDate getLocaldate() {
        return localDate;
    }
    public void setLocalDate(LocalDate date){
        this.localDate = date;
    }
}
