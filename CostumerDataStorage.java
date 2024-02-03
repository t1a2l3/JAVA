package DataStorageLayer;

import CostumerManagement.CHECKINGACCOUNTCOSTUMER;
import CostumerManagement.Costumer;
import CostumerManagement.FIXEDDEPOSITACCOUNTCOSTUMER;
import CostumerManagement.SAVINGACCOUNTCOSTUMER;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CostumerDataStorage {
    public static int savingDataInFile(Costumer accountObject) throws Exception{
        Scanner sc = new Scanner(System.in);
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

        // Saving Account Object
        if(accountObject instanceof SAVINGACCOUNTCOSTUMER){
            File file = new File("ACCOUNTS/savingaccounts.txt");
            SAVINGACCOUNTCOSTUMER object = (SAVINGACCOUNTCOSTUMER) accountObject;
            ArrayList<SAVINGACCOUNTCOSTUMER> arrayList = new ArrayList<>();
            if(file.isFile()){
                ois = new ObjectInputStream(new FileInputStream(file));
                arrayList = (ArrayList<SAVINGACCOUNTCOSTUMER>) ois.readObject();
                ois.close();
            }
            arrayList.add(object);
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(arrayList);
            return 1;
        }

        // Checking Account Object
        else if(accountObject instanceof CHECKINGACCOUNTCOSTUMER){
            File file = new File("ACCOUNTS/checkingaccounts.txt");
            CHECKINGACCOUNTCOSTUMER object = (CHECKINGACCOUNTCOSTUMER) accountObject;
            ArrayList<CHECKINGACCOUNTCOSTUMER> arrayList = new ArrayList<>();
            if(file.isFile()){
                ois = new ObjectInputStream(new FileInputStream(file));
                arrayList =(ArrayList<CHECKINGACCOUNTCOSTUMER>) ois.readObject();
                ois.close();
            }
            arrayList.add(object);
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(arrayList);
            oos.close();
            return 2;
        }
        // Fixed deposit Account
        else{
            FIXEDDEPOSITACCOUNTCOSTUMER object = (FIXEDDEPOSITACCOUNTCOSTUMER) accountObject;
            ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER> arrayList = new ArrayList<>();
            File file = new File("ACCOUNTS/fixeddepositaccounts.txt");
            if(file.isFile()){
                ois = new ObjectInputStream(new FileInputStream(file));
                arrayList =(ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER>) ois.readObject();
                ois.close();
            }
            oos = new ObjectOutputStream(new FileOutputStream(file));
            arrayList.add(object);
            oos.writeObject(arrayList);
            oos.close();
            return 3;
        }
    }
    public static void savingUpdatedDataInFileS(ArrayList<SAVINGACCOUNTCOSTUMER> data) throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ACCOUNTS/savingaccounts.txt"));
        oos.writeObject(data);
        oos.close();
    }
    public static void savingUpdatedDataInFileC(ArrayList<CHECKINGACCOUNTCOSTUMER> data) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ACCOUNTS/checkingaccounts.txt"));
        oos.writeObject(data);
        oos.close();
    }
    public static void savingUpdatedDataInFileF(ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER> data) throws Exception{
        ObjectOutputStream oos ;
        oos = new ObjectOutputStream(new FileOutputStream("ACCOUNTS/fixeddepositaccounts.txt"));
        oos.writeObject(data);
        oos.close();
    }

}
