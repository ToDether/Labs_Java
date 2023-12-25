package Lab_7;

import java.util.ArrayList;
import java.util.List;

class Student {
    private String firstName;
    private String lastName;
    private int studentId;
    private double averageGrade;

    public Student(String firstName, String lastName, int studentId, double averageGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.averageGrade = averageGrade;
    }


    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentId=" + studentId +
                ", averageGrade=" + averageGrade +
                '}';
    }
}

class Faculty {
    private String name;
    private List<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }


    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}

class Institute {
    private String name;
    private List<Faculty> faculties;

    public Institute(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }


    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    @Override
    public String toString() {
        return "Institute{" +
                "name='" + name + '\'' +
                ", faculties=" + faculties +
                '}';
    }

    // Загальна кількість студентів в інституті
    public int getTotalStudentsCount() {
        int totalStudents = 0;

        for (Faculty faculty : faculties) {
            totalStudents += faculty.getStudents().size();
        }

        return totalStudents;
    }

    // Факультет з найбільшою кількістю студентів
    public Faculty getLargestFaculty() {
        Faculty largestFaculty = null;
        int maxStudentCount = 0;

        for (Faculty faculty : faculties) {
            if (faculty.getStudents().size() > maxStudentCount) {
                maxStudentCount = faculty.getStudents().size();
                largestFaculty = faculty;
            }
        }

        return largestFaculty;
    }

    // Список студентів із середнім балом в діапазоні 95..100
    public List<Student> getStudentsInRange(double minGrade, double maxGrade) {
        List<Student> studentsInRange = new ArrayList<>();

        for (Faculty faculty : faculties) {
            for (Student student : faculty.getStudents()) {
                if (student.getAverageGrade() >= minGrade && student.getAverageGrade() <= maxGrade) {
                    studentsInRange.add(student);
                }
            }
        }

        return studentsInRange;
    }
}

public class Lab_7 {
    public static void main(String[] args) {

        Institute institute = new Institute("My Institute");

        Faculty faculty1 = new Faculty("Faculty of Science");
        Faculty faculty2 = new Faculty("Faculty of Arts");


        faculty1.addStudent(new Student("John", "Doe", 1, 98.5));
        faculty1.addStudent(new Student("Jane", "Smith", 2, 92.0));

        faculty2.addStudent(new Student("Bob", "Johnson", 3, 96.7));
        faculty2.addStudent(new Student("Alice", "Williams", 4, 88.2));
        faculty2.addStudent(new Student("Mike", "Garrison", 5, 80.1));


        institute.addFaculty(faculty1);
        institute.addFaculty(faculty2);

        System.out.println("Total number of students in the institute: " + institute.getTotalStudentsCount());

        Faculty largestFaculty = institute.getLargestFaculty();

        System.out.println("Faculty with the largest number of students: " + largestFaculty);

        List<Student> studentsInRange = institute.getStudentsInRange(95.0, 100.0);
        System.out.println("Students with average grade in the range 95..100: " + studentsInRange);
    }
}
