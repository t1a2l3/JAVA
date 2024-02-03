public class Laptop {
private static String brand;
private String model;
private String storageType;
private int ramSize;

public Laptop(String brand)
{
    this.brand=brand;
    this.model=model;
    this.storageType=storageType;
    this.ramSize=ramSize;
}
public Laptop(String brand , String model){
    this.brand=brand;
    this.model=model;
    this.storageType=storageType;
    this.ramSize=ramSize;
}
public Laptop(String brand,String model,String storageType){
    this.brand=brand;
    this.model=model;
    this.storageType=storageType;
    this.ramSize=ramSize;

}
public Laptop( String brand,String model,String storageType, int ramSize) {
    this.brand=brand;
    this.model=model;
    this.storageType = storageType;
    this.ramSize = ramSize;
    }
    public boolean equals(Object obj) {
        Laptop B = (Laptop) obj;
        if (this.brand != B.brand) {
            return false;
        }
        if (this.model != B.model) {
            return false;
        }
        if (this.storageType != B.storageType) {
            return false;
        }
        if (this.ramSize != B.ramSize) {
            return false;
        }
        return true;
    }

    public void displayLaptopinfo(){
        System.out.println("laptop "+ brand + " model is " + model +" Storagetype is "+ storageType+ " ram size is"+ramSize );
    }

}
class testlaptop{
    public static void main(String[] args) {
       Laptop vc=new Laptop("Dell");
       Laptop vc1=new Laptop("HP","7580");
       Laptop vc2=new Laptop("Lenovo","8960","HDD");
       Laptop vc3=new Laptop("Alien","7670","SSD",12);

         if(vc.equals(vc1)){
             System.out.println("Not equals");
         }
         if(vc1.equals(vc2)){
             System.out.println("equals");
         }
         if(vc2.equals(vc3)){
             System.out.println("always not equals");
         }
         else{
             System.out.println("All are not equal");
         }



               vc.displayLaptopinfo();
               vc1.displayLaptopinfo();
               vc2.displayLaptopinfo();
               vc3.displayLaptopinfo();





    }
}
