package CostumerServices.Bills;

import java.io.Serializable;

public abstract class Bills implements Serializable {
    private String BillId;
    private String BillName;
    private double BillAmmount;
    public Bills(String BillName, double billAmmount, String billId) {
        this.BillName = BillName;
        this.BillAmmount = billAmmount;
        this.BillId = billId;
    }
    public double getBillAmmount() {
        return BillAmmount;
    }

    public void setBillAmmount(double billAmmount) {
        BillAmmount = billAmmount;
    }

    public String getBillId() {
        return BillId;
    }

    public void setBillId(String billId) {
        BillId = billId;
    }

    public String getBillName() {
        return BillName;
    }

    public void setBillName(String billName) {
        BillName = billName;
    }

    public abstract String getBillType();

    @Override
    public String toString() {
        return "BillId='" + BillId + '\'' +
                ", BillName='" + BillName + '\'' +
                ", BillAmmount=" + BillAmmount +
                '}';
    }
}
