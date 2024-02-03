package DataStorageLayer;

import EmployeeManagement.Employee;

import java.io.*;
import java.util.ArrayList;

public class EmployeeReadWrite {
    public static void EmployeeSaving(Employee employee) throws Exception{
        File file = new File("./EMPLOYEES/EMPLOYEES.txt");
        ArrayList<Employee> arrayList = new ArrayList<>();
        if(file.isFile()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            arrayList = (ArrayList<Employee>) ois.readObject();
            ois.close();
        }
        arrayList.add(employee);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(arrayList);
        oos.close();
    }
    public static ArrayList<Employee> EmployeeRead() throws Exception{
        File file = new File("./EMPLOYEES/EMPLOYEES.txt");
        ArrayList<Employee> arrayList = new ArrayList<>();
        if(file.isFile()){
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            arrayList=(ArrayList<Employee>) ois.readObject();
            ois.close();
        }
        return arrayList;
    }
    // Use to write all employees after changing a specific employee
    public static void EmployeesWriting(ArrayList<Employee> employees) throws Exception{
        File file = new File("./EMPLOYEES/EMPLOYEES.txt");
        if(file.isFile()){
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(employees);
            oos.close();
        }
    }
}
