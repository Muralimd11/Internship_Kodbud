import java.util.Scanner;
import java.util.HashMap;

public class LoginSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> credentials = new HashMap<>();
        credentials.put("admin", "admin123");
        credentials.put("user", "password");
        credentials.put("john", "john123");

        System.out.println("=== Welcome to Simple Login System ===");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (credentials.containsKey(username)) {
            if (credentials.get(username).equals(password)) {
                System.out.println("Login successful! Welcome, " + username + "!");
            } else {
                System.out.println("Login failed! Incorrect password.");
            }
        } else {
            System.out.println("Login failed! Username not found.");
        }

        scanner.close();
    }
}
