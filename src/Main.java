import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static ArrayList<Expense> expenses = new ArrayList<>();

    static HashMap<String, Double> categoryTotals = new HashMap<>();
    public static void main(String[]args){
        int choice;
        do{
            System.out.println("====SMART SPEND====");
            System.out.println("1.Add Expense");
            System.out.println("2.View Expense");
            System.out.println("3.Total Expense");
            System.out.println("4. Category Summary");
            System.out.println("5.Exit");
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
                case 4 :
                    categorySummary();
                    break;
                case 5:
                    System.out.println("Thanks for using");
                    break;
            
                default:
                    break;
            }
		System.out.println();
        }while(choice!=5);

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
        System.out.println("Enter the date");
        String date = sc.nextLine();

        Expense expense = new Expense(amount, category, description, date);
        expenses.add(expense);
    }

    static void viewExpense(){
        for(Expense expense : expenses){
            System.out.println("Amount : "+expense.getAmount());
            System.out.println("Category : "+expense.getCategory());
            System.out.println("Description : "+expense.getDescription());
            System.out.println("Date : "+expense.getDate());
            System.out.println("------------------------------------");
        }

    }

    static void totalExpense(){
        double sum=0;
        for(Expense expense : expenses){
            sum += expense.getAmount();
        }
        System.out.println("Total Expense : "+sum);

    }

    static void categorySummary(){
        for (Expense expense : expenses){
            String category = expense.getCategory();
            double amount = expense.getAmount();
            categoryTotals.put(category, categoryTotals.getOrDefault(category, 0.0)+amount);
        }

        for(String category : categoryTotals.keySet()){
            System.out.println(category+" : ₹"+categoryTotals.get(category));
        }
    }
}