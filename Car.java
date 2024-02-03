public class Car {
    String name;
    int model;
    String brand;

    int engine;



    public Car(String name, int model, String brand, int engine){
        this.name=name;
        this.model=model;
        this.brand=brand;
        this.engine=engine;
    }
    public Car shallowCopy(){
        return this;

    }
    public Car deepCopy(){
        return new Car(this.name,this.model,this.brand,this.engine);
    }
    public void display(){
        System.out.println("Car name is " + name+" Car model is "+model+" Car brand is "+brand+" Car engine is "+engine);
    }

}

class testCars{
    public static void main(String[] args) {
        Car c1=new Car("GLI",2023,"Toyota",1200);
        System.out.println("original values ");
        c1.display();

        Car shallowCopy=c1.shallowCopy();
        shallowCopy.name="vezzel";
        shallowCopy.model=2017;
        shallowCopy.brand="Honda";
        shallowCopy.engine=2000;
        System.out.println("Shallow copy after modification ");
        shallowCopy.display();
        System.out.println("original copy after modification ");
        c1.display();

        Car deepCopy=c1.deepCopy();
        deepCopy.name="Santro";
        deepCopy.model=2008;
        deepCopy.brand="Hyndai";
        deepCopy.engine=1000;
        System.out.println("deep copy after modification");
        deepCopy.display();
        System.out.println("original copy after modification"); // this is not perform
        c1.display();

    }
}