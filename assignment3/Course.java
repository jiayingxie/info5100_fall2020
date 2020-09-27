import java.util.Arrays;

public class Course {
    // Each Course has a name
    private String name;
    /* variable numberOfStudent representing the number of registered students.*/
    private int numberOfStudent;
    // A course can have a maximum number of 10 students registered in it.
    private int maxNumberOfStudent = 10;
    /* Class Course store the registered students in students which is an array
        of type Student. When a student register in a course, he is added to
        the array. */
    private Student[] students = new Student[maxNumberOfStudent];

    // Each object of class Course is initialized using the title(name)
    public Course(String name) {
        this.name = name;
        // at first, a course has no registered student
        numberOfStudent = 0;
    }

    // method getStudents(): return the array of registered students;
    public Student[] getStudents() {
        Student[] registeredStudents = Arrays.copyOf(students, numberOfStudent);
        return registeredStudents;
    }

    // method boolean isFull(): return true if the course is full,
    public boolean isFull() {
        if (numberOfStudent == maxNumberOfStudent) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    // ??? whether a student will register twice?
    /* method registerStudent (Student student): if the course is not full,
        register a student in course*/
    public void registerStudent (Student student) {
        if (isFull()) {
            System.out.println("The course is full. You could register another course.");
        } else {
            students[numberOfStudent] = student;
            numberOfStudent += 1;
        }
    }
}
