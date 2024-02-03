package BusinessLogicLayer;

import DataStorageLayer.EmployeeReadWrite;
import EmployeeManagement.Employee;

import java.util.ArrayList;

public class EmployeeUpdationB {
    public static void EmployeeUpdation(Employee employee) throws Exception{
        ArrayList<Employee> employees = AccountUpdation(employee);
        EmployeeReadWrite.EmployeesWriting(employees);
    }
    private static ArrayList<Employee> AccountUpdation(Employee employee) throws Exception{
        ArrayList<Employee> employees = EmployeeReadWrite.EmployeeRead();
        int counter = 0;
        for(Employee emp : employees){
            if(emp.getId() == employee.getId()){
                employees.set(counter , employee);
            }
            counter += 1;
        }
        return employees;
    }
}
