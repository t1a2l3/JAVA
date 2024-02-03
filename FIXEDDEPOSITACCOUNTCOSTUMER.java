package CostumerManagement;

import java.time.LocalDate;

public class FIXEDDEPOSITACCOUNTCOSTUMER extends Costumer {
        private double interestRate = 0.05;
        private LocalDate maturityDate;
        private LocalDate localDate ;
        private LocalDate currentDate = LocalDate.now();
        private int withdrawalLimit = 0; // Example: No withdrawals allowed until maturity
        private int fixedDeposit ;
        private int totalbalanceaftermaturitydate ;
        public FIXEDDEPOSITACCOUNTCOSTUMER(int id , String Name, String FatherName, LocalDate DateOfBirth,int Age, String Gender, String Email, Person.MARITALSTATUS MaritalStatus, String Address, String city, int PINCODE, String State, int PhoneNumber, double total_Balance, boolean is_Atm_Card, String password, boolean is_Locker, boolean check_book, String securityQuestion, int PIN, Costumer.RELIGION religion, double income, Costumer.EDUCATIONALQUALIFICATION education, Costumer.OCCUPATION occupation, boolean seniorCitizen, boolean existingAccount ,int fixedDeposit) {
            super(id , Name , FatherName , DateOfBirth ,Age, Gender , Email , MaritalStatus ,Address , city , PINCODE , State , PhoneNumber , total_Balance , is_Atm_Card , password , is_Locker , check_book , securityQuestion , PIN , religion , income , education , occupation , seniorCitizen , existingAccount);
            this.maturityDate = currentDate.plusYears(3);
            this.fixedDeposit = fixedDeposit;
            totalbalanceaftermaturitydate = (int) (36 * fixedDeposit + (36*fixedDeposit*interestRate));
        }

        public FIXEDDEPOSITACCOUNTCOSTUMER(int counter, String Name, String Email, String Password, int PIN, double total_Balance,int fixedDeposit,String securityQuestion) {
            super(counter, Name, Email, Password, PIN , total_Balance, securityQuestion);
            this.localDate = LocalDate.now();
            this.fixedDeposit = fixedDeposit;
            totalbalanceaftermaturitydate = (int) (36 * fixedDeposit + (36*fixedDeposit*interestRate));
        }
        public void payfixeddeposit(double fixeddeposit){
            if(fixeddeposit == this.fixedDeposit){
                this.setTotal_Balance(this.getTotal_Balance() + fixeddeposit);
                localDate = currentDate;
                System.out.println("Your fee is deposited!!!");
            }else{
                System.out.println("Please Enter the right amount and try again(Note: Your fixed deposit is not submitted)");
            }
        }
        public void checkfixeddeposit(){
            if(localDate.getMonthValue() != currentDate.getMonthValue()){
                System.out.println("Please submit your monthly fixed deposit");
            }
        }
        public LocalDate getMaturityDate() {
            return maturityDate;
        }

        public void setMaturityDate(LocalDate maturityDate) {
            this.maturityDate = maturityDate;
        }

        public LocalDate getLocalDate() {
            return localDate;
        }

        public void setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
        }

        public LocalDate getCurrentDate() {
            return currentDate;
        }

        public void setCurrentDate(LocalDate currentDate) {
            this.currentDate = currentDate;
        }

        @Override
        public int getWithdrawalLimit() {
            return withdrawalLimit;
        }

        public void setWithdrawalLimit(int withdrawalLimit) {
            this.withdrawalLimit = withdrawalLimit;
        }

        public int getFixedDeposit() {
            return fixedDeposit;
        }

        public void setFixedDeposit(int fixedDeposit) {
            this.fixedDeposit = fixedDeposit;
        }

        public double getInterestRate() {
            return interestRate;
        }

        @Override
        public String toString() {
            return super.toString() +
                    "interestRate=" + interestRate +
                    ", maturityDate=" + maturityDate +
                    ", withdrawalLimit=" + withdrawalLimit +
                    ", fixedDeposit=" + fixedDeposit;
        }
}
