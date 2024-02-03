import java.io.*;
import java.util.*;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.String;
class Store implements Serializable {
    public String name;
    public String address;
    public long phoneNumber;
    public String StoreManager;
    public String password;
    int defaultpasswordLength = 10;

    public Store(String name, String address,long phoneNumber,String storeManager) {
        this.name = name;
        this.address = address;
        this.StoreManager = storeManager;
        this.password = random_password(defaultpasswordLength);
    }

    @Override
    public String toString() {
        return "Name : " + getName() + " Adress : " + getAddress()+ " PhoneNumber : " + getPhoneNumber() + " Store Manager : " + getStoreManager();
    }
    private String random_password(int length) {
        String passwordSet = "ABCERTYU#@!MKLFM9876*&^HG";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStoreManager() {
        return StoreManager;
    }

    public void setStoreManager(String storeManager) {
        StoreManager = storeManager;
    }
}


class Indoor extends Store implements Serializable{
    private int id;
    private static int counter ;

    public Indoor(String name, String address, long phoneNumber, String storeManager) {
        super(name, address, phoneNumber, storeManager);
        this.id = ++counter;
    }
    public String toString(){
        return "id : " + getId()+ super.toString();
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Indoor.counter = counter;
    }
}

class Outdoor extends Store implements Serializable {
    private int Id;
    private static int counter;
    public String CityName;

    public Outdoor(String name, String address, long phoneNumber, String storeManager,  String cityName) {
        super(name, address, phoneNumber, storeManager);
        this.Id = ++counter;
        CityName = cityName;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Outdoor.counter = counter;
    }

    public String toString(){
        return "id"+this.Id+"City"+this.CityName+super.toString();
    }
}
class Customer implements Serializable{
    public String name;
    public int age;
    private int id;
    private static int counter;
    public long phoneNumber;

