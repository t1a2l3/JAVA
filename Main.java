import java.util.Scanner;

import EXCEPTIONS.*;
import Presentation.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Welcome to the System!\n1. Press 1 if You are Costumer\n2. Press 2 if You are Employee\n3. Press 3 to exit the program");
            int persontype = OwnExceptions.integerinput();
            while(!(persontype == 1 || persontype == 2 || persontype == 3)){
                persontype = OwnExceptions.integerinput();
            }
            if(persontype == 1){
                CostumerLoginMenu_and_PayMethodsP.costumerLogin(sc);
            }else if (persontype == 2){
                EmployeeLogin_and_MenuP.employeeLogin(sc);
            }else{
                return;
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}