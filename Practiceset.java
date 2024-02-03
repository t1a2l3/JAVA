import java .util.Scanner;
public class Practiceset {
    public String title;
    public int id;
   public double balance;

    public Practiceset(String title, int id, double balance) {
        this.title = title;
        this.id = id;
        this.balance = balance;
    }

    public static boolean addAccount(Practiceset practicArr[], Practiceset p1) {
        if (practicArr[practicArr.length - 1] != null) {
            System.out.println("Account limit exceeded");
            return false;
        } else {
            if (practicArr.length <= 5) {
                for (int i = 0; i < practicArr.length; i++) {
                    if (practicArr[i] == null) {
                        practicArr[i]=p1;
                        break;
                    }
                }
                System.out.println("Account added sucessfully");
                return true;
            }
                else
                {
                System.out.println("account limit exceeded");
                return false;}




        }

    }
    public static boolean addAccount(Practiceset practicArr[],String title,int id,double balance) {
        Practiceset pp = new Practiceset(title, id, balance);
        if (practicArr[practicArr.length - 1] != null) {
            System.out.println("Account limit exceeded");
            return false;
        } else {
            if (practicArr.length <= 5) {
                for (int i = 0; i < practicArr.length; i++) {
                    if (practicArr[i] == null) {
                        practicArr[i] = pp;
                        break;
                    }
                }
                System.out.println("Account added sucessifully");
                return true;
            } else {
                System.out.println("Account limit exceeded");
                return false;

            }

        }
    }
        public static int searchAcc (Practiceset practicArr[],int Practicesetid) {
            for (Practiceset values : practicArr) {
                if (values == null) {
                    break;
                }
                if (values.id == Practicesetid) {
                    return values.id;
                }
            }
            return 0;
        }
        public static void display(Practiceset practicArr[]) {
            for (Practiceset values : practicArr) {
                if (values == null) {
                    break;
                } else {
                    System.out.println("Account title: " + values.title + "Account id: " + values.id + "Account balance:" + values.balance);
                }
            }
        }
        public Practiceset deepCopy() {
            return new Practiceset(this.title, this.id, this.balance);
        }
        public static void delAcc(Practiceset practicArr[],int Practicesetid){
        for(int j=0;j<practicArr.length;j++) {
            if (practicArr[j] == null) {
                System.out.println("your account is not found ");
                break;
            }
            if(practicArr[j].id==Practicesetid){
                for(int i=j;i<practicArr.length;i++){
                    for(int m=0;m<practicArr.length;m++) {
                        if (practicArr[m] == null) {
                            practicArr[m] = practicArr[m - 1].deepCopy();
                            practicArr[m - 1] = null;
                            display(practicArr);
                            return;
                        }
                        if (m == 4) {
                            practicArr[m] = practicArr[m - 1].deepCopy();
                            practicArr[4] = null;
                            display(practicArr);
                            return;
                        }
                    }
                }
            }
    }
    }


    public static void main(String[] args) {
        Scanner ss=new Scanner(System.in);
        int userInput=-1;
        Practiceset [] practicArr=new Practiceset[5];
       while (userInput!=0) {
           System.out.println("Enter 1 to add an account" + "Enter 2 to search an account" + "Enter 3 to display account" + "Enter 4 to delete an account" + "Enter 5 to exit an account");
           userInput = ss.nextInt();
           if (userInput == 1) {
               System.out.println("Enter the account title ");
               String title = ss.next();
               System.out.println("Enter the account id ");
               int id = ss.nextInt();
               System.out.println("Enter the amount balance: ");
               double balance = ss.nextDouble();
               Practiceset pp = new Practiceset(title, id, balance);

               addAccount(practicArr, title, id, balance);
           } else if (userInput == 2) {
               System.out.println("Enter the account title ");
               String title = ss.next();
               System.out.println("Enter the account id ");
               int id = ss.nextInt();
               System.out.println("Enter the amount balance: ");
               double balance = ss.nextDouble();
               if (searchAcc(practicArr, id) != 0) {
                   System.out.println("your account is found");
               } else {
                   System.out.println("your acc is not found");
               }
           } else if (userInput == 3) {
               display(practicArr);
           } else if (userInput == 4) {
               System.out.println("enter account id ");
               int id = ss.nextInt();
               delAcc(practicArr, id);
           } else if (userInput == 5) {
               System.out.println("Exiting the program");


           }
       }
    }
}








































