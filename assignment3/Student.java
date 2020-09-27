public class Student {
    //Each student has a name and an id variable
    private String name;
    private int id;

    /* Each object of class Student is initialized using values of
        name and id passed to constructor.*/
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /* Class Student has get methods for its instance variables.
        (getters and setters)*/
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name;
    }
}
