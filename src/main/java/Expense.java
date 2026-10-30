
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false, length = 100)
    private String category;

    @Column(nullable = false, length = 255)
    private String description;

    @Column(nullable = false)
    private LocalDate date;

    // Required by Hibernate
    public Expense() {
    }

    // Constructor for adding new expenses
    public Expense(double amount, String category,
                   String description, LocalDate date) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }
}
