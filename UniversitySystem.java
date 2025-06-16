import java.util.*;

public class UniversitySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EnrollmentManager enrollmentManager = new EnrollmentManager();
        GradeManager gradeManager = new GradeManager();
        LibraryNotifier notifier = new LibraryNotifier();

        System.out.print("How many students to enroll? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter student ID: ");
            String id = sc.nextLine();
            System.out.print("Enter course name: ");
            String courseName = sc.nextLine();

            Student s = new Student(id, name);
            Course c = new Course(courseName);
            enrollmentManager.enrollStudent(s, c);
        }

        enrollmentManager.showEnrollments();

        System.out.print("\nHow many grades to enter? ");
        int g = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < g; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter grade: ");
            String grade = sc.nextLine();

            Student s = new Student("", name);
            gradeManager.addGrade(s, grade);
        }

        gradeManager.showGrades();

        System.out.print("\nHow many overdue students? ");
        int o = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < o; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            Student s = new Student("", name);
            notifier.addOverdue(s);
        }

        notifier.notifyAllStudents();

        sc.close();
    }
}

// Student class
class Student {
    String id;
    String name;

    Student(String i, String n) {
        id = i;
        name = n;
    }

    public String toString() {
        return name + (id.equals("") ? "" : " (" + id + ")");
    }
}

// Course class
class Course {
    String name;

    Course(String n) {
        name = n;
    }

    public String toString() {
        return name;
    }
}

// Enrollment Manager class
class EnrollmentManager {
    ArrayList<String> enrollments = new ArrayList<>();

    void enrollStudent(Student s, Course c) {
        enrollments.add(s.toString() + " -> " + c.toString());
    }

    void showEnrollments() {
        System.out.println("\n--- Enrollments ---");
        for (String e : enrollments) {
            System.out.println(e);
        }
    }
}

// Grade Manager class
class GradeManager {
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<String> grades = new ArrayList<>();

    void addGrade(Student s, String g) {
        students.add(s);
        grades.add(g);
    }

    void showGrades() {
        System.out.println("\n--- Grades ---");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i) + ": " + grades.get(i));
        }
    }
}

// LibraryNotifier class
class LibraryNotifier {
    Queue<Student> overdue = new LinkedList<>();

    void addOverdue(Student s) {
        overdue.add(s);
    }

    void notifyAllStudents() {
        System.out.println("\n--- Overdue Notifications ---");
        while (!overdue.isEmpty()) {
            System.out.println("Notify: " + overdue.poll());
        }
    }
}
