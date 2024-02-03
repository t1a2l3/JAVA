package BusinessLogicLayer.EmployeeServices;
import ATMPackage.AtmCard;
import BusinessLogicLayer.CostumerAccessoriesB.AtmMethodsB;
import CHECKBOOKPackage.CheckBook;
import CostumerManagement.*;
import DataStorageLayer.CostumerDataStorage;
import DataStorageLayer.VAULTSMethods;
import Presentation.*;
import BusinessLogicLayer.CostumerAccessoriesB.*;
import Presentation.CostumerAccessories.*;


import java.time.LocalDate;
import java.util.Scanner;

public class AccountManagerServicesB {
    public static int AccountCreationSaving(Scanner sc, int creationChoice) throws Exception{
        AtmCard ATM = null;
        Costumer account = null;
        if(creationChoice == 1){
            // Take Complete Data from User.
            account = AccountManagerMethodsCreateReadDeleteAccountsP.SmallAccountCreation(sc);
        }else{
            // Take Only Five Parameters from User.
            account = AccountManagerMethodsCreateReadDeleteAccountsP.SmallAccountCreation(sc);
        }
        if (account.isIs_Atm_Card()) {
            account.setATM(new AtmCard(account.getName(),account.getAccountNumber() ,  account.getPIN(), AtmMethodsB.generateRandomATMCardNumber(), Presentation.CostumerAccessories.AtmMethodsP.generatingCardType(), LocalDate.now().plusYears(10), 40000, account.getTotal_Balance()));
        }
        if (account.isCheck_book()) {
            account.setCHECKBOOK(new CheckBook(account.getAccountNumber(), CheckBookMethodsB.generateRandomCheckbookID(), 100, account.getName()));
        }
        if(account.isIs_Locker()){
            String locker_type = VAULTSMethodsP.lockerType();
            VAULTSMethods.AssignLocker(locker_type ,account);
        }
        return CostumerDataStorage.savingDataInFile(account);
    }
    public static void AccountDisplay(int dataChoice) throws Exception{
        switch (dataChoice){
            case 1 -> AccountManagerMethodsCreateReadDeleteAccountsP.savingAccountDisplaying();
            case 2-> AccountManagerMethodsCreateReadDeleteAccountsP.checkingAccountDisplaying();
            case 3 -> AccountManagerMethodsCreateReadDeleteAccountsP.fixedDepositAccountDisplaying();
            case 4 -> AccountManagerMethodsCreateReadDeleteAccountsP.allAccountDisplaying();
            default -> AccountManagerMethodsCreateReadDeleteAccountsP.allAccountLessDataDisplaying();
        }
    }
}

