import java.util.*;

public class StudentGradeTracker {
    static class Student {
        String name;
        ArrayList<Integer> grades;

        Student(String name) {
            this.name = name;
            grades = new ArrayList<>();
        }

        void addGrade(int grade) {
            grades.add(grade);
        }

        double getAverage() {
            return grades.stream().mapToInt(Integer::intValue).average().orElse(0);
        }

        int getHighest() {
            return Collections.max(grades);
        }

        int getLowest() {
            return Collections.min(grades);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();
            Student student = new Student(name);

            System.out.print("Enter number of subjects: ");
            int m = sc.nextInt();
            for (int j = 0; j < m; j++) {
                System.out.print("Enter grade for subject " + (j + 1) + ": ");
                int grade = sc.nextInt();
                student.addGrade(grade);
            }
            students.add(student);
        }

        System.out.println("\n--- Student Grade Summary ---");
        for (Student s : students) {
            System.out.println("Name: " + s.name);
            System.out.println("Grades: " + s.grades);
            System.out.println("Average: " + s.getAverage());
            System.out.println("Highest: " + s.getHighest());
            System.out.println("Lowest: " + s.getLowest());
            System.out.println();
        }

        sc.close();
    }
}
