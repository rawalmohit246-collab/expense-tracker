import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ExpenseManager {

    private static final String FILE_NAME = "expenses.txt";

    // Add expense
    public static void addExpense(Expense expense) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(expense.toFileString() + "\n");
            System.out.println("Expense saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving expense.");
        }
    }

    // Show all expenses
    public static void showAllExpenses() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No expenses found.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("\n----- Expense List -----");
            while ((line = br.readLine()) != null) {
                Expense expense = Expense.fromString(line);
                expense.display();
            }
        } catch (IOException e) {
            System.out.println("Error reading expenses.");
        }
    }

    // ⭐ Category-wise summary
    public static void showCategorySummary() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No expenses found.");
            return;
        }

        Map<String, Double> categoryTotals = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                Expense expense = Expense.fromString(line);

                String category = expense.getCategory();
                double amount = expense.getAmount();

                categoryTotals.put(
                        category,
                        categoryTotals.getOrDefault(category, 0.0) + amount
                );
            }

            System.out.println("\n--- Category Wise Summary ---");
            for (String category : categoryTotals.keySet()) {
                System.out.println(category + " : ₹" + categoryTotals.get(category));
            }

        } catch (IOException e) {
            System.out.println("Error reading expenses.");
        }
    }
}
