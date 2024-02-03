package BusinessLogicLayer.CostumerOperations;

import CostumerManagement.*;
import DataStorageLayer.CostumerDataRead;

import java.util.ArrayList;

public class CostumerLoginB {
    public static SAVINGACCOUNTCOSTUMER LoginSavingAccount(String Gmail , String Password) throws Exception{
        ArrayList<SAVINGACCOUNTCOSTUMER> arrayList;
        arrayList = CostumerDataRead.savingAccountData();
        for(SAVINGACCOUNTCOSTUMER costumer : arrayList){
            if(costumer.getEmailAdress().equals(Gmail)){
                if(costumer.getPassword().equals(Password)){
                    return costumer;
                }
            }
        }
        return null;
    }
    public static CHECKINGACCOUNTCOSTUMER LoginCheckingAccount(String Gmail , String Password) throws Exception{
        ArrayList<CHECKINGACCOUNTCOSTUMER> arrayList;
        arrayList = CostumerDataRead.checkingAccountData();
        for(CHECKINGACCOUNTCOSTUMER costumer : arrayList){
            if(costumer.getEmailAdress().equals(Gmail)){
                if(costumer.getPassword().equals(Password)){
                    return costumer;
                }
            }
        }
        return null;
    }
    public static FIXEDDEPOSITACCOUNTCOSTUMER LoginFixedDepositAccount(String Gmail , String Password) throws Exception{
        ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER> arrayList;
        arrayList = CostumerDataRead.fixedDepositAccountData();
        for(FIXEDDEPOSITACCOUNTCOSTUMER costumer : arrayList){
            if(costumer.getEmailAdress().equals(Gmail)){
                if(costumer.getPassword().equals(Password)){
                    return costumer;
                }
            }
        }
        return null;
    }
}
