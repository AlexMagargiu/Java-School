import java.util.List;
import java.util.Scanner;

class Student {
    private int studentID;
    private String studentName;
    private int grade;

    public Student() {
        System.out.println("Student values are null");
    }

    public Student(int studentID, String studentName, int grade) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.grade = grade;
    }

    public static String validateStudentName(Scanner scanner) {
        String name;
        while (true) {
            try {
                name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    System.out.print("Name cannot be empty! Please enter a name: ");
                    continue;
                }
                if (name.matches(".*\\d.*")) {
                    throw new IllegalArgumentException();
                }
                return name;
            } catch (IllegalArgumentException e) {
                System.out.print("Invalid name! Please enter a string without numbers: ");
            }
        }
    }

    public static int validateGrade(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.print("Grade cannot be empty! Please enter a number between 1 and 10: ");
                    continue;
                }
                int grade = Integer.parseInt(input);
                if (grade >= 1 && grade <= 10) {
                    return grade;
                } else {
                    System.out.print("Grade must be between 1 and 10! Please enter again: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid grade! Please enter a number between 1 and 10: ");
            }
        }
    }

    public static void addStudent(List<Student> students, Student student) {
        students.add(student);
    }

    public static void removeStudent(List<Student> students, int position) {
        if (position >= 0 && position < students.size()) {
            students.remove(position);
        } else {
            System.out.println("Invalid position! Please enter a position between 0 and " + (students.size() - 1));
        }
    }

    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                ", grade=" + grade +
                '}';
    }
}