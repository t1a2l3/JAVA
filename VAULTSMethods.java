package DataStorageLayer;

import CostumerManagement.Costumer;
import VAULTPackage.Locker;
import VAULTPackage.SINGLEKEY;
import VAULTPackage.Vault;

import java.io.*;

public class VAULTSMethods {
    public static File getvaultFile(String lockertype){
        File file;
        switch (lockertype) {
            case "SINGLEKEY" -> file = new File("VAULTS/SINGLEKEYVAULT.txt");
            case "DUALKEY" -> file = new File("VAULTS/DUALKEYVAULT.txt");
            case "BIOMETRIC" -> file = new File("VAULTS/BIOMETRIC.txt");
            case "SAFEDDEPOSIT" -> file = new File("VAULTS/SAFEDDEPOSIT.txt");
            default -> file = new File("VAULTS/CUSTOMIZED.txt");
        }
        return file;
    }
    // This method is calling the assignlocker method and getVault method
    public static void AssignLocker(String lockertype, Costumer costumer){
        File file ;
        switch (lockertype) {
            case "SINGLEKEY" -> file = new File("VAULTS/SINGLEKEYVAULT.txt");
            case "DUALKEY" -> file = new File("VAULTS/DUALKEYVAULT.txt");
            case "BIOMETRIC" -> file = new File("VAULTS/BIOMETRIC.txt");
            case "SAFEDDEPOSIT" -> file = new File("VAULTS/SAFEDDEPOSIT.txt");
            default -> file = new File("VAULTS/CUSTOMIZED.txt");
        }
        Vault vault = null;
        try {
            vault = getVault(file);
            if (vault != null) {
                assignlocker(file, vault, costumer);
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    private static Vault getVault(File file) throws Exception{
        if(file.isFile()){
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream(file));
            Vault vault = (Vault) oos.readObject();
            oos.close();
            return vault;
        }
        return null;
    }
    // this method call updatevault method to update the vault lockers after assigning a locker
    private static int assignlocker(File file , Vault vault, Costumer costumer) throws Exception{
        boolean assigncondition = false;
        int lockerassigned = -1;
        for(int i = 0; i < vault.getTotalRooms() ; i++){
            for(int j = 0 ; j < vault.getLockersPerRoom(); j++){
                if(vault.getLocker()[i][j].getIsOccupy() == Locker.ISOCCUPY.EMPTY) {
                    vault.getLocker()[i][j].setIsOccupy(Locker.ISOCCUPY.OCCUPIED);
                    costumer.setLOCKER(vault.getLocker()[i][j]);
                    assigncondition = true;
                    break;
                }
            }
            if(assigncondition){
                break;
            }
        }
        if(assigncondition == true){
            updatevault(file,vault);
        }
        return lockerassigned;
    }
    private static void updatevault(File file , Vault vault) throws Exception{
        if(file.isFile()){
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(vault);
            oos.close();
        }
    }
}
