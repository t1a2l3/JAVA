package CostumerServices.Bills;

// Specific class for Electricity bills
public class ElectricityBill extends Bills {
    public ElectricityBill(String billName, double billAmount, String billId ) {
        super(billName, billAmount, billId);
    }

    @Override
    public String getBillType() {
        return "ELECTRICITY";
    }

    @Override
    public String toString(){
        return "Electricity_Bill{" + super.toString() ;
    }
    // Additional properties and methods specific to electricity bills
}