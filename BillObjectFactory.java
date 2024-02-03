package BusinessLogicLayer.ObjectsFactories;

import CostumerServices.Bills.*;

public class BillObjectFactory {
    public static Bills Creation(int Choice, String billId , String billName , String billAmount){
        switch (Choice){
            case 1 ->{ return new ElectricityBill(billName , Double.parseDouble(billAmount), billId);}
            case 2 ->{ return new GasBill(billName , Double.parseDouble(billAmount), billId);}
            case 3 ->{ return new WaterBill(billName , Double.parseDouble(billAmount), billId);}
            case 4 ->{ return new InternetBill(billName , Double.parseDouble(billAmount), billId);}
            default->{ return new TelephoneBill(billName , Double.parseDouble(billAmount), billId);}
        }
    }
}