    public Customer(String name, int age,  long phoneNumber) {
        this.name = name;
        this.age = age;
        this.id = counter;
        this.phoneNumber = phoneNumber;

    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", id=" + id +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
class IndoorCustomer extends Customer implements Serializable {

    public String experience;
    private int id;
    private static int counter;

    public IndoorCustomer(String name, int age, long phoneNumber, String experience) {
        super(name, age, phoneNumber);
        this.experience = experience;
        this.id=counter;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        IndoorCustomer.counter = counter;
    }

    @Override
    public String toString(){
        return "id"+this.id+"experience"+this.experience+super.toString();
    }
}

class OutdoorCustomer extends Customer implements Serializable{
    public String experience;
    public String City;
    private int id;
    private static int counter;

    public OutdoorCustomer(String name, int age, long phoneNumber, String experience, String city) {
        super(name, age, phoneNumber);
        this.experience = experience;
        this.City = city;
        this.id = ++counter;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        OutdoorCustomer.counter = counter;
    }

    @Override
    public String toString(){
        return "id"+this.id+"experience"+this.experience+"city"+this.City+super.toString();
    }
}
class MedicineTypes implements Serializable{
    public String name;
    private int id;
    private static int counter;
    public int MD; // manufacturing date
    public int EXPD; // expirey date

    public MedicineTypes(String name,  int MD, int EXPD) {
        this.name = name;
        this.id =++counter;
        this.MD = MD;
        this.EXPD = EXPD;
    }

    @Override
    public String toString() {
        return "MedicineTypes{" +
                "name='" + name + '\'' +
                ", MD=" + MD +
                ", EXPD=" + EXPD +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        MedicineTypes.counter = counter;
    }

    public int getMD() {
        return MD;
    }

    public void setMD(int MD) {
        this.MD = MD;
    }

    public int getEXPD() {
        return EXPD;
    }

    public void setEXPD(int EXPD) {
        this.EXPD = EXPD;
    }
}

class Person{
    protected String name;
    protected int age;
    protected String fatherName;
    protected String emailId;
    protected int phoneNumber;

    public Person(String name, int age, String fatherName, String emailId, int phoneNumber) {
        this.name = name;
        this.age = age;
        this.fatherName = fatherName;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
class Costumers extends Person{
    private double billAmount;
    private final int cosId;
    private static int counter ;
    public Costumers(String name , int age , String FatherName , String emailId , int phoneNumber){
        super(name , age , FatherName , emailId , phoneNumber);
        cosId = ++counter;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public int getCosId() {
        return cosId;
    }
}
class Employees extends Person{
    private double salary;
    public Employees(String name , int age , String FatherName , String emailId , int phoneNumber,double salary){
        super(name , age , FatherName , emailId , phoneNumber);
        this.salary=salary;
    }
}

class Manager extends Employees {
    public String workExperience;// A Manager can add all types of employees and only the owner can add a manager so must put a check condition before add an employee weather he is other then manager or not

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public Manager(String name, int age, String FatherName, String emailId, int phoneNumber, String workExperience, double salary) {
        super(name, age, FatherName, emailId, phoneNumber, salary);
        this.workExperience = workExperience;

    }

    @Override
    public java.lang.String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", fatherName='" + fatherName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }


    class Accountant extends Employees {
        private String AccountingSoftware;

        public String getAccountingSoftware() {
            return AccountingSoftware;
        }

        public void setAccountingSoftware(String accountingSoftware) {
            AccountingSoftware = accountingSoftware;
        }

        public Accountant(String name, int age, String FatherName, String emailId, int phoneNumber, String AccountingSoftware, double salary) {
            super(name, age, FatherName, emailId, phoneNumber, salary);
            this.AccountingSoftware = AccountingSoftware;

        }
    }

    public static void generatefinancialreport() {
        int Salary = 5000000;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Emplyoee name  ");
        String name = sc.next();
        System.out.println("per year salary of employee is " + Salary + " per month salary is :" + Salary / 30);
        System.out.println("Enter the permission of total vocations per year");
        int vocations = sc.nextInt();
        System.out.println("enter emplyees voactions per year");
        int empvocation = sc.nextInt();
        System.out.println("emplyee vocations per month is:" + empvocation / 12);
        double incrementAmount = 0.05;
        double decrementAmount = 0.02;

        if (vocations == empvocation && vocations < empvocation) {
            System.out.println("No decrement in salary");
            System.out.println("increment in salary " + Salary * incrementAmount);
            Salary += incrementAmount;
            System.out.println(incrementAmount);
        } else if (vocations > empvocation) {
            System.out.println("decrement in Salary " + Salary * decrementAmount);
            Salary -= decrementAmount;
            System.out.println(decrementAmount);
        } else {
            System.out.println("Salary remains static");
        }
    }
}

    class SalesPerson extends Employees {
        public String Salestarget;

        public String getSalestarget() {
            return Salestarget;
        }

        public void setSalestarget(String salestarget) {
            Salestarget = salestarget;
        }

        // He is the person who sale medicines outside pharmacy and earn basic salary and commission based on his sales
        public SalesPerson(String name, int age, String FatherName, String emailId, int phoneNumber, String Salestarget, double salary) {
            super(name, age, FatherName, emailId, phoneNumber, salary);
            this.Salestarget = Salestarget;
        }

        public static void CalculateTotalSales() {
        }

        public static void TotalSalesInventory() {
        }
    }


    class pharmacyAssitant extends Employees {
        public String Specialization;// He is the person who will search medicines inside the pharmacy from pharmacy racks for further processing

        public String getSpecialization() {
            return Specialization;
        }

        public void setSpecialization(String specialization) {
            Specialization = specialization;
        }

        public pharmacyAssitant(String name, int age, String FatherName, String emailId, int phoneNumber, String Specialization, double salary) {
            super(name, age, FatherName, emailId, phoneNumber, salary);

        }

        public static void ProcessMedicine() {
        }
    }

   class companies {
        public String name;
        public String City;
        public String companyreviews;
        public String products;
        public int prices;
        public String FormsevenMed;
        private ArrayList<medicines> medicineList;

        public ArrayList<medicines> getMedicineList() {
            return medicineList;
        }


        public companies(String name, String city, String companyreviews, String products, int prices, String formsevenMed) {
            this.name = name;
            City = city;
            this.companyreviews = companyreviews;
            this.products = products;
            this.prices = prices;
            this.medicineList = new ArrayList<>();
            FormsevenMed = formsevenMed;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return City;
        }

        public void setCity(String city) {
            City = city;
        }

        public String getCompanyreviews() {
            return companyreviews;
        }

        public void setCompanyreviews(String companyreviews) {
            this.companyreviews = companyreviews;
        }

        public String getProducts() {
            return products;
        }

        public void setProducts(String products) {
            this.products = products;
        }

        public int getPrices() {
            return prices;
        }

        public void setPrices(int prices) {
            this.prices = prices;
        }

        public String getFormsevenMed() {
            return FormsevenMed;
        }

        public void setFormsevenMed(String formsevenMed) {
            FormsevenMed = formsevenMed;
        }
    }

   class medicines {
        private String name;
        private int id;
        private static int counter;
        public String FormSevenMed;
        private int totalMedicines;
        private int prices;

        public medicines(String name, int id, String formSevenMed, int totalMedicines, int prices) {
            this.name = name;
            this.id = ++counter;
            FormSevenMed = formSevenMed;
            this.totalMedicines = totalMedicines;
            this.prices = prices;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public static int getCounter() {
            return counter;
        }

        public static void setCounter(int counter) {
            medicines.counter = counter;
        }

        public String getFormSevenMed() {
            return FormSevenMed;
        }

        public void setFormSevenMed(String formSevenMed) {
            FormSevenMed = formSevenMed;
        }

        public int getTotalMedicines() {
            return totalMedicines;
        }

        public void setTotalMedicines(int totalMedicines) {
            this.totalMedicines = totalMedicines;
        }

        public int getPrices() {
            return prices;
        }

        public void setPrices(int prices) {
            this.prices = prices;
        }


//    public int calculateTotalValue(){}
//    public boolean isLowStock(){}
//    public int calculateTotalStock(){}

    }
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


    //}
   class Medicines {
        public String name;
        int id;
        private static int counter;
        public int TotalStock;
        public String ToSend;
        medicines special;

        enum medicines {
            Panadol, Aspirin, Paracetamol
        }

        public Medicines(String name, int id, int totalStock, String toSend) {
            this.name = name;
            this.id = id;
            this.TotalStock = totalStock;
            this.ToSend = toSend;
        }

        public String getName() {
            return name;
        }

        public medicines getSpecial() {
            return special;
        }

        public void setSpecial(medicines special) {
            this.special = special;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void SetId(int id) {
            this.id = id;
        }

        public int getId(int id) {
            return id;
        }

        @Override
        public String toString() {
            return "Medicines{" +
                    "name='" + name + '\'' +
                    ", TotalStock=" + TotalStock +
                    ", ToSend='" + ToSend + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public static int getCounter() {
            return counter;
        }

        public static void setCounter(int counter) {
            Medicines.counter = counter;
        }

        public int getTotalStock() {
            return TotalStock;
        }

        public void setTotalStock(int totalStock) {
            TotalStock = totalStock;
        }

        public String getToSend() {
            return ToSend;
        }

        public void setToSend(String toSend) {
            ToSend = toSend;
        }
    }

    // Medicine class representing a medicine
    class Medicine {
        private String name;
        private String genericName;
        private double price;

        public Medicine(String name, String genericName, double price) {
            this.name = name;
            this.genericName = genericName;
            this.price = price;
        }

        // A constructor to create Medicine objects from a string representation
        public Medicine(String line) {
            String[] parts = line.split(",");
            this.name = parts[0].trim();
            this.genericName = parts[1].trim();
            this.price = Double.parseDouble(parts[2].trim());
        }

        @Override
        public String toString() {
            return "Medicine: " + name + " (Generic Name: " + genericName + ", Price: $" + price + ")";
        }
    }

    // Company class representing a medicine company
    class Company {
        private String name;
        private String address;
        private List<Medicine> medicines;

        public Company(String name, String address) {
            this.name = name;
            this.address = address;
            this.medicines = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public List<Medicine> getMedicines() {
            return medicines;
        }

        public void addMedicine(Medicine medicine) {
            medicines.add(medicine);
        }

        // A method to add medicines from a file
        public void addMedicinesFromFile(String filename) {
            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = br.readLine()) != null) {
                    Medicine medicine = new Medicine(line);
                    addMedicine(medicine);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.err.println("Error parsing price from file.");
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Company: " + name + " (Address: " + address + ")";
        }
    }

// Main class to demonstrate the usage of Medicine and Company classes
    // Creating a company


    class company {
        String name;
        int id;
        String address;
        int phone_Number;
        String staffMember;

        public company(String staffMember, String name, int id, String address, int phone_Number) {
            this.staffMember = staffMember;
            this.id = id;
            this.name = name;
            this.phone_Number = phone_Number;
            this.address = address;
        }

        public int getPhone_Number() {
            return phone_Number;
        }

        public void setPhone_Number(int phone_Number) {
            this.phone_Number = phone_Number;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getStaffMember() {
            return staffMember;
        }

        public void setStaffMember(String staffMember) {
            this.staffMember = staffMember;
        }

        @Override
        public String toString() {
            return "company{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    ", address='" + address + '\'' +
                    ", phone_Number=" + phone_Number +
                    ", staffMember='" + staffMember + '\'' +
                    '}';
        }
    }

    class worker {
        private int Id;
        private static int counter;

        int age;
        int Cnic;
        String name;
        int date_of_joining;

        public worker(int age, int id, int Cnic, String name, int date_of_joining) {
            this.age = age;
            this.Id = ++counter;
            this.Cnic = Cnic;
            this.date_of_joining = date_of_joining;
            this.name = name;
        }

        @Override
        public String toString() {
            return "worker: " +
                    "id=" + Id +
                    ", age=" + age +
                    ", Cnic=" + Cnic +
                    ", name='" + name + '\'' +
                    ", date_of_joining=" + date_of_joining;
        }
    }

     class Market {
        double price;
        int share_rate;
        market status;

        enum market {
            market_up, market_down
        }

        Market(double price, int share_rate, market status) {
            this.price = price;
            this.share_rate = share_rate;
            this.status = status;
        }

        public market getStatus() {
            return status;
        }

        public void setStatus(market status) {
            this.status = status;
        }

        public double getPrice() {
            return price;
        }

        public int getShare_rate() {
            return share_rate;
        }

        public void setShare_rate(int share_rate) {
            this.share_rate = share_rate;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "market:" +
                    "price=" + price +
                    ", share_rate=" + share_rate;
        }
    }

    class Vendor {
        private String name;
        private String id;
        private int age;
        private String experience;
        private String companyName;

        // Constructor
        public Vendor(String name, String id, int age, String experience, String companyName) {
            this.name = name;
            this.id = id;
            this.age = age;
            this.experience = experience;
            this.companyName = companyName;
        }
    }

    class History {

        public String action;
        public String details;

        // Constructor
        public History(String action, String details) {
            this.action = action;
            this.details = details;
        }

        public static void generateTime() {
            History history=new History("Company built in 2000","This is medicine company.They can sell all kinds of medicine. \n They have great prestigie in market. ");
            System.out.println(history);
            SimpleDateFormat dateFormat = new SimpleDateFormat("2000-5-3 HH:mm:ss");
            System.out.println(dateFormat);
        }
    }

     class Supplier {
        private String supplierID;
        private String supplierName;
        private String contactPerson;
        private String contactNumber;
        private String email;

        public String getSupplierID() {
            return supplierID;
        }

        public void setSupplierID(String supplierID) {
            this.supplierID = supplierID;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getContactNumber() {
            return contactNumber;
        }

        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
        }

        public String getContactPerson() {
            return contactPerson;
        }

        public void setContactPerson(String contactPerson) {
            this.contactPerson = contactPerson;
        }

        public String getSupplierName() {
            return supplierName;
        }

        public void setSupplierName(String supplierName) {
            this.supplierName = supplierName;
        }

        // Constructor
        public Supplier(String supplierID, String supplierName, String contactPerson, String contactNumber, String email) {
            this.supplierID = supplierID;
            this.supplierName = supplierName;
            this.contactPerson = contactPerson;
            this.contactNumber = contactNumber;
            this.email = email;
        }
    }

    public class oop {
        static Scanner sc = new Scanner(System.in);
        static ArrayList<Indoor> indoors = new ArrayList<>();
        static ArrayList<Outdoor> outdoors = new ArrayList<>();
        static ArrayList<OutdoorCustomer> OCData = new ArrayList<>();
        static ArrayList<IndoorCustomer> ICData = new ArrayList<>();
        static ArrayList<Medicines> medicineList = new ArrayList<>();
        private static Object medicine;
        static ArrayList<Supplier> supplierList = new ArrayList<>();
        private static ArrayList<Supplier> supplier=new ArrayList<>();
        //private static String supplierID;
        static ArrayList<medicines> medicineStore = new ArrayList<>();
        static ArrayList<Manager> managers = new ArrayList<>();
    static ArrayList<medicines>newMedicine=new ArrayList<>();
        // List to store medicinesstatic
        // List<medicines> medicineStore = new ArrayList<>();


//    public static void main(String[] args) {
//        Store s1 = new Store("Store..." , "House ..." , 174393228 , "talhaAsif");
//        System.out.println(s1);
//        Indoor n1 = new Indoor("Store..." , "House ..." , 174393228 , "talhaAsif");
//        System.out.println(n1);


        // static ArrayList<Outdoor> outdoors = new ArrayList<Outdoor>();
        public static void takeMedicineFromCompany()throws Exception,ClassNotFoundException {
            Scanner sc = new Scanner(System.in);

            companies company = new companies("ABC Pharmaceuticals", "City", "Good reviews", "Medicine A", 100, "FormSevenMed");

            medicines medicine1 = new medicines("Medicine A", 1, "FormSevenMed", 50, 10);
            medicines medicine2 = new medicines("Medicine B", 2, "FormSevenMed", 30, 15);

            System.out.println("Available Medicines in " + company.getName() + ":");
            System.out.println("1. " + medicine1.getName());
            System.out.println("2. " + medicine2.getName());

            System.out.print("Enter the number of the medicine you want to take:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    medicineStore.add(medicine1);
                    System.out.print(medicine1.getName() + " added to the store.");
                    break;
                case 2:
                    medicineStore.add(medicine2);
                    System.out.print(medicine2.getName() + " added to the store.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        public static void printMedicineStore() {
            System.out.println("\nStore Medicine Inventory:");
            for (medicines medicine : medicineStore) {
                System.out.println("Medicine: " + medicine.getName() + ", Quantity: " + medicine.getTotalMedicines() + ", Price: $" + medicine.getPrices());
            }
        }

        public static void addMedicineToInventory() {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the details of the new medicine:");
            System.out.print("Medicine Name: ");
            String medicineName = sc.nextLine();
            System.out.print("Medicine ID: ");
            int medicineId = sc.nextInt();
            System.out.print("FormSevenMed: ");
            String formSevenMed = sc.next();
            System.out.print("Total Medicines: ");
            int totalMedicines = sc.nextInt();
            System.out.print("Price: ");
            int price = sc.nextInt();

            medicines newMedicine = new medicines(medicineName, medicineId, formSevenMed, totalMedicines, price);
            medicineStore.add(newMedicine);
            //saveMedicineListToFile();
            System.out.println(medicineName + " added to the store inventory.");
        }

        public static void makePaymentToCompany() {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the details for making payment to the company:");
            System.out.print("Company Name: ");
            String companyName = sc.next();
            System.out.print("Amount to Pay: $");
            double amountToPay = sc.nextDouble();
            System.out.println("Payment of $" + amountToPay + " made to " + companyName + " successfully.");
        }

        public static void saveMedicineListToFile() {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\talha\\java files\\Assigment 3\\Files\\date.txt"))) {
                objectOutputStream.writeObject(medicineStore);
                System.out.println("Medicine list saved to file successfully.");
            } catch (IOException e) {
                System.out.println("Error saving medicine list to file: " + e.getMessage());
            }
        }

        public static void IndoorStoreData() throws IOException, ClassNotFoundException{
            System.out.println("Enter store name: ");
            String name = sc.nextLine();
            name = sc.nextLine();
            System.out.println("Enter store address: ");
            String address = sc.nextLine();
            System.out.println("Enter phone number: ");
            long p = sc.nextLong();
            System.out.println("Enter StoreManager name : ");
            String E = sc.nextLine();
            E = sc.nextLine();
            Indoor n = new Indoor(name, address, p, E);
//        Objec fileInputStream=new FileInputStream("Files\\date.txt") ;
            try {
                File file = new File("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt");
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
                indoors = (ArrayList<Indoor>) ois.readObject();
                indoors.add(n);
                ois.close();


//        ObjectInputStream ois = new Objec;
//        ObjectInputStream objectInputStream;


                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));

                objectOutputStream.writeObject(indoors);

                System.out.println("data is added");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void displayIndoorStoreData() throws IOException, ClassNotFoundException {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
                ArrayList<Indoor> indoors = (ArrayList<Indoor>) objectInputStream.readObject();


                for (Indoor indoor : indoors) {
                    System.out.println(indoor);
                }
            } catch (Exception e) {
                System.out.println(e);// Handle the exception according to your application's needs
            }

        }

//    public static void ReadingStoreData() throws IOException, ClassNotFoundException {
//
//    }

        public static void ExitProgram() throws IOException, ClassNotFoundException {

            System.exit(0);
        }

        public static void DeleteStoreData() {
            try {
                File f = new File("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt");
                Scanner ss = new Scanner(f);
                ObjectInputStream ooo = new ObjectInputStream(new FileInputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
                indoors = (ArrayList<Indoor>) ooo.readObject();

                System.out.println("what you want to delete: ");
                int ID = sc.nextInt();
                boolean found = false;
                for (Indoor indoor : indoors) {
                    if (indoor.getId() == ID) {
                        indoors.remove(indoor);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    System.out.println("Id" + ID + "found deleted object");
                    System.out.println("updated list");
                    for (Indoor indoor : indoors) {
                        System.out.println(indoors);
                    }
                } else {
                    System.out.println("id" + ID + "not found deleted id");
                }


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        public static void outdoorStoreData() throws IOException, ClassNotFoundException {
            System.out.println("Enter store name: ");
            String name = sc.nextLine();
            name = sc.nextLine();
            System.out.println("Enter store address: ");
            String address = sc.nextLine();
            System.out.println("Enter phone number: ");
            long p = sc.nextLong();
            System.out.println("Enter StoreManager name : ");
            String E = sc.nextLine();
            E = sc.nextLine();
            System.out.println("Enter city name:");
            String city = sc.nextLine();
            Outdoor O = new Outdoor(name, address, p, E, city);
            try {


                File file = new File("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt");
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
                ArrayList<Outdoor> outdoors = (ArrayList<Outdoor>) ois.readObject();
                outdoors.add(O);
                ois.close();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));

                objectOutputStream.writeObject(outdoors);

                System.out.println("data is added");
            } catch (Exception e) {
                System.out.println(e.getMessage());// Handle the exception according to your application's needs
            }
        }

        public static void displayOutdoorStoreData() throws IOException, ClassNotFoundException {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
                ArrayList<Outdoor> outdoors = (ArrayList<Outdoor>) objectInputStream.readObject();


                for (Outdoor outdoor : outdoors) {
                    System.out.println(outdoor);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void DeleteOutdoorStoreData() throws IOException, ClassNotFoundException {
            try {
                File f = new File("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt");
                Scanner ss = new Scanner(f);
                ObjectInputStream ooo = new ObjectInputStream(new FileInputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
                outdoors = (ArrayList<Outdoor>) ooo.readObject();

                System.out.println("what you want to delete: ");
                int ID = sc.nextInt();
                boolean found = false;
                for (Outdoor outdoor : outdoors) {
                    if (outdoor.getId() == ID) {
                        outdoors.remove(outdoor);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    System.out.println("Id" + ID + "found deleted object");
                    System.out.println("updated list");
                    for (Outdoor outdoor : outdoors) {
                        System.out.println(outdoors);
                    }
                } else {
                    System.out.println("id" + ID + "not found deleted id");
                }


            } catch (Exception e) {
                System.out.println(e);
            }
        }

        static void random_password() {
            System.out.println("Enter password length :");
            int length = sc.nextInt();
            String passwordSet = "ABCERTYU#@!MKLFM9876*&^HG";
            char[] password = new char[length];
            for (int i = 0; i < length; i++) {
                int rand = (int) (Math.random() * passwordSet.length());
                password[i] = passwordSet.charAt(rand);

            }
            System.out.println(password);
        }

        public static void EmployeesData() {
            System.out.println("Enter the  employees data: ");
            Scanner sc = new Scanner(System.in);

            System.out.println("enter name: ");
            String name;
            name = sc.next();
            System.out.println("Enter the age: ");
            int age = sc.nextInt();
            System.out.println("Enter fatherName: ");
            String n = sc.next();
            System.out.println("enter Gmail id: ");
            String g = sc.nextLine();
            System.out.println("Enter phone number: ");
            int phonenumb = sc.nextInt();
            System.out.println("enter the salary: ");
            int salary = sc.nextInt();
            Employees ee = new Employees(name, age, n, g, phonenumb, salary);
            try {
                File file = new File("mm.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
                managers = (ArrayList<Manager>) objectInputStream.readObject();
                managers.add((Manager) ee);

                objectInputStream.close();

                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
                objectOutputStream.writeObject(managers);
                System.out.println("data is added");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        public static void DisplayEmplyeesdata(){
            try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
            managers = (ArrayList<Manager>) objectInputStream.readObject();

            for (Manager m:managers)
                System.out.println(m);

        }
            catch (Exception e){
                System.out.println(e);
            }
        }

        public static void outdoorCustomerdata() throws IOException, ClassNotFoundException {
            System.out.println("Enter the  outdoor city customer name: ");
            String Cname = sc.nextLine();
            Cname = sc.nextLine();
            System.out.println("Enter outdoor city customer age: ");
            int Cage = sc.nextInt();
            System.out.println("Enter outdoor city Customer phone: ");
            long cphone = sc.nextLong();
            System.out.println("Enter outdoor city customer experience: ");
            String Cexperience = sc.nextLine();
            Cexperience = sc.nextLine();
            System.out.println("Enter outdoor city name: ");
            String Ocity = sc.next();
            OutdoorCustomer outdoorCustomer = new OutdoorCustomer(Cname, Cage, cphone, Cexperience, Ocity);
            try {
                File ff = new File("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt");
                ObjectInputStream obj = new ObjectInputStream(new FileInputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
                OCData = (ArrayList<OutdoorCustomer>) obj.readObject();
                OCData.add(outdoorCustomer);
                obj.close();
                ObjectOutputStream obj1 = new ObjectOutputStream(new FileOutputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
                obj1.writeObject(OCData);
                obj1.close();

                System.out.println("Customer is added");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void OutdoorDisplayDAta() throws IOException, ClassNotFoundException {
            try {
                ObjectInputStream obj0 = new ObjectInputStream(new FileInputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
                OCData = (ArrayList<OutdoorCustomer>) obj0.readObject();
                for (OutdoorCustomer out : OCData) {
                    System.out.println(out);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void outdoorCustomerDeleteData() throws IOException, ClassNotFoundException {
            try {
                File fff = new File("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt");
                Scanner s = new Scanner(fff);
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
                OCData = (ArrayList<OutdoorCustomer>) objectInputStream.readObject();

                System.out.println("what you want to delete: ");
                int id = sc.nextInt();
                Boolean found = false;
                for (OutdoorCustomer o : OCData)
                    if (o.getId() == id) {
                        OCData.remove(o);
                        found = true;
                        break;
                    }
                if (found) {
                    System.out.println("ID" + id + "found deleted id");
                    System.out.println("updated list");
                    for (OutdoorCustomer o : OCData)
                        System.out.println(o);
                } else {
                    System.out.println("not found deleted id");
                }


            } catch (Exception e) {
                System.out.println(e);
            }

        }

        public static void IndoorCustomerdata() throws IOException, ClassNotFoundException {
            System.out.println("Enter the  indoor city customer name: ");
            String Iname = sc.nextLine();
            Iname = sc.nextLine();
            System.out.println("Enter Indoor city customer age: ");
            int Iage = sc.nextInt();
            System.out.println("Enter  indoor city Customer phone: ");
            long pp = sc.nextLong();
            System.out.println("Enter Indoor city customer experience: ");
            String Iexperience = sc.nextLine();
            Iexperience = sc.nextLine();
            IndoorCustomer indoorCustomer = new IndoorCustomer(Iname, Iage, pp, Iexperience);
            try {
                File f1 = new File("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt");
                ObjectInputStream objj = new ObjectInputStream(new FileInputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
                ICData = (ArrayList<IndoorCustomer>) objj.readObject();
                objj.close();
                ICData.add(indoorCustomer);


                ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
                oo.writeObject(ICData);
                oo.close();

                System.out.println("indoor data is added");


            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void DisplayIndoorCData() throws IOException, ClassNotFoundException {
            try {
                ObjectInputStream objj1 = new ObjectInputStream(new FileInputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
                ICData = (ArrayList<IndoorCustomer>) objj1.readObject();

                for (IndoorCustomer ind : ICData) {
                    System.out.println(ind);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }



        public static void IndoorCdelData() throws IOException, ClassNotFoundException {
            try {
                File ffff = new File("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt");
                Scanner s = new Scanner(ffff);
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"));
                ICData = (ArrayList<IndoorCustomer>) objectInputStream.readObject();

                System.out.println("what you want to delete: ");
                int id = sc.nextInt();
                Boolean found = false;
                for (IndoorCustomer i : ICData)
                    if (i.getId() == id) {
                        OCData.remove(i);
                        found = true;
                        break;
                    }
                if (found) {
                    System.out.println("ID" + id + "found deleted id");
                    System.out.println("updated list");
                    for (IndoorCustomer i : ICData)
                        System.out.println(i);
                } else {
                    System.out.println("not found deleted id");
                }


            } catch (Exception e) {
                System.out.println(e);
            }

        }

        public static void addMedicineData() {
            System.out.println("Enter the  Medicine name: ");
            String MedicineName = sc.nextLine();
            MedicineName = sc.nextLine();
            System.out.println("Enter Medicine id: ");
            int M_id = sc.nextInt();
            System.out.println("Enter Medicine stock: ");
            int medicineStock = sc.nextInt();
            System.out.println("Enter Person name whom to send ");
            String Msend = sc.nextLine();
            Msend = sc.nextLine();
            Medicines medicine = new Medicines(MedicineName, M_id, medicineStock, Msend);
            try {
                File file = new File("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt");

                if (file.exists()) {
                    ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
                    medicineList = (ArrayList<Medicines>) objIn.readObject();
                    objIn.close();
                }

                medicineList.add(medicine);

                ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
                objOut.writeObject(medicineList);
                objOut.close();

                System.out.println("Medicine data added successfully.");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void displayMedicineData() {
            try {
                File file = new File("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt");

                if (file.exists()) {
                    ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
                     medicineList = (ArrayList<Medicines>) objIn.readObject();
                    objIn.close();

                    System.out.println("Medicine Data:");
                    for (Medicines medicine : medicineList) {
                        System.out.println("Name: " + medicine.getName());
                        System.out.println("ID: " + medicine.getId());
                        System.out.println("Total Stock: " + medicine.getTotalStock());
                        System.out.println("To Send: " + medicine.getToSend());
                        System.out.println("-----------------------------");
                    }
                } else {
                    System.out.println("No medicine data available.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void deleteMedicineData() {
            try {
                File file = new File("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt");

                if (file.exists()) {
                    ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
                    medicineList = (ArrayList<Medicines>) objIn.readObject();
                    objIn.close();

                    boolean found = false;
                    Iterator<Medicines> iterator = medicineList.iterator();
                    while (iterator.hasNext()) {
                        Medicines medicine = iterator.next();
                        if (medicine.getId() == medicine.getId()) {
                            iterator.remove();
                            found = true;
                            System.out.println("Medicine data with ID " + medicine.getId() + " deleted successfully.");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Medicine with ID " + medicine.getClass() + " not found.");
                    }

                    ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
                    objOut.writeObject(medicineList);
                    objOut.close();
                } else {
                    System.out.println("No medicine data available.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void updateStock() {

            try {

                int newStock = 0;
                File file = new File("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt");

                if (file.exists()) {
                    ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
                    medicineList = (ArrayList<Medicines>) objIn.readObject();
                    objIn.close();

                    boolean found = false;
                    int medicineId = 0;
                    for (Medicines medicine : medicineList) {
                        if (medicine.getId() == medicineId) {
                            medicine.setTotalStock(newStock);
                            found = true;
                            System.out.println("Stock for medicine with ID " + medicineId + " updated successfully.");
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Medicine with ID " + medicineId + " not found.");
                    }

                    ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
                    objOut.writeObject(medicineList);
                    objOut.close();
                } else {
                    System.out.println("No medicine data available.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void addSupplierData() {
            System.out.println("Enter the  indoor city customer name: ");
            String S_ID = sc.nextLine();
            S_ID = sc.nextLine();
            System.out.println("Enter Indoor city customer age: ");
            String Supplier_name = sc.nextLine();
            Supplier_name = sc.nextLine();
            System.out.println("Enter  indoor city Customer phone: ");
            String S_Person = sc.nextLine();
            S_Person = sc.nextLine();
            System.out.println("Enter supplier contact number:");
            String S_number = sc.nextLine();
            S_number = sc.nextLine();
            System.out.println("Enter Indoor city customer experience: ");
            String S_mail = sc.nextLine();
            S_mail = sc.nextLine();

            Supplier supplier = new Supplier(S_ID, Supplier_name, S_Person, S_number, S_mail);
            try {
                File file = new File("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt");

                if (file.exists()) {
                    ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
                    supplierList = (ArrayList<Supplier>) objIn.readObject();
                    objIn.close();
                }

                supplierList.add(supplier);

                ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
                objOut.writeObject(supplierList);
                objOut.close();

                System.out.println("Supplier data added successfully.");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void displaySupplierData() {
            try {
                File file = new File("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt");

                if (file.exists()) {
                    ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
                     supplierList = (ArrayList<Supplier>) objIn.readObject();
                    objIn.close();

                    if (!supplierList.isEmpty()) {
                        System.out.println("Supplier Data:");
                        for (Supplier supplier : supplierList) {
                            System.out.println("Supplier ID: " + supplier.getSupplierID());
                            System.out.println("Supplier Name: " + supplier.getSupplierName());
                            System.out.println("Contact Person: " + supplier.getContactPerson());
                            System.out.println("Contact Number: " + supplier.getContactNumber());
                            System.out.println("Email: " + supplier.getEmail());
                            System.out.println("-----------------------------");
                        }
                    } else {
                        System.out.println("No supplier data available.");
                    }
                } else {
                    System.out.println("No supplier data available.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void deleteSupplierData() {
            try {
                File file = new File("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt");

                if (file.exists()) {
                    ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(file));
                    supplierList = (ArrayList<Supplier>) objIn.readObject();
                    objIn.close();

                    boolean found = false;
                    Iterator<Supplier> iterator = supplierList.iterator();

                    while (iterator.hasNext()) {
                        Supplier supplier = iterator.next();
                        if (supplier.getSupplierID().equals(supplier)) {
                            iterator.remove();
                            found = true;
                            System.out.println("Supplier data with ID " + supplier + " deleted successfully.");
                            break;
                        }
                    }

                    if (found) {
                        System.out.println("Updated Supplier List:");
                        for (Supplier supplier : supplierList) {
                            System.out.println(supplier);
                        }

                        ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(file));
                        objOut.writeObject(supplierList);
                        objOut.close();
                    } else {
                        System.out.println("Supplier with ID " + supplier + " not found.");
                    }
                } else {
                    System.out.println("No supplier data available.");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        private static void writeMarketData() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"))) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter market price: ");
                double price = scanner.nextDouble();

                System.out.print("Enter share rate: ");
                int shareRate = scanner.nextInt();

                System.out.print("Enter market status (UP or DOWN): ");
                String statusString = scanner.next();

                Market market = new Market(price, shareRate, Market.market.market_up);
                oos.writeObject(market);

                System.out.println("Market data has been written to the file.");
            } catch (IOException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        private static void readMarketData() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\riaz\\IdeaProjects\\project\\oop.txt"))) {
                Market readMarket = (Market) ois.readObject();
                System.out.println("Read from file: " + readMarket);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


        public static void displayMenu() {
            System.out.println("Menu:");
            System.out.println("1. Check password for detail");
            System.out.println("2. display Company Built time");
            System.out.println("3. Indoor Store Data Information");
            System.out.println("4. Add medicines too the inventory" );
            System.out.println("5. saved medicines in the files");
            System.out.println("6.Display medicine Store");
            System.out.println("7.Take medicines from companies");
            System.out.println("8.Make payment to Comapnies");
            System.out.println("9. Outdoor store data information");
            System.out.println("10. Outdoor customer data information");
            System.out.println("11. Indoor Customer data information");
            System.out.println("12. Add employees data");
            System.out.println("13. Display employees data");
            System.out.println("14.Generate employees Financial report");
            System.out.println("15. Add Medicine Data");
            System.out.println("16. Display Medicine Data");
            System.out.println("17. Delete Medicine Data");
            System.out.println("18. update stock Data");
            System.out.println("19. Add Supplier Data");
            System.out.println("20. Display Supplier Data");
            System.out.println("21. Delete Supplier Data");
            System.out.println("22. Write Market Data to File");
            System.out.println("23. Read Market Data from File");
            System.out.println("24. Exit Program");
        }

        public static void main(String[] args) throws Exception {
            System.out.println("Hello and welcome!");
          //  takeMedicineFromCompany();
            //6printMedicineStore();
            do{
                displayMenu();
                int userchoice = sc.nextInt();
                switch (userchoice) {
                    case 1 -> {
                        random_password();
                    }
                    case 2 ->{
                        History.generateTime();
                    }
                    case 3 -> {
                        System.out.println("Press 1 for add indore data \n Press 2 for display\n Press 3 for delete data ");
                        int i = sc.nextInt();
                        if (i == 1) {
                            IndoorStoreData();
                        }
                        if (i == 2) {
                            displayIndoorStoreData();
                        }
                        if (i == 3) {
                            DeleteStoreData();
                        }
                    }
                    case 4 -> {
                        addMedicineToInventory();
                    }

                    case 5-> {
                        saveMedicineListToFile();
                    }
                    case 6-> {
                        printMedicineStore();
                    }
                    case 7 ->{
                        takeMedicineFromCompany();

                    }
                    case 8->{
                        makePaymentToCompany();
                    }
                    case 9-> {
                        System.out.println("press 1 for add outdoordata \n press 2 for display outdoor data \n press 3 for delete data");
                        int p= sc.nextInt();
                        if (p==1){
                            outdoorStoreData();
                        }
                        if (p==2){
                            displayOutdoorStoreData();
                        }
                        if (p==3){
                            DeleteOutdoorStoreData();
                        }
                    }

                    case 10 -> {
                        System.out.println("press 1 for add outdoorCustomerdata \n press 2 for display outdoorCustomerdata \n press 3 for deleteCustomerdata");
                        int c= sc.nextInt();
                        if (c==1){
                            outdoorCustomerdata();
                        }
                        if (c==2){OutdoorDisplayDAta();}
                        if (c==3){outdoorCustomerDeleteData();}
                    }
                    case 11 -> {
                        System.out.println("press 1 for add indoorCustomerdata \n press 2 for display intdoorCustomerdata \n press 3 for deleteindoorCustomerdata");
                        int in= sc.nextInt();
                        if (in==1){
                            IndoorCustomerdata();
                        }
                        if (in==2){
                            DisplayIndoorCData();
                        }
                        if (in==3){
                            IndoorCdelData();
                        }

                    }
                    case 12 ->{
                        EmployeesData();
                    }
                    case 13 ->{
                        DisplayEmplyeesdata();
                    }
                    case 14->{
                        Manager.generatefinancialreport();
                    }
                    case 15 -> {
                        addMedicineData();
                    }
                    case 16-> {
                        displayMedicineData();
                    }
                    case 17 -> {
                        deleteMedicineData();
                    }
                    case 18 ->{
                        updateStock();
                    }
                    case 19-> {
                        addSupplierData();
                    }
                    case 20 -> {
                        displaySupplierData();
                    }
                    case 21 -> {
                        deleteSupplierData();
                    }
                    case 22-> {
                        writeMarketData();
                    }
                    case 23 -> {
                        readMarketData();
                    }
                    case 24-> {
                        ExitProgram();
                    }

                    default -> throw new IllegalStateException("Unexpected value: " + userchoice);
                }
            } while (true);
        }
    }
//System.out.println();
//                   System.out.println("customer type : ");
//                   System.out.println("2. Indoor customer     3.Outdoor customer ");
//                   System.out.println("Select customer by number : ");
//                   int userinput = sc.nextInt();
//                   System.out.println("Medicine types: ");
//                   System.out.println("4. Paracetamol      5.Antielergic    6.Azithromycin");
//                   System.out.println("select medicine type by number");
//                   int user = sc.nextInt();


//                if (userinput == 2) {
//                    fName = "this.txt";
//                } else {
//                    fName = "that.txt";
//                }

//                File file = new File(filename);
//                File f = new File(fName);
//
//                Scanner scanner = new Scanner(file);
//                Scanner s = new Scanner(f);
//
//                while (s.hasNextLine()) {
//                    //  String[] part = scanner.nextLine().split(","  );
////                    N1=new IndoorCustomer("mmm",24,14522334,"fiveyears");
////                    System.out.println(N1);
//                    }
//
//                    s.close();
//
//                    while (scanner.hasNextLine()) {
//                        //String[] part = scanner.nextLine().split("," , 4);
//                        String st = s.nextLine();
//                        String[] stArray = st.split(",");
//                        String shopName = stArray[0];
//                        String shopAddress = stArray[1];
//                        long   shopContact = Long.parseLong(stArray[2]);
//                        String StoreManager = stArray[3];
//                        Indoor indoor = new Indoor(shopName, shopAddress, shopContact, StoreManager);
//                        indoors.add(indoor);
//                        System.out.println(indoors);
////                        n1 = new Indoor("ddd", "house", 895476, "talha");
////                        System.out.println(n1);
//                        //                  System.out.println(scanner.nextLine());
//                    }
//                    scanner.close();
//
//               } catch (Exception e) {
//                   System.out.println("Error in reading data from file");
//
//                   ExitProgram();
// try {





