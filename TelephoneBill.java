package CostumerServices.Bills;

public class TelephoneBill extends Bills {
    public TelephoneBill(String billName, double billAmount, String billId) {
        super(billName, billAmount, billId);
    }

    @Override
    public String getBillType() {
        return "TELEPHONE";
    }
    @Override
    public String toString(){
        return "Telephone_Bill{" + super.toString() ;
    }
}