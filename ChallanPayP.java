package Presentation;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ChallanPayP {
    public static ArrayList<String> challanData() throws Exception{
        File file = new File("./CHALLANFUNDS/ChalanFile.txt");
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        if(file.isFile()) {
            while (scanner.hasNextLine()) {
                arrayList.add(scanner.nextLine());
            }
            return arrayList;
        }
        return null;
    }
    public static void updatingchallanData(String Challan,ArrayList<String> arrayList) throws Exception{
        arrayList.remove(Challan);
        FileWriter file = new FileWriter("./CHALLANFUNDS/ChalanFile.txt" );
        for(String challan : arrayList){
            file.write(challan + "\n");
        }
        file.close();
    }
    public static String getChallan(int id,ArrayList<String> arrayList){
        for(String challan : arrayList){
            String[] parts = challan.split(" " , 4);
            if(Integer.parseInt(parts[0]) == id){
                return challan;
            }
        }
        return null;
    }
    public static void updatingPaidFile(String challan) throws Exception{
        FileWriter file = new FileWriter("./CHALLANFUNDS/PaidChallanFile.txt" , true);
        file.write(challan);
        file.close();
    }
}
