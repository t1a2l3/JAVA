package Presentation.CostumerAccessories;

import DataStorageLayer.VAULTSMethods;
import VAULTPackage.Locker;
import VAULTPackage.Vault;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class VAULTSMethodsP {
    public static String lockerType(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Vault Type : ");
        String lockerType = sc.next();
        while(!(lockerType.equals("SINGLEKEY") || lockerType.equals("DUALKEY") || lockerType.equals("BIOMETRIC") || lockerType.equals("SAFEDDEPOSIT") || lockerType.equals("CUSTOMIZED"))){
            System.out.println("Please Enter from one of the following : \n1. SINGLEKEY \n2. DUALKEY \n3. BIOMETRIC \n4. SAFEDDEPOSIT \n5. CUSTOMIZED");
            lockerType = sc.next();
        }
        return lockerType;
    }
    public static void displayVault() throws Exception{
        String vaulttype = lockerType();
        File file = VAULTSMethods.getvaultFile(vaulttype);
        displayVault(file);
    }
    private static void displayVault(File file) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Vault vault = (Vault) ois.readObject();
        ois.close();
        for(int i = 0 ; i < vault.getTotalRooms(); i++){
            for(int j = 0 ; j < vault.getLockersPerRoom(); j++){
                if(vault.getLocker()[i][j].getIsOccupy() == Locker.ISOCCUPY.EMPTY){
                    System.out.print(" - ");
                }else{
                    System.out.print(" x ");
                }
            }
            System.out.println();
        }
    }
}
