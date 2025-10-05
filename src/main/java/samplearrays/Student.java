package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class Student {
    private final int id;
    private final String name;
    private int age;
    private int grade;

    
    private static int numStudent = 0;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        numStudent++;
    }

    public Student(int id, String name, int age) {
        this(id, name);
        this.age = age;
    }

    public Student(int id, String name, int age, int grade) {
        this(id, name, age);
        this.grade = grade;
    }

    // Getters & setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getGrade() { return grade; }
    public void setAge(int age) { this.age = age; }
    public void setGrade(int grade) { this.grade = grade; }
    public static int getNumStudent() { return numStudent; }
    public boolean isAdult() { return age >= 18; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + ", grade=" + grade + "}";
    }

    // ---- Utility methods below ----
    public static double averageGrade(Student[] arr) {
        if (arr.length == 0) return Double.NaN;
        int sum = 0;
        for (Student s : arr) sum += s.getGrade();
        return sum / (double) arr.length;
    }

    public static int countAdults(Student[] arr) {
        int c = 0;
        for (Student s : arr) if (s.isAdult()) c++;
        return c;
    }

    public static Student[] sortByGradeDesc(Student[] arr) {
        Student[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy, Comparator.comparingInt(Student::getGrade).reversed()
                .thenComparing(Student::getName));
        return copy;
    }

    public static Student topStudent(Student[] arr) {
        if (arr.length == 0) return null;
        Student best = arr[0];
        for (int i = 1; i < arr.length; i++) {
            Student s = arr[i];
            if (s.getGrade() > best.getGrade() ||
                    (s.getGrade() == best.getGrade() && s.getName().compareTo(best.getName()) < 0)) {
                best = s;
            }
        }
        return best;
    }

    public static void printAll(Student[] arr) {
        for (Student s : arr) System.out.println(s);
    }

    // ---- main() for testing ----
    public static void main(String[] args) {
        Student[] students = new Student[4];
        students[0] = new Student(1, "Soufiane", 21, 19);
        students[1] = new Student(2, "Houssam", 21, 19);
        students[2] = new Student(3, "Marouane", 21, 18);
        students[3] = new Student(4, "Achraf", 20, 17);

        System.out.println("All students:");
        printAll(students);

        System.out.println("\nAverage grade: " + averageGrade(students));
        System.out.println("Number of adults: " + countAdults(students));

        System.out.println("\nSorted by grade (desc) and name:");
        printAll(sortByGradeDesc(students));

        System.out.println("\nTop student:");
        System.out.println(topStudent(students));
    }
}
