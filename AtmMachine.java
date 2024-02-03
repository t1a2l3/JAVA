package ATMPackage;

public class AtmMachine {
    private String Location;
    private int PostalCode;
    private String Timing;
    private int Atm_Id;
    private double CurrentAmmount;
    private int CashCapacity;
    private String MaintenanceContact;// (Helping Number)
    private static int counter = 0 ;

    public AtmMachine(String location, int postalCode, String timing, int cashCapacity, String maintenanceContact, double CurrentAmmount) {
        this.Atm_Id = ++counter;
        Location = location;
        PostalCode = postalCode;
        Timing = timing;
        CashCapacity = cashCapacity;
        MaintenanceContact = maintenanceContact;
        this.CurrentAmmount = CurrentAmmount;
    }

    public int getAtm_Id(){
        return Atm_Id;
    }

    public double getCurrentAmmount() {
        return CurrentAmmount;
    }

    public void setCurrentAmmount(double currentAmmount) {
        CurrentAmmount = currentAmmount;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(int postalCode) {
        PostalCode = postalCode;
    }

    public String getTiming() {
        return Timing;
    }

    public void setTiming(String timing) {
        Timing = timing;
    }

    public int getCashCapacity() {
        return CashCapacity;
    }

    public void setCashCapacity(int cashCapacity) {
        CashCapacity = cashCapacity;
    }

    public String getMaintenanceContact() {
        return MaintenanceContact;
    }

    public void setMaintenanceContact(String maintenanceContact) {
        MaintenanceContact = maintenanceContact;
    }
}
