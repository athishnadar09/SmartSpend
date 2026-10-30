
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ExpenseManager {

    // Add expense
    public void addExpense(Expense expense) {
        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(expense);

            transaction.commit();

            System.out.println("Expense added successfully!");

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            System.out.println("Error adding expense: " + e.getMessage());
        }
    }

    // View all expenses
    public void viewExpenses() {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            List<Expense> expenses = session
                    .createSelectionQuery(
                            "FROM Expense ORDER BY date DESC",
                            Expense.class)
                    .getResultList();

            if (expenses.isEmpty()) {
                System.out.println("No expenses found.");
                return;
            }

            for (Expense expense : expenses) {
                System.out.println("-------------------------");
                System.out.println("ID: " + expense.getId());
                System.out.println("Amount: " + expense.getAmount());
                System.out.println("Category: " + expense.getCategory());
                System.out.println("Description: " + expense.getDescription());
                System.out.println("Date: " + expense.getDate());
            }

            System.out.println("-------------------------");

        } catch (Exception e) {
            System.out.println("Error viewing expenses: " + e.getMessage());
        }
    }

    // Calculate total expenses
    public void totalExpense() {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            Double total = session.createSelectionQuery(
                    "SELECT COALESCE(SUM(e.amount), 0.0) FROM Expense e",
                    Double.class)
                    .getSingleResult();

            System.out.println("Total Expenses: " + total);

        } catch (Exception e) {
            System.out.println("Error calculating total: " + e.getMessage());
        }
    }

    // Category-wise summary
    public void categorySummary() {

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            List<Object[]> results = session.createSelectionQuery(
                    "SELECT e.category, SUM(e.amount) " +
                    "FROM Expense e GROUP BY e.category",
                    Object[].class)
                    .getResultList();

            if (results.isEmpty()) {
                System.out.println("No expenses found.");
                return;
            }

            System.out.println("Category-wise Summary:");

            for (Object[] result : results) {
                System.out.println(
                        result[0] + " : " + result[1]);
            }

        } catch (Exception e) {
            System.out.println("Error generating summary: " + e.getMessage());
        }
    }

    // Delete expense
    public void deleteExpense(int id) {

        Transaction transaction = null;

        try (Session session =
                HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Expense expense = session.find(Expense.class, id);

            if (expense == null) {
                System.out.println("Expense not found.");
                transaction.rollback();
                return;
            }

            session.remove(expense);

            transaction.commit();

            System.out.println("Expense deleted successfully!");

        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            System.out.println("Error deleting expense: " + e.getMessage());
        }
    }
}
