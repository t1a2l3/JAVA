package DataStorageLayer;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BillsDataReadWrite {
    public static ArrayList<String> gettingToPayBillData(int fileChoice) throws Exception{
        File file = selectingBillToRead(fileChoice);
        ArrayList<String> arrayList = new ArrayList<>();
        if(file.isFile()){
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                arrayList.add(scanner.nextLine());
            }
            scanner.close();
        }
        return arrayList;
    }
    public static ArrayList<String> gettingPaidBillsDataToSayPay(int fileChoice) throws Exception {
        File file = selectingPaidBillToSayPay(fileChoice);
        ArrayList<String> arrayList = new ArrayList<>();
        if(file.isFile()){
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                arrayList.add(scanner.nextLine());
            }
            scanner.close();
        }
        return arrayList;
    }
    private static File selectingBillToRead(int fileChoice){
        switch (fileChoice){
            case 1 ->{ return new File("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\ElectricityBill.txt");}
            case 2 ->{ return new File("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\GasBill.txt");}
            case 3 ->{return new File("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\WaterBill.txt");}
            case 4 ->{return new File("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\InternetBill.txt");}
            default->{return new File("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\TelephoneBill.txt");}
        }
    }
    private static FileWriter selectingBillToWrite(int fileChoice) throws Exception{
        switch (fileChoice){
            case 1 ->{ return new FileWriter("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\ElectricityBill.txt");}
            case 2 ->{ return new FileWriter("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\GasBill.txt");}
            case 3 ->{return new FileWriter("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\WaterBill.txt");}
            case 4 ->{return new FileWriter("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\InternetBill.txt");}
            default->{return new FileWriter("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\TelephoneBill.txt");}
        }
    }

    private static FileWriter selectingPaidBillToRead(int fileChoice) throws Exception{
        switch (fileChoice){
            case 1 ->{ return new FileWriter("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\PaidElectricityBill.txt", true);}
            case 2 ->{ return new FileWriter("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\PaidGasBill.txt", true);}
            case 3 ->{return new FileWriter("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\PaidWaterBill.txt", true);}
            case 4 ->{return new FileWriter("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\PaidInternetBill.txt", true);}
            default->{return new FileWriter("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\PaidTelephoneBill.txt", true);}
        }
    }
    private static File selectingPaidBillToSayPay(int fileChoice) throws Exception{
        switch (fileChoice){
            case 1 ->{ return new File("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\PaidElectricityBill.txt");}
            case 2 ->{ return new File("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\PaidGasBill.txt");}
            case 3 ->{return new File("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\PaidWaterBill.txt");}
            case 4 ->{return new File("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\PaidInternetBill.txt");}
            default->{return new File("C:\\Users\\HP\\OneDrive\\Desktop\\BANKMANAGEMENTSYSTEM\\Bills\\PaidTelephoneBill.txt");}
        }
    }

    public static void updatingToPayBillData(int fileChioce , ArrayList<String> arrayList) throws Exception{
        FileWriter file = selectingBillToWrite(fileChioce);
        for(String bill : arrayList){
            file.write(bill + "\n");
        }
        file.close();
    }
    public static void updatingPaidBillFile(int fileChoice , String bill ) throws Exception{
        FileWriter file = selectingPaidBillToRead(fileChoice);
        file.write(bill + "\n");
        file.close();
    }
}
