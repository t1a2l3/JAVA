package BusinessLogicLayer.CostumerOperations;

import CostumerManagement.Costumer;
import CostumerServices.Challan;
import DataStorageLayer.TransactionHistory;

public class ChallanMethodsB {
    public static void writingTransactionHistory(String bill, Costumer costumer) throws Exception{
        String parts[] = bill.split(" " , 4);
        Object obj = new Challan(parts[0] , parts[1] + " " + parts[2] , Integer.parseInt(parts[3]));
        TransactionHistory.writingTransactionHistory(costumer , obj);
    }
}
