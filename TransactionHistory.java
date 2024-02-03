package DataStorageLayer;

import CostumerManagement.Costumer;

import java.io.*;
import java.util.ArrayList;

public class TransactionHistory {
//    public static void FileCreation(Costumer costumer) throws Exception{
//        File file = new File("./TRANSACTIONSHISTORY/" + costumer.getId() + ".txt");
//        if(!file.isFile()){
//        file.createNewFile();
//        }
//    }
    public static void writingTransactionHistory(Costumer costumer , Object transaction) throws Exception{
        ArrayList<Object> arrayList = transactionHistory(costumer);
        arrayList.add(transaction);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./TRANSACTIONSHISTORY/" + costumer.getId() + ".txt"));
        oos.writeObject(arrayList);
        oos.close();
    }
    public static ArrayList<Object> transactionHistory(Costumer costumer) throws Exception{
        File file = new File("./TRANSACTIONSHISTORY/" + costumer.getId() + ".txt");
        ArrayList<Object> arrayList = new ArrayList<>();
        if(file.isFile()) {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            arrayList = (ArrayList<Object>) ois.readObject();
            ois.close();
        }
        return arrayList;
    }
    public static void displayTransactionHistory(Costumer costumer) throws Exception{
        ArrayList<Object> arrayList = transactionHistory(costumer);
        for(Object array : arrayList){
            System.out.println(array);
        }
    }
}
