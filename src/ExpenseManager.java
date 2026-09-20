import java.util.ArrayList;

public class ExpenseManager {
    static ArrayList<Expense> expenses = new ArrayList<>();
    public void addExpense(Expense expense){
        expenses.add(expense);
    }
    public void viewExpense(){
        for(Expense expense : expenses){
            System.out.println("Amount : "+expense.getAmount());
            System.out.println("Category : "+expense.getCategory());
            System.out.println("Description : "+expense.getDescription());
            System.out.println("Date : "+expense.getDate());
            System.out.println("----------------------------------------");
        }
    }
    public void totalExpense(){
        double sum = 0;
        for(Expense expense : expenses){
            sum += expense.getAmount();
        }
        System.out.println("Total Expense : ₹"+sum);
    }
    
}
