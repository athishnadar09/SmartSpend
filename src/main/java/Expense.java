import java.time.LocalDate;

public class Expense {
        private static int nextId = 1;
        private int id;
        private double amount;
        private String category;
        private String description;
        private LocalDate date;

        public Expense (double amount, String category, String description, LocalDate date){
            this.id = nextId++;
            this.amount = amount;
            this.category = category;
            this.description = description;
            this.date = date;
        }

        //Encapsulation
        public int getId(){
            return id;
        }

        public double getAmount(){
            return amount;
        }

        public String getCategory(){
            return category;
        }

        public String getDescription(){
            return description;
        }

        public LocalDate getDate(){
            return date;
        }
}