import java.io.*;
import java.util.*;

public class Main {
    private static final String FILE_NAME = "expenses.txt";
    private static ExpenseManager expenseManager = new ExpenseManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        boolean quit = false;

        while (!quit) {
            System.out.println("\nExpense Tracker\n");
            System.out.println("1. Add expense");
            System.out.println("2. View expenses");
            System.out.println("3. Category-wise total");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addExpense(scanner);
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    categoryWiseTotal();
                    break;
                case 4:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

           
        }

        scanner.close();
    }

    private static void addExpense(Scanner scanner) {
        System.out.print("Enter date (yyyy-MM-dd): ");
        String date = scanner.next();
        System.out.print("Enter category: ");
        String category = scanner.next();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter description: ");
        scanner.nextLine(); // Consume newline character
        String description = scanner.nextLine();

        Expense expense = new Expense(date, category, amount, description);
        expenseManager.addExpense(expense);
    }

    private static void viewExpenses() {
        System.out.println("\nExpenses:");
        expenseManager.displayExpenses();
    }

    private static void categoryWiseTotal() {
        Map<String, Double> categoryTotal = expenseManager.categoryWiseTotal();
        System.out.println("\nCategory-wise Total:");
        for (Map.Entry<String, Double> entry : categoryTotal.entrySet()) {
            System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue());
        }
    }

    private static void saveToFile(List<Expense> expenses) {
        FileHandler.saveToFile(expensesManagerToString(expenses));
    }

    private static String expensesManagerToString(List<Expense> expenses) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Expense expense : expenses) {
            stringBuilder.append(expense).append("\n");
        }

        return stringBuilder.toString();
    }
}
