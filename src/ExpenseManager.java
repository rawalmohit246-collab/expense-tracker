import java.io.*;

public class ExpenseManager {

    private static final String FILE_NAME = "expenses.txt";


    public static void addExpense(Expense expense) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(expense.toFileString() + "\n");
            System.out.println("Expense saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving expense.");
        }
    }


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
}
