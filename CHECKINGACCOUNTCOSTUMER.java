package CostumerManagement;

import java.time.LocalDate;

public class CHECKINGACCOUNTCOSTUMER extends Costumer{
        private double overdraftLimit = 1000.0;
        private int withdrawalLimit = 10; // Example monthly withdrawal limit for checking account
        private LocalDate localdate ;
        private LocalDate currentDate = LocalDate.now();

        public CHECKINGACCOUNTCOSTUMER(int id , String Name, String FatherName, LocalDate DateOfBirth,int Age, String Gender, String Email, Person.MARITALSTATUS MaritalStatus, String Address, String city, int PINCODE, String State, int PhoneNumber, double total_Balance, boolean is_Atm_Card, String password, boolean is_Locker, boolean check_book, String securityQuestion, int PIN, Costumer.RELIGION religion, double income, Costumer.EDUCATIONALQUALIFICATION education, Costumer.OCCUPATION occupation, boolean seniorCitizen, boolean existingAccount , LocalDate date) {
            super(id , Name , FatherName , DateOfBirth ,Age, Gender , Email , MaritalStatus ,Address , city , PINCODE , State , PhoneNumber , total_Balance , is_Atm_Card , password , is_Locker , check_book , securityQuestion , PIN , religion , income , education , occupation , seniorCitizen , existingAccount);
            this.localdate = date;
        }

        public CHECKINGACCOUNTCOSTUMER(int id, String Name, String Email, String Password, int PIN, double total_Balance, String securityQuestion) {
            super(id, Name,Email, Password , PIN , total_Balance, securityQuestion);
            this.localdate = LocalDate.now();
        }
        @Override
        public int getWithdrawalLimit() {
            return withdrawalLimit;
        }

        public void setWithdrawalLimit(int withdrawalLimit) {
            this.withdrawalLimit = withdrawalLimit;
        }

        public double getOverdraftLimit() {
            return overdraftLimit;
        }

        public LocalDate getLocaldate() {
            return localdate;
        }
        public void setLocaldate(LocalDate date){
            localdate = date;
        }

        public LocalDate getCurrentDate() {
            return currentDate;
        }
        @Override
        public String toString() {
            return super.toString() +
                    "overdraftLimit=" + overdraftLimit +
                    ", withdrawalLimit=" + withdrawalLimit;
        }
    }
