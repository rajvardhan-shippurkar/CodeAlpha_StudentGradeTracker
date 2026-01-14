package src.main;

import java.util.ArrayList;
import java.util.Scanner;

import src.model.Student;
import src.service.GradeService;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        GradeService service = new GradeService();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Grade Tracker =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Report");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter marks (0-100): ");
                    int marks = sc.nextInt();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Invalid marks! Please enter between 0 and 100.");
                        break;
                    }

                    students.add(new Student(name, marks));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No student records found.");
                        break;
                    }

                    System.out.println("\n--- Student Summary Report ---");
                    for (Student s : students) {
                        System.out.println("Name: " + s.getName() +
                                " | Marks: " + s.getMarks());
                    }

                    System.out.println("\nAverage Marks: " +
                            service.calculateAverage(students));
                    System.out.println("Highest Marks: " +
                            service.getHighest(students));
                    System.out.println("Lowest Marks: " +
                            service.getLowest(students));
                    break;

                case 3:
                    System.out.println("Thank you for using Student Grade Tracker.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}