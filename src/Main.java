import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== EXPENSE TRACKER ======");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter date (dd-mm-yyyy): ");
                    String date = sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter note: ");
                    String note = sc.nextLine();

                    Expense expense = new Expense(date, category, amount, note);
                    ExpenseManager.addExpense(expense);
                    break;

                case 2:
                    ExpenseManager.showAllExpenses();
                    break;

                case 3:
                    System.out.println("Thank you for using Expense Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}
