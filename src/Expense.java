public class Expense {

    private String date;
    private String category;
    private double amount;
    private String note;

    public Expense(String date, String category, double amount, String note) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.note = note;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String toFileString() {
        return date + "," + category + "," + amount + "," + note;
    }

    public static Expense fromString(String line) {
        String[] parts = line.split(",");
        return new Expense(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3]);
    }

    public void display() {
        System.out.println(date + " | " + category + " | ₹" + amount + " | " + note);
    }
}


//Expense	        Represents one expense
//toFileString()	Converts expense → text (for saving)
//fromString()	    Converts text → expense (for loading)
//display()	        Prints nicely