import java.util.ArrayList;
import java.util.HashMap;

public class ExpenseManager {
    static ArrayList<Expense> expenses = new ArrayList<>();
    public void addExpense(Expense expense){
        expenses.add(expense);
    }
    public void viewExpense(){
        for(Expense expense : expenses){
            System.out.println("ID : "+expense.getId());
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
    public void categorySummary(){
        HashMap<String, Double> categoryTotals = new HashMap<>();
        for(Expense expense : expenses){
            String category = expense.getCategory();
            double amount = expense.getAmount();

            categoryTotals.put(category, categoryTotals.getOrDefault(category, 0.0)+amount);
        }
        for(String category : categoryTotals.keySet()){
            System.out.println(category+" : ₹"+categoryTotals.get(category));
        }
    }

    public void deleteExpense (int id){
        for (Expense expense : expenses){
            if(expense.getId()==id){
                expenses.remove(expense);
                System.out.println("Expense deleted successfully.");
                return;
            }
        }
        System.out.println("Expense with ID "+id+"not found");
    }

    
}
