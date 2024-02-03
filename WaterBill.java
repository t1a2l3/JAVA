package CostumerServices.Bills;

public class WaterBill extends Bills {
    public WaterBill(String billName, double billAmount, String billId) {
        super(billName, billAmount, billId);
    }

    @Override
    public String getBillType() {
        return "WATER";
    }
    @Override
    public String toString(){
        return "Water_Bill{" + super.toString() ;
    }
}
