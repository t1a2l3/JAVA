package CostumerServices.Bills;

public class InternetBill extends Bills {
    public InternetBill(String billName, double billAmount, String billId) {
        super(billName, billAmount, billId);
    }

    @Override
    public String getBillType() {
        return "INTERNET";
    }
    @Override
    public String toString(){
        return "Internet_Bill{" + super.toString() ;
    }
}

