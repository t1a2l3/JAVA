import java.security.PublicKey;

public class Smartphone {
    String brand;
    int batteryCapacity;
     boolean is5GCapable;

    public Smartphone(String brand, int batteryCapacity, boolean is5GCapable) {
        this.brand = brand;
        this.batteryCapacity = batteryCapacity;
        this.is5GCapable = is5GCapable;
    }
    public Smartphone shallowcopy(){
        return this;
    }
    public Smartphone deepcopy(){
        return new Smartphone(this.brand,this.batteryCapacity,this.is5GCapable);

    }
    public boolean equals(Object obj){
        Smartphone p=(Smartphone) obj;
        if(this.brand!= p.brand){return false;}
        if(this.batteryCapacity!=p.batteryCapacity){
            return false;
        }
        if(this.is5GCapable!=p.is5GCapable){
            return false;
        }
        return true;
    }

    public void displayPhonedetails(){
        System.out.println("Brand "+brand+" battery capacity "+batteryCapacity+ " is5GCapable "+ is5GCapable);
    }
}
class test{
    public static void main(String[] args) {
        Smartphone sp=new Smartphone(" Oneplus " ,4000,true);
        System.out.println(" original smartphone ");
        sp.displayPhonedetails();

        Smartphone shallowcopy=sp.shallowcopy();
        shallowcopy.brand="Tecno";
        shallowcopy.batteryCapacity=4500;
        shallowcopy.is5GCapable=false;
        System.out.println("shallow copy after modification ");
        shallowcopy.displayPhonedetails();
        System.out.println("original copy after modification: ");
        sp.displayPhonedetails();

        Smartphone deepcopy=sp.deepcopy();
        deepcopy.brand="Vivo";
        deepcopy.batteryCapacity=3500;
        deepcopy.is5GCapable=true;
        System.out.println("Deep copy after modification ");
        deepcopy.displayPhonedetails();
        System.out.println("original copy after modification ");
        sp.displayPhonedetails();
        
        if (sp.equals(shallowcopy)){
            System.out.println("all are equals");
        }
        if(sp.equals(deepcopy)) {
            System.out.println("Both original and deep copy are equal");
        }
        else{
            System.out.println("Not equals");
        }


    }
}
