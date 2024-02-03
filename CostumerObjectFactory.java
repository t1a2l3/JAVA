package BusinessLogicLayer.ObjectsFactories;
import CostumerManagement.*;
import EmployeeManagement.*;

import java.time.LocalDate;

public class CostumerObjectFactory {
    public static Costumer Creation(Costumer.AccountType data , int id , String Name, String FatherName, LocalDate DateOfBirth, int Age, String Gender, String Email, Person.MARITALSTATUS MaritalStatus, String Address, String city, int PINCODE, String State, int PhoneNumber, double total_Balance, boolean is_Atm_Card, String password, boolean is_Locker, boolean check_book, String securityQuestion, int PIN, Costumer.RELIGION religion, double income, Costumer.EDUCATIONALQUALIFICATION education, Costumer.OCCUPATION occupation, boolean seniorCitizen, boolean existingAccount , LocalDate localDate ){
        switch (data){
            case SAVING -> { return new SAVINGACCOUNTCOSTUMER(id,Name , FatherName , DateOfBirth ,Age ,Gender ,Email , MaritalStatus , Address , city , PINCODE , State, PhoneNumber,total_Balance , is_Atm_Card , password , is_Locker , check_book , securityQuestion , PIN , religion , income, education , occupation , seniorCitizen , existingAccount , localDate);}
            case CHECKING -> { return new CHECKINGACCOUNTCOSTUMER(id,Name , FatherName , DateOfBirth ,Age,Gender ,Email , MaritalStatus , Address , city , PINCODE , State, PhoneNumber,total_Balance , is_Atm_Card , password , is_Locker , check_book , securityQuestion , PIN , religion , income, education , occupation , seniorCitizen , existingAccount , localDate);}
            default -> { return new FIXEDDEPOSITACCOUNTCOSTUMER(id,Name , FatherName , DateOfBirth ,Age,Gender ,Email , MaritalStatus , Address , city , PINCODE , State, PhoneNumber,total_Balance , is_Atm_Card , password , is_Locker , check_book , securityQuestion , PIN , religion , income, education , occupation , seniorCitizen , existingAccount ,2000);}
        }
    }
    public static Costumer Creation(Costumer.AccountType data , int id , String Name, String Email, String password, int PIN , int total_Balance , String securityQuestion){
        switch (data){
            case SAVING -> { return new SAVINGACCOUNTCOSTUMER(id,Name ,Email , password ,PIN,total_Balance, securityQuestion);}
            case CHECKING -> { return new CHECKINGACCOUNTCOSTUMER(id,Name, Email , password , PIN, total_Balance ,securityQuestion);}
            default -> { return new FIXEDDEPOSITACCOUNTCOSTUMER(id,Name,Email , password , PIN , total_Balance , 1000,securityQuestion);}
        }
    }
}

