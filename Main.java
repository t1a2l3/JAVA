import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        readingfile();
        creatingFile();
        indoorCreateFile();
        indoorReadFile();
        outdoorCreateFile();
        outdoorReadFile();
    }
    public static void creatingFile() {
        File myfile = new File("date.txt");
        try {
            myfile.createNewFile();

        } catch (Exception e) {
            System.out.println("not create a file");
        }
    }
    public static void readingfile()  {
        File myfile=new File("date.txt");
        try{
            Scanner sc=new Scanner(myfile);
            while (sc.hasNextLine()){
                String line= sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void indoorCreateFile(){
        File myfile = new File("this.txt");
        try {
            myfile.createNewFile();

        } catch (Exception e) {
            System.out.println("not create a file");
        }

    }
    public static void indoorReadFile(){
        File myfile=new File("this.txt");
        try{
            Scanner sc=new Scanner(myfile);
            while (sc.hasNextLine()){
                String line= sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static void outdoorCreateFile(){
        File myfile = new File("that.txt");
        try {
            myfile.createNewFile();

        } catch (Exception e) {
            System.out.println("not create a file");
        }
    }
    public static void outdoorReadFile(){
        File myfile=new File("that.txt");
        try{
            Scanner sc=new Scanner(myfile);
            while (sc.hasNextLine()){
                String line= sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    class Store {
        public String name;
        public String address;
        public String phoneNumber;
        public String StoreManager;

        public Store(String name, String address, String phoneNumber, String storeManager) {
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
            StoreManager = storeManager;
        }
    }


    class indoorStore extends Store {
        private int id;

        public indoorStore(String name, String address, String phoneNumber, String storeManager, int id) {
            super(name, address, phoneNumber, storeManager);
            this.id = id;
        }
    }

    class outDoorStore extends Store {
        private int Id;
        public String CityName;

        public outDoorStore(String name, String address, String phoneNumber, String storeManager, int id, String cityName) {
            super(name, address, phoneNumber, storeManager);
            Id = id;
            CityName = cityName;
        }
    }
}

