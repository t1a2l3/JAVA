package BusinessLogicLayer;

import CostumerManagement.CHECKINGACCOUNTCOSTUMER;
import CostumerManagement.FIXEDDEPOSITACCOUNTCOSTUMER;
import CostumerManagement.SAVINGACCOUNTCOSTUMER;
import DataStorageLayer.CostumerDataRead;

import java.util.ArrayList;

public class CostumerGmailB {
    public static boolean gmail(String emailId) throws Exception{
        ArrayList<SAVINGACCOUNTCOSTUMER> savingaccountcostumers = CostumerDataRead.savingAccountData();
        for(SAVINGACCOUNTCOSTUMER savingaccountcostumer : savingaccountcostumers){
            if(savingaccountcostumer.getEmailAdress().equals(emailId)){
                return true;
            }
        }
        ArrayList<CHECKINGACCOUNTCOSTUMER> checkingaccountcostumers = CostumerDataRead.checkingAccountData();
        for(CHECKINGACCOUNTCOSTUMER checkingaccountcostumer : checkingaccountcostumers){
            if(checkingaccountcostumer.getEmailAdress().equals(emailId)){
                return true;
            }
        }
        ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER> fixeddepositaccountcostumers = CostumerDataRead.fixedDepositAccountData();
        for(FIXEDDEPOSITACCOUNTCOSTUMER fixeddepositaccountcostumer : fixeddepositaccountcostumers){
            if(fixeddepositaccountcostumer.getEmailAdress().equals(emailId)){
                return true;
            }
        }
        return false;
    }
}
