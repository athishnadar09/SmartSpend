public class Expense {
        private double amount;
        private String category;
        private String description;
        private String date;

        public Expense (double amount, String category, String description, String date){
            this.amount = amount;
            this.category = category;
            this.description = description;
            this.date = date;
        }

        //Encapsulation
        public double getAmount(){
            return amount;
        }

        public String getCategory(){
            return category;
        }

        public String getDescription(){
            return description;
        }

        public String getDate(){
            return date;
        }
}