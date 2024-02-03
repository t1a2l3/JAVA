package BusinessLogicLayer;

import CostumerManagement.CHECKINGACCOUNTCOSTUMER;
import CostumerManagement.Costumer;
import CostumerManagement.FIXEDDEPOSITACCOUNTCOSTUMER;
import CostumerManagement.SAVINGACCOUNTCOSTUMER;
import DataStorageLayer.CostumerDataRead;
import DataStorageLayer.CostumerDataStorage;

import java.util.ArrayList;

public class CostumerUpdationB {
    public static void AccountUpdation(Costumer costumer) throws Exception{
        if(costumer instanceof SAVINGACCOUNTCOSTUMER){
            SAVINGACCOUNTCOSTUMER cos = (SAVINGACCOUNTCOSTUMER) costumer ;
            ArrayList<SAVINGACCOUNTCOSTUMER> costumers = savingAccountUpdation(cos);
            CostumerDataStorage.savingUpdatedDataInFileS(costumers);
        }else if(costumer instanceof CHECKINGACCOUNTCOSTUMER){
            CHECKINGACCOUNTCOSTUMER cos = (CHECKINGACCOUNTCOSTUMER) costumer;
            ArrayList<CHECKINGACCOUNTCOSTUMER> costumers = checkingAccountUpdation(cos);
            CostumerDataStorage.savingUpdatedDataInFileC(costumers);
        }else{
            FIXEDDEPOSITACCOUNTCOSTUMER cos = (FIXEDDEPOSITACCOUNTCOSTUMER) costumer;
            ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER> costumers = fixedDepositAccountUpdation(cos);
            CostumerDataStorage.savingUpdatedDataInFileF(costumers);
        }
    }
    private static ArrayList<SAVINGACCOUNTCOSTUMER> savingAccountUpdation(SAVINGACCOUNTCOSTUMER Obj) throws Exception {
        ArrayList<SAVINGACCOUNTCOSTUMER> list = CostumerDataRead.savingAccountData();
        int counter = 0;
        for (SAVINGACCOUNTCOSTUMER li : list) {
            if(Obj.getId() == li.getId()){
                list.set(counter, Obj);
                break;
            }
            counter++;
        }
        return list;
    }
    private static ArrayList<CHECKINGACCOUNTCOSTUMER> checkingAccountUpdation(CHECKINGACCOUNTCOSTUMER Obj) throws Exception {
        ArrayList<CHECKINGACCOUNTCOSTUMER> list = CostumerDataRead.checkingAccountData();
        int counter = 0;
        for (CHECKINGACCOUNTCOSTUMER li : list) {
            if(Obj.getId() == li.getId()){
                list.set(counter, Obj);
                break;
            }
            counter++;
        }
        return list;
    }
    private static ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER> fixedDepositAccountUpdation(FIXEDDEPOSITACCOUNTCOSTUMER Obj) throws Exception {
        ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER> list = CostumerDataRead.fixedDepositAccountData();
        int counter = 0;
        for (FIXEDDEPOSITACCOUNTCOSTUMER li : list) {
            if(Obj.getId() == li.getId()){
                list.set(counter, Obj);
                break;
            }
            counter++;
        }
        return list;
    }

}
