import com.management.students.Student;
import com.management.students.StudentComparator;
import org.ietf.jgss.GSSName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    private static ArrayList<Student> students = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println(students[0]);
        boolean shouldRun = true;
        while (shouldRun) {
            System.out.println("Enter a command (add, search , sort, view, exit) :");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    addStudent(scanner);
                    break;
                case "search":
                    searchStudent(scanner);
                    break;
                case "sort":
                    sortStudent(scanner);
                    break;
                case "view":
                    viewStudent();
                    break;
                case "exit":
                    shouldRun = false;
                    break;
                default:
                    System.out.println("Invalid Command");
                    break;
            }
        }
    }


    private static void addStudent(Scanner scanner) {


        System.out.println("Enter the student name: ");
        String name = scanner.nextLine();

        System.out.println("Enter the student ID: ");
        int ID = scanner.nextInt();

        System.out.println("Enter the student age: ");
        int age = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Enter the student email: ");
        String email = scanner.nextLine();

        while (!isValidEmail(email)) {
            System.out.println("Wrong email : ");
            email = scanner.nextLine();
        }

        System.out.println("Enter the student GPA: ");
        double GPA = scanner.nextDouble();

        scanner.nextLine();

        Student newStudent = new Student(name, email, ID, age, GPA);
        students.add(newStudent);

        System.out.println("Student added successfully");

    }

    private static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    private static void searchStudent(Scanner scanner) {
        System.out.println("Enter the student name: ");
        String name = scanner.nextLine();

        for (Student student : students) {
            if (student.getName().equals(name)) {
                System.out.println(student);
            }
        }
    }

    private static void sortStudent(Scanner scanner) {
        System.out.println("Enter a field to sort by (name,ID,email,age or GPA)");
        String field = scanner.nextLine();

        Collections.sort(students, new StudentComparator(field));

        for (Student student : students) {
            System.out.println(student);
        }
    }

    // display all students
    private static void viewStudent() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}