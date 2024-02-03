package BusinessLogicLayer;

import CostumerManagement.CHECKINGACCOUNTCOSTUMER;
import CostumerManagement.Costumer;
import CostumerManagement.FIXEDDEPOSITACCOUNTCOSTUMER;
import CostumerManagement.SAVINGACCOUNTCOSTUMER;

import java.time.LocalDate;

public class WithdrawB {
    // Automatically reset withdrawal limit based on the current month
    private static void checkAndResetWithdrawalLimit(CHECKINGACCOUNTCOSTUMER costumer, LocalDate currentDate) {
        if (currentDate.getMonthValue() != costumer.getLocaldate().getMonthValue()) {
            costumer.setWithdrawalLimit(10);
            costumer.setLocaldate(currentDate);
        }
    }
    private static int withdraw(double ammounttowithdraw ,CHECKINGACCOUNTCOSTUMER costumer){
        checkAndResetWithdrawalLimit(costumer,LocalDate.now());
        if(costumer.getWithdrawalLimit() > 0){
            if(costumer.getTotal_Balance() + costumer.getOverdraftLimit() >= ammounttowithdraw){
                costumer.setTotal_Balance(costumer.getTotal_Balance() - ammounttowithdraw);
                costumer.setWithdrawalLimit(costumer.getWithdrawalLimit()-1);
                return 1;
            }else{
                return 0;
            }
        }
        else {
            return -1;
        }
    }
    private static int withdraw(double ammounttowithdraw , SAVINGACCOUNTCOSTUMER costumer){
        checkAndResetWithdrawalLimit(costumer , LocalDate.now());
        if(costumer.getWithdrawalLimit() > 0){
            if(costumer.getTotal_Balance() >= ammounttowithdraw){
                costumer.setTotal_Balance(costumer.getTotal_Balance() - ammounttowithdraw);
                costumer.setWithdrawalLimit(costumer.getWithdrawalLimit()-1);
                return 1;
            }else{
                return 0;
            }
        }
        else {
            return -1;
        }
    }
    private static void checkAndResetWithdrawalLimit(SAVINGACCOUNTCOSTUMER costumer, LocalDate currentDate) {
        if (currentDate.getMonthValue() != costumer.getLocaldate().getMonthValue()) {
            costumer.setWithdrawalLimit(10);
            costumer.setLocalDate(currentDate);
        }
    }
    private static void allowingtowithdraw(LocalDate currentDate,FIXEDDEPOSITACCOUNTCOSTUMER costumer){
        if(currentDate.getMonthValue() == costumer.getMaturityDate().getMonthValue()){
            System.out.println("Now You can withdraw or transfer your money from your account");
            int value = costumer.getWithdrawalLimit() + 1;
            costumer.setWithdrawalLimit(value);
        }
    }
    private static int withdraw(double ammounttowithdraw, FIXEDDEPOSITACCOUNTCOSTUMER costumer){
        allowingtowithdraw(LocalDate.now(),costumer);
        if(costumer.getWithdrawalLimit() > 0){
            return 1;
        }
        else {
            return -1;
        }
    }
    public static int withdraw(double amount ,Costumer costumer){
        if(costumer instanceof SAVINGACCOUNTCOSTUMER){
            return WithdrawB.withdraw(amount,(SAVINGACCOUNTCOSTUMER) costumer);
        }else if(costumer instanceof CHECKINGACCOUNTCOSTUMER){
            return WithdrawB.withdraw(amount,(CHECKINGACCOUNTCOSTUMER) costumer);
        }else{
            return WithdrawB.withdraw(amount,(FIXEDDEPOSITACCOUNTCOSTUMER) costumer);
        }
    }
}
