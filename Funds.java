package CostumerServices;

import java.io.Serial;
import java.io.Serializable;

public class Funds implements Serializable {
    private String fundsid;
    private String organizationName;
    private double fundedAmount;
    private String AccountNumber;

    public Funds(String fundsid, String organizationName,String AccountNumber, double fundedAmount) {
        this.fundsid = fundsid;
        this.AccountNumber = AccountNumber;
        this.organizationName = organizationName;
        this.fundedAmount = fundedAmount;
    }

    public String getFundsid() {
        return fundsid;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public double getFundedAmount() {
        return fundedAmount;
    }

    @Override
    public String toString() {
        return "Funds{" +
                "fundsid='" + fundsid + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", fundedAmount=" + fundedAmount +
                '}';
    }
}
