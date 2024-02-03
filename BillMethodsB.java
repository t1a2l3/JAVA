package BusinessLogicLayer.CostumerOperations;

import BusinessLogicLayer.ObjectsFactories.BillObjectFactory;
import CostumerManagement.Costumer;
import DataStorageLayer.TransactionHistory;

import java.util.ArrayList;

public class BillMethodsB {
    public static String checkingandreturingbill(ArrayList<String> bills , String billId){
        for(String bill : bills){
            String[] parts = bill.split(" " , 4);
            if(parts[0].equals(billId)){
                return bill;
            }
        }
        return null;
    }
    public static void writingTransactionHistory(int billChoice , String bill, Costumer costumer) throws Exception{
        String parts[] = bill.split(" " , 4);
        Object obj = BillObjectFactory.Creation(billChoice , parts[0] , parts[1] + " " + parts[2] , parts[3]);
        TransactionHistory.writingTransactionHistory(costumer , obj);
    }
}
