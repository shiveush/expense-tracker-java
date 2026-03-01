import java.util.*;

public class ExpenseManager {
    private List<Expense> expenses;

    public ExpenseManager() {
        expenses = new ArrayList<>();
    }

    public void addExpense(Expense e) {
        expenses.add(e);
    }

    public void displayExpenses() {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }

    public Map<String, Double> categoryWiseTotal() {
        Map<String, Double> categoryTotal = new HashMap<>();
        double totalAmount;

        for (Expense expense : expenses) {
            String category = expense.getCategory();
            if (!categoryTotal.containsKey(category)) {
                categoryTotal.put(category, 0.0);
            }

            totalAmount = categoryTotal.get(category) + expense.getAmount();
            categoryTotal.put(category, totalAmount);
        }

        return categoryTotal;
    }
}
