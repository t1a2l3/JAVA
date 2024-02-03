import java.util.Scanner;

public class account{
    public String accounttitle;
    public int id ;
    public double balance;
    public account(String accounttitle , int id , double balance){
        this.accounttitle = accounttitle;
        this.id = id;
        this.balance = balance;
    }

    /*-----------------------------------------------  Add Account 1---------------------------------------------------------*/
    public static boolean Addacount(account accountArr[] , account a1){
        if(accountArr[accountArr.length -1]!= null){
            System.out.println("Account Limit Exided");
            return false ;
        }else {
            if (accountArr.length <= 5) {
                for (int i = 0; i < accountArr.length; i++) {
                    if (accountArr[i] == null) {
                        accountArr[i] = a1;
                        break;
                    }
                }
                System.out.println("Account Added");
                return true;
            } else {
                System.out.println("Account Limit Exided");
                return false;
            }
        }
    }
    /*-----------------------------------------------  Add Account 2---------------------------------------------------------*/

    public static boolean Addacount(account accountArr[] , String title , int id , double balance){
        account acc1 = new account(title , id , balance);
        if(accountArr[accountArr.length -1]!= null){
            System.out.println("Account Limit Exided");
            return false ;
        }else {
            if (accountArr.length <= 5) {
                for (int i = 0; i < accountArr.length; i++) {
                    if (accountArr[i] == null) {
                        accountArr[i] = acc1;
                        break;
                    }
                }
                System.out.println("Account Added");
                return true;
            } else {
                System.out.println("Account Limit Exided");
                return false;
            }
        }
    }


    /*-----------------------------------------------   Search Account ------------------------------------------------------------*/
    public static int searchAccount( account accountArr[],int accountID){
        for(account value : accountArr){
            if(value == null){
                break;
            }
            if(value.id == accountID){
                return value.id;
            }
        }
        return 0;
    }

    /*-----------------------------------------------Display Account Method --------------------------------------------------------*/

    public static void displayAccountsInfo(account accountArr[]){
        for(account value : accountArr){
            if(value == null){
                break;
            }else
                System.out.println("Account title : " + value.accounttitle + " Account id : " + value.id +  " Account Balance: " + value.balance );
        }
    }

    /*-----------------------------------------    Delete Account Method       -------------------------------------------------------*/

    public account deepcopy(){
        return new account(this.accounttitle, this.id , this.balance);
    }
    public static void deleteAccount(account accountArr[] , int accountID){
        for(int j = 0 ; j < accountArr.length ; j++){
            if(accountArr[j] == null){
                System.out.println("Your Account is not found");
                return ;
            }
            if(accountArr[j].id == accountID){
                for(int i = j ; i < accountArr.length ; i++){
                    for(int m = 0 ; m < accountArr.length ; m++)
                    {
                        if(accountArr[m] == null){
                            accountArr[i] = accountArr[m-1].deepcopy();
                            accountArr[m-1] = null;
                            displayAccountsInfo(accountArr);
                            return ;
                        }
                        if(m == 4){
                            accountArr[i] = accountArr[4].deepcopy();
                            accountArr[4] = null;
                            displayAccountsInfo(accountArr);
                            return ;
                        }
                    }
                }
            }
        }
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userinput = -1;
        account[] accountArr= new account[5];
        while (userinput != 0){
            System.out.println("Enter 1 to add an account\n" + "Enter 2 to search an account\n" + "Enter 3 to display accounts information\n" + "Enter 4 to delete an account\n" + "Enter 5 to exit\n");
            userinput = input.nextInt();
            if (userinput == 1) {
                System.out.println("Enter the account title");
                String title = input.next();
                System.out.println("Enter the account Id");
                int id = input.nextInt();
                System.out.println("Enter the account Balance");
                double balance = input.nextDouble();
                account acc1 = new account(title, id, balance);
//                Addacount(accountArr, acc1);
                Addacount(accountArr , title , id , balance);
            } else if (userinput == 2) {
                System.out.println("Enter the account title");
                String title = input.next();
                System.out.println("Enter the account Id");
                int id = input.nextInt();
                System.out.println("Enter the account Balance");
                double balance = input.nextDouble();
                if (searchAccount(accountArr, id) != 0) {
                    System.out.println("Your account is found");
                } else {
                    System.out.println("Your account is not found");
                }
            } else if (userinput == 3) {
                displayAccountsInfo(accountArr);
            } else if (userinput == 4) {
                System.out.println("Enter the account Id");
                int id = input.nextInt();
                deleteAccount(accountArr, id);
            } else if(userinput == 5){
                System.out.println("Exiting from the Program");
                return;
            }
        }
    }

}
