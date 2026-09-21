import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.time.LocalDate;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static ExpenseManager manager = new ExpenseManager();

    public static void main(String[]args){
        int choice;
        do{
            System.out.println("====SMART SPEND====");
            System.out.println("1.Add Expense");
            System.out.println("2.View Expense");
            System.out.println("3.Total Expense");
            System.out.println("4.Category Summary");
            System.out.println("5.Delete Expense");
            System.out.println("6.Exit");
            System.out.println("====================");
            System.out.println("Enter the choice");
            choice = sc.nextInt();


            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    manager.viewExpense();
                    break;
                case 3:
                    manager.totalExpense();
                    break;
                case 4 :
                    manager.categorySummary();
                    break;
                case 5 :
                    System.out.println("Enter the Id of Expense which to be Deleted");
                    int id = sc.nextInt();
                    manager.deleteExpense(id);
                    break;
                case 6:
                    System.out.println("Thanks for using");
                    break;
            
                default:
                    break;
            }
		System.out.println();
        }while(choice!=6);

    }

    static void addExpense(){
        System.out.println("Enter the amount you spended");
        double amount;
        try{
            amount = sc.nextDouble();
            if(amount<=0){
                System.out.println("Amount should be greater than 0");
                return;
            }
        }
        catch(InputMismatchException e){
            System.out.println("Please enter the valid number");
            sc.nextLine();
            return;
        }
        sc.nextLine();
        System.out.println("Enter the category");
        String category = sc.nextLine();
        if(category.trim().isEmpty()){
            System.out.println("Category cannot be Empty");
            return;
        }
        System.out.println("Enter the Description");
        String  description = sc.nextLine();
        if(description.trim().isEmpty()){
            System.out.println("description cannot be Empty");
            return;
        }
        System.out.println("Enter the date (YYYY-MM-DD)");
        String dateInput = sc.nextLine();
        LocalDate date;
        try {
            date = LocalDate.parse(dateInput);
        } catch (Exception e) {
            System.out.println("Invalid Date. Use (YYYY-MM-DD)");
            return;
        }

        Expense expense = new Expense(amount, category, description, date);
        manager.addExpense(expense);
        System.out.println("Expense added successfully");
    }

   
}