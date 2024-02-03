package Presentation;

import BusinessLogicLayer.EmployeeServices.AccountManagerServicesB;
import CostumerManagement.*;
import EXCEPTIONS.*;
import DataStorageLayer.*;
import BusinessLogicLayer.ObjectsFactories.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class AccountManagerMethodsCreateReadDeleteAccountsP {
    /*----------------------------------- Methods to Create account of Costumer  ---------------------------------------------*/
    public static void costumerAccountCreation(Scanner sc){
        try {
            System.out.print("Which Type of Account You Want To Open \n1. Full \n2. 5 Argument : ");
            int creationChoice = OwnExceptions.integerinput();
            while(creationChoice < 1 && creationChoice > 2){
                creationChoice = OwnExceptions.integerinput();
            }
            int savingmessage = AccountManagerServicesB.AccountCreationSaving(sc, creationChoice);
            switch (savingmessage){
                case 1 -> System.out.println("Saving Account is Opened and data is saved in File");
                case 2 -> System.out.println("Checking Account is Opened and data is saved in File");
                case 3 -> System.out.println("Fixed Deposit Account is Opened and data is saved in File");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    // Complete Object Data Method.
    public static Costumer FullAccountCreation(Scanner sc) throws Exception {
        System.out.print("Enter type of Account for User : ");
        String accounttype = OwnExceptions.stringinput();
        while (!(accounttype.equals("SAVING") || accounttype.equals("CHECKING") || accounttype.equals("FIXEDDEPOSIT"))) {
            System.out.print("Enter type of Account for User : ");
            accounttype = OwnExceptions.stringinput();
        }
        Costumer.AccountType accountType = Costumer.AccountType.valueOf(accounttype);
        try {
//            System.out.print("Enter Your Name for Your Account : ");
//            String name = OwnExceptions.stringinput();
//
//            System.out.print("Enter the Name of Your Father : ");
//            String FatherName = OwnExceptions.stringinput();
//
//            System.out.print("Enter the date of Your Date of Birth : ");
//            int day = OwnExceptions.integerinput();
//            while ((day < 1 || day > 30)) {
//                System.out.print("Enter the date between 1 and 30 : ");
//                day = OwnExceptions.integerinput();
//            }
//            System.out.print("Enter the month of Your Date of Birth : ");
//            int month = OwnExceptions.integerinput();
//            while ((month < 1 || month > 12)) {
//                System.out.println("Enter the month between 1 and 12 : ");
//                month = OwnExceptions.integerinput();
//            }
//            System.out.print("Enter the year of Your Date of Birth : ");
//            int year = OwnExceptions.integerinput();
//            while (year < 1980 || year > LocalDate.now().getYear()) {
//                System.out.print("Enter the 4 digit integer for year : ");
//                year = OwnExceptions.integerinput();
//            }
//            LocalDate dateofbirth = LocalDate.of(year, month, day);
//
//            System.out.print("Enter your Age : ");
//            int Age = OwnExceptions.integerinput();
//
//            System.out.print("Enter your Gender : ");
//            String Gender = OwnExceptions.stringinput();
//
//            System.out.print("Enter Your Email Id : ");
//            String email = OwnExceptions.gmailinput();
//            while(CostumerGmail.gmail(email)){
//                System.out.print("Email already exists please choose another Email Id : ");
//                email = OwnExceptions.gmailinput();
//            }
//
//            System.out.println("Enter Your Marital Status 1) UNMARRIED 2) MARRIED 3) OTHER");
//            String maritalstatus = OwnExceptions.stringinput();
//            Person.MARITALSTATUS MaritalStatus = Person.MARITALSTATUS.OTHER;
//            boolean maritalfound = false;
//            while (!maritalfound) {
//                if (maritalstatus.equals("UNMARRIED") || maritalstatus.equals("MARRIED") || maritalstatus.equals("OTHER")) {
//                    MaritalStatus = Person.MARITALSTATUS.valueOf(maritalstatus);
//                    maritalfound = true;
//                } else {
//                    System.out.println("Enter Your Marital Status 1) UNMARRIED 2) MARRIED 3) OTHER");
//                    maritalstatus = OwnExceptions.stringinput();
//                }
//            }
//            System.out.println("Enter the address of your Home without space : ");
//            String address = OwnExceptions.stringinput();
//
//            System.out.println("Enter your city Name : ");
//            String city = OwnExceptions.stringinput();
//
//            System.out.println("Enter postal Code of your area: ");
//            int postalcode = OwnExceptions.integerinput();
//            System.out.println("Enter your state Name : ");
//            String state = sc.next();
//
//            System.out.println("Enter your mobile Number : ");
//            int PhoneNumber = OwnExceptions.integerinput();
//
//            System.out.println("Enter your initial deposit : ");
//            int InitialDeposit = OwnExceptions.integerinput();
//
//            System.out.println("Do You Need Atm Card ? ");
//            boolean isatm = sc.nextBoolean();
//
//            System.out.println("Enter the Password : ");
//            String password = OwnExceptions.passwordinput();
//
//            System.out.println("Do You Need Locker : ");
//            boolean islocker = sc.nextBoolean();
//
//            System.out.println("Do You Want Check Book : ");
//            boolean ischeckbook = sc.nextBoolean();
//
//            System.out.println("Enter the Security Question : ");
//            String question = OwnExceptions.stringinput();
//
//            System.out.println("Enter the PIN for Your Account : ");
//            int PIN = OwnExceptions.integerinput();
//
//            System.out.println("Enter your Religion : 1) ISLAM 2) SIKH 3) CHRISTIANS 4) HINDU");
//            String religion = OwnExceptions.stringinput();
//            Costumer.RELIGION Religion = Costumer.RELIGION.ISLAM;
//            boolean religionflag = false;
//            while (!religionflag) {
//                if (religion.equals("ISLAM") || religion.equals("CHRISTIANS") || religion.equals("SIKH") || religion.equals("HINDU")) {
//                    Religion = Costumer.RELIGION.valueOf(religion);
//                    religionflag = true;
//                } else {
//                    System.out.println("Enter your Religion : 1) ISLAM 2) SIKH 3) CHRISTIANS 4) HINDU");
//                    religion = OwnExceptions.stringinput();
//                }
//            }
//            System.out.println("Enter your monthly income : ");
//            double income = sc.nextDouble();
//
//            System.out.println("Enter your Qualification Level :  1) BACHELORS 2) PHD 3) MASTERS 4) MPHIL");
//            String qualification = OwnExceptions.stringinput();
//            Costumer.EDUCATIONALQUALIFICATION Qualification = Costumer.EDUCATIONALQUALIFICATION.BACHELORS;
//            boolean qualificationflag = false;
//            while (!qualificationflag) {
//                if (qualification.equals("BACHELORS") || qualification.equals("PHD") || qualification.equals("MASTERS") || qualification.equals("MPHIL")) {
//                    Qualification = Costumer.EDUCATIONALQUALIFICATION.valueOf(qualification);
//                    qualificationflag = true;
//                } else {
//                    System.out.println("Enter your Qualification Level : 1) BACHELORS 2) PHD 3) MASTERS 4) MPHIL");
//                    qualification = sc.next();
//                }
//            }
//
//            System.out.println("Enter Your Occupation : 1) STUDENT 2) SALARIED 3) SELFEMPLOYEE 4) UNEMPLOYEED");
//            String occupation = OwnExceptions.stringinput();
//            Costumer.OCCUPATION Occupation = Costumer.OCCUPATION.STUDENT;
//            boolean occupationflag = false;
//            while (!occupationflag) {
//                if (occupation.equals("STUDENT") || occupation.equals("SALARIED") || occupation.equals("SELFEMPLOYEE") || occupation.equals("UNEMPLOYEED")) {
//                    Occupation = Costumer.OCCUPATION.valueOf(occupation);
//                    occupationflag = true;
//                } else {
//                    System.out.println("Enter Your Occupation : 1) STUDENT 2) SALARIED 3) SELFEMPLOYEE 4) UNEMPLOYEED");
//                    occupation = sc.next();
//                }
//            }
//
//            System.out.print("Are you are senior citizen : ");
//            boolean SeniorCitizen = sc.nextBoolean();
//            System.out.print("Can you have an Existing account : ");
//            boolean ExistingAccount = sc.nextBoolean();

//            Costumer account = ClientEmployeeAdder.createCostumerAccount(accounttype , name , FatherName , dateofbirth , Age , Gender , email , MaritalStatus , address , city , postalcode , state , PhoneNumber , InitialDeposit , isatm , password , locker , checkbook , question , PIN , Religion , income , Qualification , Occupation , SeniorCitizen , ExistingAccount);
            //  return Costumer account = CostumerObjectFactory.Creation(accountType , CounterReadWrite.Counter("COSTUMER") , name,FatherName , dateofbirth,Age , Gender , email , MaritalStatus , address , city , PIN , state , PhoneNumber , InitialDeposit , isatm ,password , islocker,ischeckbook , question , postalcode , Religion , income , Qualification , Occupation , SeniorCitizen , ExistingAccount, LocalDate.now());
            return CostumerObjectFactory.Creation(accountType , 1 , "Ahmed", "Sajid", LocalDate.of(2004, 03, 12), 19,"Male", "ahmedmalikcomputer@gmail.com", Person.MARITALSTATUS.UNMARRIED, "HOUSE200", "Lahore", 51480, "Punjab", 174393228, 100000, false, "AhmedOKay1", false, false, "None", 1234, Costumer.RELIGION.ISLAM, 400000, Costumer.EDUCATIONALQUALIFICATION.BACHELORS, Costumer.OCCUPATION.STUDENT, false, false, LocalDate.now());
        } catch (Exception e) {
            System.out.println(e);
        }
        throw new Exception();
    }
    // 5 Argument Object Data Method.

    public static Costumer SmallAccountCreation(Scanner sc) throws Exception {
        try {
            System.out.print("Enter type of Account for User : ");
            String accounttype = OwnExceptions.stringinput();
            while (!(accounttype.equals("SAVING") || accounttype.equals("CHECKING") || accounttype.equals("FIXEDDEPOSIT"))) {
                System.out.print("Enter type of Account for User : ");
                accounttype = OwnExceptions.stringinput();
            }
            Costumer.AccountType accountType = Costumer.AccountType.valueOf(accounttype);
//            System.out.print("Enter Your Name: ");
//            String name = OwnExceptions.stringinput();
//
//            System.out.print("Enter Your Email Id: ");
//            String email = OwnExceptions.gmailinput();
//            while(CostumerGmail.gmail(email)){
//                System.out.print("Email already exists please choose another Email Id : ");
//                email = OwnExceptions.gmailinput();
//            }
//            System.out.print("Enter the Password: ");
//            String password = OwnExceptions.passwordinput();
//
//            System.out.print("Enter Your Initial Deposit: ");
//            int initialDeposit = OwnExceptions.integerinput();
//
//            System.out.print("Enter the PIN for Your Account: ");
//            int pin = OwnExceptions.integerinput();
//            System.out.println("Enter the Security Question to Recover Your Account");
//            String SecurityQuestion = sc.next();
//            Costumer costumer =  CostumerObjectFactory.Creation(accountType,1,name, email ,password ,pin ,initialDeposit , SecurityQuestion);alizae4uonly@gmail.com
            Costumer costumer = CostumerObjectFactory.Creation(accountType,CounterReadWrite.Counter("COSTUMER"),"AliMalik", "abdulrehmansajid619@gmail.com" ,"password1" ,1212 ,50000 , "NO");
//            AccountCreationEmailSendingMethod.AccountConfirmationEmail(costumer);
            accountCreationEmailP.EmailSend(costumer.getName() , costumer.getEmailAdress() , costumer.getPassword() , costumer.getPIN());
            return costumer;
        }catch (Exception e){
            System.out.println("Error Occured while creating account of Costumer");
        }
        return null;
    }





    /*-----------------------------     Methods to Display the details of Costumer --------------------------------------------*/


    // Method use to display Costumers
    public static void costumerDataView(Scanner sc){
        try {
            System.out.print("Enter the Costumer Type whom Data you want to retrieve : \n1. Saving Account \n2. Checking Account \n3. Fixed Deposit Account \n4. All Costumers Data \n5. Display All But less Details : ");
            int dataChoice = OwnExceptions.integerinput();
            while(dataChoice < 1 || dataChoice > 5){
                System.out.print("Please Enter between 1 and 5 : ");
                dataChoice = OwnExceptions.integerinput();
            }
            AccountManagerServicesB.AccountDisplay(dataChoice);
        }catch (Exception e){
            System.out.println(e);
        }
    }



    // Displaying SAVING ACCOUNT Costumers
    public static void savingAccountDisplaying() throws Exception{
        System.out.println("Saving Account Costumers are : ");
        ArrayList<SAVINGACCOUNTCOSTUMER> arrayList = CostumerDataRead.savingAccountData();
        for(SAVINGACCOUNTCOSTUMER costumer : arrayList){
            System.out.println(costumer);
        }
    }

    // Displaying CHECKING ACCOUNT Costumers
    public static void checkingAccountDisplaying() throws Exception{
        System.out.println("Checking Account Costumers are : ");
        ArrayList<CHECKINGACCOUNTCOSTUMER> arrayList = CostumerDataRead.checkingAccountData();
        for(CHECKINGACCOUNTCOSTUMER costumer : arrayList){
            System.out.println(costumer);
        }
    }

    // Displaying FIXED DEPOSIT ACCOUNT Costumers
    public static void fixedDepositAccountDisplaying() throws Exception{
        System.out.println("Fixed Deposit Account Costumers are : ");
        ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER> arrayList = CostumerDataRead.fixedDepositAccountData();
        for(FIXEDDEPOSITACCOUNTCOSTUMER costumer : arrayList){
            System.out.println(costumer);
        }
    }


    // Displaying All Costumers
    public static void allAccountDisplaying() throws Exception{
        savingAccountDisplaying();
        System.out.println();
        checkingAccountDisplaying();
        System.out.println();
        fixedDepositAccountDisplaying();
    }


    // Displaying All costumers Less Information
    public static void allAccountLessDataDisplaying() throws Exception{
        savingAccountLessDisplaying();
        System.out.println();
        checkingAccountLessDisplaying();
        System.out.println();
        fixedDepositAccountLessDisplaying();
    }

    // Displaying SAVING ACCOUNT Costumers less information
    private static void savingAccountLessDisplaying() throws Exception{
        System.out.println("Saving Account Costumers are : ");
        ArrayList<SAVINGACCOUNTCOSTUMER> arrayList = CostumerDataRead.savingAccountData();
        for(SAVINGACCOUNTCOSTUMER costumer : arrayList){
            System.out.println("Name : " + costumer.getName() + ", Age : " + costumer.getAge() + ", Account Balance : " + costumer.getTotal_Balance() + ", PIN : " + costumer.getPIN() + ", Password : " + costumer.getPassword());
        }
    }

    // Displaying CHECKING ACCOUNT Costumers less information
    private static void checkingAccountLessDisplaying() throws Exception{
        System.out.println("Checking Account Costumers are : ");
        ArrayList<CHECKINGACCOUNTCOSTUMER> arrayList = CostumerDataRead.checkingAccountData();
        for(CHECKINGACCOUNTCOSTUMER costumer : arrayList){
            System.out.println(costumer);
        }
    }

    // Displaying FIXED DEPOSIT ACCOUNT Costumers less information
    private static void fixedDepositAccountLessDisplaying() throws Exception{
        System.out.println("Fixed Deposit Account Costumers are : ");
        ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER> arrayList = CostumerDataRead.fixedDepositAccountData();
        for(FIXEDDEPOSITACCOUNTCOSTUMER costumer : arrayList){
            System.out.println(costumer);
        }
    }


    // Method to delete Costumer Account    --------------------------------------------------------------------------------------------
    public static int deleteAccount() throws Exception{
        allAccountDisplaying();
        System.out.println("Enter the id of Costumer You Want to Delete : ");
        int id = OwnExceptions.integerinput();
        ArrayList<SAVINGACCOUNTCOSTUMER> savingaccountcostumers =CostumerDataRead.savingAccountData();
        boolean conditon = false;
        for(SAVINGACCOUNTCOSTUMER savingaccountcostumer : savingaccountcostumers){
            if(savingaccountcostumer.getId() == id){
                savingaccountcostumers.remove(savingaccountcostumer);
                conditon = true;
            }
        }
        if(conditon){
            CostumerDataStorage.savingUpdatedDataInFileS(savingaccountcostumers);
            return 1;
        }
        ArrayList<CHECKINGACCOUNTCOSTUMER> checkingaccountcostumers =CostumerDataRead.checkingAccountData();
        for(CHECKINGACCOUNTCOSTUMER checkingaccountcostumer : checkingaccountcostumers){
            if(checkingaccountcostumer.getId() == id){
                checkingaccountcostumers.remove(checkingaccountcostumer);
                conditon = true;
            }
        }
        if(conditon){
            CostumerDataStorage.savingUpdatedDataInFileC(checkingaccountcostumers);
            return 1;
        }
        ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER> fixeddepositaccountcostumers =CostumerDataRead.fixedDepositAccountData();
        for(FIXEDDEPOSITACCOUNTCOSTUMER fixeddepositaccountcostumer : fixeddepositaccountcostumers){
            if(fixeddepositaccountcostumer.getId() == id){
                fixeddepositaccountcostumers.remove(fixeddepositaccountcostumer);
                conditon = true;
            }
        }
        if(conditon){
            CostumerDataStorage.savingUpdatedDataInFileF(fixeddepositaccountcostumers);
            return 1;
        }
        return 0;
    }


}
