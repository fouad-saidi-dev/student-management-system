import com.management.students.Student;
import org.ietf.jgss.GSSName;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static int MAX_NUMBER_OF_STUDENTS = 100;
    private static Student[] students = new Student[MAX_NUMBER_OF_STUDENTS];
    private static int studentsNumber = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean shouldRun = true;
        while (true) {
            System.out.println("Enter a command (add, search , sort, view, exit) :");
            String command = scanner.nextLine();

            switch (command) {
                case "add" :
                    addStudent(scanner);
                    break;
                case "search" :
                    searchStudent(scanner);
                    break;
                case "exit" :
                    shouldRun = false;
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

        System.out.println("Enter the student email: ");
        String email = scanner.nextLine();

        while (!isVAlidEmail(email)) {
            System.out.println("Enter the student email: ");
            email = scanner.nextLine();
        }

        System.out.println("Enter the student GPA: ");
        double GPA = scanner.nextDouble();

        scanner.nextLine();

        Student newStudent = new Student(name,email,ID,age,GPA);
        students[studentsNumber] = newStudent;
        studentsNumber++;

        System.out.println("Student added successfully");


    }

    private static boolean isVAlidEmail(String email) {
       String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    private static void searchStudent(Scanner scanner) {
        System.out.println("Enter the student name: ");
        String name = scanner.nextLine();

        for (int i = 0; i<studentsNumber;i++) {
            if (students[i].getName().equals(name)) {
                System.out.println(students[i]);
            }
        }
    }
}