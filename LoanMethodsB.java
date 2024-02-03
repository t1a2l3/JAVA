package BusinessLogicLayer.CostumerAccessoriesB;

import CostumerManagement.CHECKINGACCOUNTCOSTUMER;
import CostumerManagement.Costumer;
import CostumerManagement.FIXEDDEPOSITACCOUNTCOSTUMER;
import CostumerManagement.SAVINGACCOUNTCOSTUMER;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LoanMethodsB {
    // These three methods are use get the objects based on their types by using Id
    public static CHECKINGACCOUNTCOSTUMER getCosByIdForApprovalC(int Id) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ACCOUNTS/checkingaccounts.txt"));
        ArrayList<CHECKINGACCOUNTCOSTUMER> arrayList2 =(ArrayList<CHECKINGACCOUNTCOSTUMER>)  ois.readObject();
        ois.close();
        for(CHECKINGACCOUNTCOSTUMER array : arrayList2){
            if(array.getId() == Id){
                return array;
            }
        }
        return null;
    }
    public static SAVINGACCOUNTCOSTUMER getCosByIdForApprovalS(int Id) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ACCOUNTS/savingaccounts.txt"));
        ArrayList<SAVINGACCOUNTCOSTUMER> arrayList1 =(ArrayList<SAVINGACCOUNTCOSTUMER>)  ois.readObject();
        ois.close();
        for(SAVINGACCOUNTCOSTUMER array : arrayList1){
            if(array.getId() == Id){
                return array;
            }
        }
        return null;
    }
    public static FIXEDDEPOSITACCOUNTCOSTUMER getCosByIdForApprovalF(int Id) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ACCOUNTS/checkingaccounts.txt"));
        ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER> arrayList3 =(ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER>)  ois.readObject();
        ois.close();
        for(FIXEDDEPOSITACCOUNTCOSTUMER array : arrayList3){
            if(array.getId() == Id){
                return array;
            }
        }
        return null;
    }
    // This method is used to get the Object based on its id
    public static Costumer getCosByIdForApproval(int Id) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ACCOUNTS/savingaccounts.txt"));
        ArrayList<SAVINGACCOUNTCOSTUMER> arrayList1 =(ArrayList<SAVINGACCOUNTCOSTUMER>)  ois.readObject();
        ois.close();
        for(SAVINGACCOUNTCOSTUMER array : arrayList1){
            if(array.getId() == Id){
                return array;
            }
        }
        ois = new ObjectInputStream(new FileInputStream("ACCOUNTS/checkingaccounts.txt"));
        ArrayList<CHECKINGACCOUNTCOSTUMER> arrayList2 =(ArrayList<CHECKINGACCOUNTCOSTUMER>)  ois.readObject();
        ois.close();
        for(CHECKINGACCOUNTCOSTUMER array : arrayList2){
            if(array.getId() == Id){
                return array;
            }
        }
        ois = new ObjectInputStream(new FileInputStream("ACCOUNTS/checkingaccounts.txt"));
        ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER> arrayList3 =(ArrayList<FIXEDDEPOSITACCOUNTCOSTUMER>)  ois.readObject();
        ois.close();
        for(FIXEDDEPOSITACCOUNTCOSTUMER array : arrayList3){
            if(array.getId() == Id){
                return array;
            }
        }
        return null;
    }
}
