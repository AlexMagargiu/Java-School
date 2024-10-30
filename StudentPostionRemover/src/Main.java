import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<Student> studentList = new ArrayList<>();

        Student emptyStudent = new Student();

        for (int i = 0; i < 10; i++) {
            System.out.println(" ");
            System.out.println("Entering details for student " + (i + 1));

            int studentID = random.nextInt(10000);

            System.out.print("Enter student name: ");
            String studentName = Student.validateStudentName(scanner);

            System.out.print("Enter grade (1-10): ");
            int grade = Student.validateGrade(scanner);

            Student student = new Student(studentID, studentName, grade);
            Student.addStudent(studentList, student);
        }

        System.out.println("Current list of students:");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i + 1) + ": " + studentList.get(i));
        }

        System.out.print("Enter the position of the student to remove (1-" + studentList.size() + "): ");
        int position = Student.validateGrade(scanner);
        Student.removeStudent(studentList, position - 1);

        System.out.println("Updated list of students:");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i + 1) + ": " + studentList.get(i));
        }

        scanner.close();
    }
}