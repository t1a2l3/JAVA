import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Filehandlind {
    public static void main(String[] args) {
        // this is create a file
        //File myfile=new File("jj.txt");
        //try {
          //  myfile.createNewFile();
        //} catch (IOException e) {
          //  System.out.println("not create a file");
            //throw new RuntimeException(e);
        //}
        // writing a file
        //try {
          //  FileWriter fileWriter=new FileWriter("jj.txt");
            //fileWriter.write("this is our first file in java ");
            //fileWriter.close();
       // } catch (IOException e) {
         //   System.out.println("not write a data in file");
           // throw new RuntimeException(e);
       // }
        // reading a file
   //  File myfile=new File("jj.txt");
     //   try {
        //     Scanner sc=new Scanner(myfile);
          //  while (sc.hasNextLine()){
        //    String line= sc.nextLine();
          //      System.out.println(line);

            //}
       // sc.close();
        //} catch (FileNotFoundException e) {
          //  throw new RuntimeException(e);
        //}
        // delete a file
        File myfile=new File("jj.txt");
        if(myfile.delete()){
            System.out.println("delete the file: "+myfile);
        }
        else{
            System.out.println("not delete the file");
        }

    }
}
