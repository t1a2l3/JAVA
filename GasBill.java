package CostumerServices.Bills;

// Similar classes for other bill types (Gas, Water, Telephone, Internet)
public class GasBill extends Bills {
    public GasBill(String billName, double billAmount, String billId) {
        super(billName, billAmount, billId);
    }

    @Override
    public String getBillType() {
        return "GAS";
    }
    @Override
    public String toString(){
        return "Gas_Bill{" + super.toString() ;
    }
}

