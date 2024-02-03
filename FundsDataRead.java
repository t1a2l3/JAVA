package DataStorageLayer;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FundsDataRead {
    public static ArrayList<String> transferFundsData() throws Exception{
        File file = new File("./CHALLANFUNDS/FundsFile.txt");
        Scanner scanner = new Scanner(file);
        ArrayList<String> arrayList = new ArrayList<>();
        while(scanner.hasNextLine()){
            arrayList.add(scanner.nextLine());
        }
        scanner.close();
        return arrayList;
    }
}
