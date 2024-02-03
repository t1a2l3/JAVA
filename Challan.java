package CostumerServices;

import java.awt.*;
import java.io.Serializable;

public class Challan implements Serializable {
    private String challanid;
    private String challanName;
    private double challanAmount;

    public Challan(String challanid, String challanName, double challanAmount) {
        this.challanid = challanid;
        this.challanName = challanName;
        this.challanAmount = challanAmount;
    }

    public String getChallanid() {
        return challanid;
    }

    public String getChallanName() {
        return challanName;
    }

    public double getChallanAmount() {
        return challanAmount;
    }

    @Override
    public String toString() {
        return "Challan{" +
                "challanid='" + challanid + '\'' +
                ", challanName='" + challanName + '\'' +
                ", challanAmount=" + challanAmount +
                '}';
    }
}
