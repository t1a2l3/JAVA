import java.util.Scanner;


public class Lab {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        int []array={1,2,3};
        System.out.println("enter the value");
        int a= sc.nextInt();
        try {
            if(a>2 && a<0){
                throw new outOfBounce(a);
            }
            System.out.println(array[a]);
        }
        catch (outOfBounce e){
            System.out.println(e);
        }


    }


}
class outOfBounce extends Exception{
    String error;
    int value;
    public outOfBounce(int value){
        this.error="system is out of bounce";
        this.value=value;
    }
    @Override
    public String toString(){
        return error +"value"+value;

    }


}
