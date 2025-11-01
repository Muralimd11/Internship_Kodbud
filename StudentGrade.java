import java.util.Scanner;

class Student {
    String name;
    int[] marks = new int[3];
    double average;
    char grade;

    public void inputDetails(Scanner scanner) {
        System.out.print("Enter student name: ");
        name = scanner.nextLine();

        System.out.println("Enter marks for 3 subjects:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
    }

    public void calculateGrade() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        average = total / 3.0;

        if (average >= 90) {
            grade = 'A';
        } else if (average >= 75) {
            grade = 'B';
        } else if (average >= 50) {
            grade = 'C';
        } else {
            grade = 'F';
        }
    }

    public void displayReport() {
        System.out.println("\nStudent Report");
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks[0] + ", " + marks[1] + ", " + marks[2]);
        System.out.printf("Average: %.2f\n", average);
        System.out.println("Grade: " + grade);
        System.out.println("-----------------------");
    }
}

public class StudentGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Enter details for Student " + (i + 1) + " ---");
            students[i] = new Student();
            students[i].inputDetails(scanner);
            students[i].calculateGrade();
        }

        System.out.println("\n\n=== All Student Reports ===");
        for (Student s : students) {
            s.displayReport();
        }

        scanner.close();
    }
}
