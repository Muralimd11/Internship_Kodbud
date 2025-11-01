import java.util.Scanner;

public class SimpleATM {

    static double balance = 1000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("=== Welcome to Simple ATM ===");

        do {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }


    public static void checkBalance() {
        System.out.println("Your current balance is: Rs." + balance);
    }

    public static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: Rs.");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited Rs." + amount);
            System.out.println("Updated balance: Rs." + balance);
        } else {
            System.out.println("Invalid amount! Please enter a positive value.");
        }
    }

    public static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: Rs.");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn Rs." + amount);
            System.out.println("Updated balance: Rs." + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid amount!");
        }
    }
}