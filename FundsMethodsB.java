package BusinessLogicLayer.CostumerOperations;

import CostumerManagement.Costumer;
import CostumerServices.Funds;
import DataStorageLayer.TransactionHistory;

public class FundsMethodsB {
    public static void writingTransactionHistory(String bill,double amount, Costumer costumer) throws Exception{
        String parts[] = bill.split(" " , 4);
        Object obj = new Funds(parts[0] , parts[1] + " " + parts[2] , parts[3] , amount);
        TransactionHistory.writingTransactionHistory(costumer , obj);
    }
}
