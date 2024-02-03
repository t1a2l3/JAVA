package Presentation;
import BusinessLogicLayer.CostumerGmailB;
import CostumerManagement.CHECKINGACCOUNTCOSTUMER;
import CostumerManagement.FIXEDDEPOSITACCOUNTCOSTUMER;
import CostumerManagement.SAVINGACCOUNTCOSTUMER;
import DataStorageLayer.CostumerDataRead;
import DataStorageLayer.CostumerDataStorage;
import EXCEPTIONS.OwnExceptions;

import java.util.ArrayList;
import java.util.Scanner;

public class CostumerForgotPasswordP {

    public static void fogetPasswordMain() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Either the Gmail or the Password is wrong.");
        System.out.println("If You Want to reset Your Password Press 1 \nPress 0 to exit : ");
        int resetChoice = sc.nextInt();
        if(resetChoice == 0){
            return;
        }else if(resetChoice == 1){
            System.out.println("Press 1 to Reset with SecurityQuestion \n Press 2 to Reset with Gmail Id : ");
            int methodChoice = sc.nextInt();
            if(methodChoice == 1){
                int confirmation = CostumerForgotPasswordP.recoverPasswordUsingSecurityQues();
                if(confirmation == 1){
                    System.out.println("Password Changed SuccessFully!!!");
                }else{
                    System.out.println("Error Occured Please try again laiter");
                }
            }else if(methodChoice == 2){
                System.out.println("Enter Your Email id : ");
                String emailId = OwnExceptions.gmailinput();
                if(CostumerGmailB.gmail(emailId)){
                    int sPin = PasswordResetEmailP.AccountResetEmail(emailId);
                    System.out.println("Enter the PIN that you recieved on your Email Id");
                    int rPin = sc.nextInt();
                    if(sPin == rPin){
                        int result = CostumerForgotPasswordP.recoverPasswordUsingGmail(emailId);
                        if(result == 1){
                            System.out.println("Password Changed Successfully!!!");
                        }else{
                            System.out.println("Error Occured Please try again Latter");
                        }
                    }else{
                        System.out.println("PIN you entered is not correct");
                    }
                }else{
                    System.out.println("Email You Entered is not Correct\nTry again with valid Email");
                }
            }else{
                System.out.println("You entered wrong Choice rerun Program and try again ");
                return;
            }
        }else{
            System.out.println("You entered wrong Choice rerun Program and try again ");
            return;
        }
    }
    private static int recoverPasswordUsingSecurityQues() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Your Email Id : ");
        String emailId = OwnExceptions.gmailinput();
        System.out.print("Enter the Security Question : ");
        String securityQuestion = scanner.next();
        boolean condition = false;
        ArrayList<SAVINGACCOUNTCOSTUMER> savingaccountcostumers = CostumerDataRead.savingAccountData();
        for(SAVINGACCOUNTCOSTUMER savingaccountcostumer : savingaccountcostumers){
            if(savingaccountcostumer.getEmailAdress().equals(emailId)){
                if(savingaccountcostumer.getSecurityQuestion().equals(securityQuestion)){
                    savingaccountcostumer.setPassword(newPassword(scanner));
                    CostumerDataStorage.savingUpdatedDataInFileS(savingaccountcostumers);
                    return 1;
                }
            }
        }
        ArrayList<CHECKINGACCOUNTCOSTUMER> checkingaccountcostumers =CostumerDataRead.checkingAccountData();
        for(CHECKINGACCOUNTCOSTUMER checkingaccountcostumer : checkingaccountcostumers){
            if(checkingaccountcostumer.getEmailAdress().equals(emailId)){
                if(checkingaccountcostumer.getSecurityQuestion().equals(securityQuestion)){
                    checkingaccountcostumer.setPassword(newPassword(scanner));
                    CostumerDataStorage.savingUpdatedDataInFileC(checkingaccountcostumers);
                    return 1;
                }
            }
        }
        ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER> fixeddepositaccountcostumers =CostumerDataRead.fixedDepositAccountData();
        for(FIXEDDEPOSITACCOUNTCOSTUMER fixeddepositaccountcostumer : fixeddepositaccountcostumers){
            if(fixeddepositaccountcostumer.getEmailAdress().equals(emailId)){
                if(fixeddepositaccountcostumer.getSecurityQuestion().equals(securityQuestion)){
                    fixeddepositaccountcostumer.setPassword(newPassword(scanner));
                    CostumerDataStorage.savingUpdatedDataInFileF(fixeddepositaccountcostumers);
                    return 1;
                }
            }
        }
        return -1;
    }
    private static int recoverPasswordUsingGmail(String emailId) throws Exception{
        Scanner scanner = new Scanner(System.in);
        boolean condition = false;
        ArrayList<SAVINGACCOUNTCOSTUMER> savingaccountcostumers = CostumerDataRead.savingAccountData();
        for(SAVINGACCOUNTCOSTUMER savingaccountcostumer : savingaccountcostumers){
            if(savingaccountcostumer.getEmailAdress().equals(emailId)){
                savingaccountcostumer.setPassword(newPassword(scanner));
                CostumerDataStorage.savingUpdatedDataInFileS(savingaccountcostumers);
                return 1;
            }
        }
        ArrayList<CHECKINGACCOUNTCOSTUMER> checkingaccountcostumers =CostumerDataRead.checkingAccountData();
        for(CHECKINGACCOUNTCOSTUMER checkingaccountcostumer : checkingaccountcostumers){
            if(checkingaccountcostumer.getEmailAdress().equals(emailId)){
                checkingaccountcostumer.setPassword(newPassword(scanner));
                CostumerDataStorage.savingUpdatedDataInFileC(checkingaccountcostumers);
                return 1;
            }
        }
        ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER> fixeddepositaccountcostumers =CostumerDataRead.fixedDepositAccountData();
        for(FIXEDDEPOSITACCOUNTCOSTUMER fixeddepositaccountcostumer : fixeddepositaccountcostumers){
            if(fixeddepositaccountcostumer.getEmailAdress().equals(emailId)){
                fixeddepositaccountcostumer.setPassword(newPassword(scanner));
                CostumerDataStorage.savingUpdatedDataInFileF(fixeddepositaccountcostumers);
                return 1;
            }
        }
        return -1;
    }

    private static String newPassword(Scanner sc) throws Exception{
        boolean condition = false;
        System.out.print("Enter the New Password : ");
        String password1 = OwnExceptions.passwordinput();
        System.out.print("Fer Soch laa baar baar change nai honda : ");
        String password2 = OwnExceptions.passwordinput();
        while(!condition) {
            if (password1.equals(password2)) {
                condition = true;
                return password2;
            }else{
                System.out.print("Password Not Matched Try again!!!\nEnter the New Password : ");
                password1 = OwnExceptions.passwordinput();
                System.out.print("Fer Soch laa baar baar change nai honda : ");
                password2 = OwnExceptions.passwordinput();
            }
        }
        return null;
    }
}
