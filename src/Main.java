import java.util.Scanner;
public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("====SMART SPEND====");
            System.out.println("1.Add Expense");
            System.out.println("2.View Expense");
            System.out.println("3.Total Expense");
            System.out.println("4.Exit");
            System.out.println("====================");
            System.out.println("Enter the choice");
            choice = sc.nextInt();
        }while(choice!=4);
    }
}
