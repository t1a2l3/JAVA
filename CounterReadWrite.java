package DataStorageLayer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class CounterReadWrite {
    public static int Counter(String type) throws Exception{
        File file = new File("counter.txt");
        ArrayList<String> array =new ArrayList<>();
        Scanner sc =  new Scanner(file);
        int id = -1;
        while(sc.hasNextLine()){
            array.add(sc.nextLine());
        }
        sc.close();
        for(String arr : array){
            String parts[] = arr.split(" " , 2);
            if(parts[0].equals(type)){
                id = Integer.parseInt(parts[1]);
            }
        }
        updatingCounter(array , type);
        return id;
    }
    public static void updatingCounter(ArrayList<String> array,String type) throws Exception{
        int arraycounter = 0;
        for(String arr : array){
            String parts[] = arr.split(" " , 2);
            if(parts[0].equals(type)){
                arr = (parts[0] + " " + (Integer.parseInt(parts[1])+ 1));
                array.set(arraycounter,arr);
            }
            arraycounter++;
        }
        updatingCounterfile(array);
    }
    public static void updatingCounterfile(ArrayList<String> arrayList) throws Exception{
        FileWriter file = new FileWriter("./counter.txt");
        for(String array : arrayList){
            file.write(array + "\n");
        }
        file.close();
    }
}
