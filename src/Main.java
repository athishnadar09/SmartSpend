import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);

    static ArrayList<Expense> expenses = new ArrayList<>();
    public static void main(String[]args){
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


            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpense();
                    break;
                case 3:
                    totalExpense();
                    break;
                case 4:
                    System.out.println("Thanks for using");
                    break;
            
                default:
                    break;
            }
		System.out.println();
        }while(choice!=4);

    }

    static void addExpense(){
        System.out.println("Enter the amount you spended");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter the category");
        String category = sc.nextLine();
        System.out.println("Enter the Description");
        String  description = sc.nextLine();
        System.out.println("Enter the date");
        String date = sc.nextLine();

        Expense expense = new Expense(amount, category, description, date);
        expenses.add(expense);
    }

    static void viewExpense(){
        for(Expense expense : expenses){
            System.out.println("Amount : "+expense.amount);
            System.out.println("Category : "+expense.category);
            System.out.println("Description : "+expense.description);
            System.out.println("Date : "+expense.date);
            System.out.println("------------------------------------");
        }

    }

    static void totalExpense(){
        double sum=0;
        for(Expense expense : expenses){
            sum += expense.amount;
        }
        System.out.println("Total Expense : "+sum);

    }
}