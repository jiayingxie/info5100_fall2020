import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        // the demo of registering course
        System.out.println("Here is the demo of registering course.");
        Student Allan = new Student("Allan", 10001);
        Student Bob = new Student("Bob", 10002);
        Student Chen = new Student("Chen", 10003);
        Student Dong = new Student("Dong", 10004);
        Student Emma = new Student("Emma", 10005);
        Student Feng = new Student("Feng", 10006);
        Student Guo = new Student("Guo", 10007);
        Student Harry = new Student("Harry", 10008);
        Student Ivy = new Student("Ivy", 10009);
        Student John = new Student("John", 10010);
        Student Kelly = new Student("Kelly", 10011);

        Course info5100 = new Course("info5100");
        info5100.registerStudent(Allan);
        info5100.registerStudent(Bob);
        info5100.registerStudent(Chen);
        info5100.registerStudent(Dong);
        // 4 students register the course
        System.out.println(info5100.getNumberOfStudent() + " students register the course.");
//        System.out.println(info5100.getNumberOfStudent() + " students register the course "
//            + info5100.getName() + ", and they are:");
//        for (Student stu: info5100.getStudents()) {
//            System.out.println(stu);
//        }
        System.out.println("The course is full: " + info5100.isFull());

        info5100.registerStudent(Emma);
        info5100.registerStudent(Feng);
        info5100.registerStudent(Guo);
        info5100.registerStudent(Harry);
        info5100.registerStudent(Ivy);
        // 9 students register the course
        System.out.println("\n" + info5100.getNumberOfStudent() + " students register the course.");
//        System.out.println("\n" + info5100.getNumberOfStudent() + " students register the course "
//                + info5100.getName() + ", and they are:");
//        for (Student stu: info5100.getStudents()) {
//            System.out.println(stu);
//        }
        System.out.println("The course is full: " + info5100.isFull());

        info5100.registerStudent(John);
        // 10 students register the course
        System.out.println("\n" + info5100.getNumberOfStudent() + " students register the course "
                + info5100.getName() + ", and they are:");
        for (Student stu: info5100.getStudents()) {
            System.out.println(stu);
        }
        System.out.println("The course is full: " + info5100.isFull());

        // The 11th student is trying to register the course.
        System.out.println("\nThe 11th student is trying to register the course:");
        info5100.registerStudent(Kelly);


        // the demo of using builder pattern
        System.out.println("\nHere is the demo of using builder pattern:");
        Professor pro = new Professor.Builder("Allan", "Adam", 1)
                .Build();
        System.out.println(pro);
        Professor pro2 = new Professor.Builder("Bob", "Byron", 2)
                .setAge(30).Build();
        System.out.println(pro2);
        Professor pro3 = new Professor.Builder("Cecilia", "Chris", 3)
                .setAge(50).setPhone("1234567")
                .setEmail("abc@gmail.com")
                .setAddress("Lake south union, Seattle")
                .Build();
        System.out.println(pro3);
    }
}
/* console output:
Here is the demo of registering course.
4 students register the course.
The course is full: false

9 students register the course.
The course is full: false

10 students register the course info5100, and they are:
Id: 10001, Name: Allan
Id: 10002, Name: Bob
Id: 10003, Name: Chen
Id: 10004, Name: Dong
Id: 10005, Name: Emma
Id: 10006, Name: Feng
Id: 10007, Name: Guo
Id: 10008, Name: Harry
Id: 10009, Name: Ivy
Id: 10010, Name: John
The course is full: true

The 11th student is trying to register the course:
The course is full. You could register another course.

Here is the demo of using builder pattern:
Id:1, Name:Allan Adam
Id:2, Name:Bob Byron, Age:30
Id:3, Name:Cecilia Chris, Age:50, Phone:1234567, Email:abc@gmail.com, Address:Lake south union, Seattle

Process finished with exit code 0
*/