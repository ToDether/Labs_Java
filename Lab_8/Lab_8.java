package Lab_8;

import java.util.*;

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


    public int getStudentId() {
        return studentId;
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
    private Set<Student> students;

    public Faculty(String name) {
        this.name = name;
        this.students = new HashSet<>();
    }

        public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Set<Student> getStudents() {
        return students;
    }

    // Пошук найкращого студента
    public Student getBestStudent() {
        TreeMap<Double, Student> sortedStudents = new TreeMap<>(Collections.reverseOrder());

        for (Student student : students) {
            sortedStudents.put(student.getAverageGrade(), student);
        }

        return sortedStudents.isEmpty() ? null : sortedStudents.firstEntry().getValue();
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
    private Set<Faculty> faculties;
    private Map<Integer, Student> studentIdMap;

    public Institute(String name) {
        this.name = name;
        this.faculties = new HashSet<>();
        this.studentIdMap = new HashMap<>();
    }

        public String getName() {
        return name;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);

        for (Student student : faculty.getStudents()) {
            studentIdMap.put(student.getStudentId(), student);
        }
    }

    public Set<Faculty> getFaculties() {
        return faculties;
    }

    public Student getStudentById(int studentId) {
        return studentIdMap.get(studentId);
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
    public Set<Student> getStudentsInRange(double minGrade, double maxGrade) {
        Set<Student> studentsInRange = new HashSet<>();

        for (Faculty faculty : faculties) {
            for (Student student : faculty.getStudents()) {
                if (student.getAverageGrade() >= minGrade && student.getAverageGrade() <= maxGrade) {
                    studentsInRange.add(student);
                }
            }
        }

        return studentsInRange;
    }

    //Пошук найкращого студента на кожному факультеті
    public Map<Faculty, Student> getBestStudentsInFaculties() {
        Map<Faculty, Student> bestStudentsMap = new HashMap<>();

        for (Faculty faculty : faculties) {
            Student bestStudent = faculty.getBestStudent();
            if (bestStudent != null) {
                bestStudentsMap.put(faculty, bestStudent);
            }
        }

        return bestStudentsMap;
    }
}

public class Lab_8 {
    public static void main(String[] args) {

        Institute institute = new Institute("My Institute");

        Faculty faculty1 = new Faculty("Faculty of Science");
        Faculty faculty2 = new Faculty("Faculty of Arts");

        faculty1.addStudent(new Student("John", "Doe", 1, 98.5));
        faculty1.addStudent(new Student("Jane", "Smith", 2, 92.0));

        faculty2.addStudent(new Student("Bob", "Johnson", 4, 96.7));
        faculty2.addStudent(new Student("Alice", "Williams", 5, 88.2));
        faculty2.addStudent(new Student("Eva", "Davis", 6, 97.5));


        institute.addFaculty(faculty1);
        institute.addFaculty(faculty2);

        System.out.println("Total number of students in the institute: " + institute.getTotalStudentsCount());

        Faculty largestFaculty = institute.getLargestFaculty();
        System.out.println("Faculty with the largest number of students: " + largestFaculty.getName());

        Set<Student> studentsInRange = institute.getStudentsInRange(95.0, 100.0);
        System.out.println("Students with average grade in the range 95..100: " + studentsInRange);

        Map<Faculty, Student> bestStudentsMap = institute.getBestStudentsInFaculties();
        System.out.println("\nBest students in each faculty:");
        for (Map.Entry<Faculty, Student> entry : bestStudentsMap.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue());
        }
    }
}
