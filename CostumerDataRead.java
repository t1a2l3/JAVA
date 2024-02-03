package DataStorageLayer;

import CostumerManagement.Costumer;
import CostumerManagement.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CostumerDataRead{
    // These are Methods are used to read the data of costumers from corresponding files and then return to the Presentation layer
    public static ArrayList<SAVINGACCOUNTCOSTUMER> savingAccountData() throws Exception{
        File file = new File("ACCOUNTS/savingaccounts.txt");
        ArrayList<SAVINGACCOUNTCOSTUMER> arrayList = new ArrayList<>();
        if(file.isFile()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            arrayList =(ArrayList<SAVINGACCOUNTCOSTUMER>) ois.readObject();
            ois.close();
        }
        return arrayList;
    }
    public static ArrayList<CHECKINGACCOUNTCOSTUMER> checkingAccountData() throws Exception{
        File file = new File("ACCOUNTS/checkingaccounts.txt");
        ArrayList<CHECKINGACCOUNTCOSTUMER> arrayList = new ArrayList<>();
        if(file.isFile()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            arrayList =(ArrayList<CHECKINGACCOUNTCOSTUMER>) ois.readObject();
            ois.close();
        }
        return arrayList;
    }
    public static ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER> fixedDepositAccountData() throws Exception{
        File file = new File("ACCOUNTS/fixeddepositaccounts.txt");
        ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER> arrayList = new ArrayList<>();
        if(file.isFile()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            arrayList =(ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER>) ois.readObject();
            ois.close();
        }
        return arrayList;
    }
}
