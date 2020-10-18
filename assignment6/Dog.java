public class Dog extends Pet implements Boardable{
    private MyDate boardStart;
    private MyDate boardEnd;
    private String size;

    public Dog(String name, String ownerName, String color, String size) {
        super(name, ownerName, color);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "DOG:\n" + super.toString() + "Size: "
                + this.getSize() + "\n";
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        boardStart = new MyDate(month, day, year);
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        boardEnd = new MyDate(month, day, year);
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        MyDate curDate = new MyDate(month, day, year);
        return (boardStart.compareTo(curDate) <= 0) &&
                (boardEnd.compareTo(curDate) >= 0);
    }

    // simple unit test
    public static void main(String[] args) {
        Dog obj1 = new Dog("Spot", "Susan", "white", "medium");
        obj1.setSex(2);
        System.out.println(obj1);

        // set BoardStart and BoardEnd
        obj1.setBoardStart(2, 29, 2020);
        obj1.setBoardEnd(1, 19, 2021);
        // judge whether the given date is between start and end
        // the start date, should be true
        System.out.println(obj1.boarding(2, 29, 2020));
        // the end date, should be true
        System.out.println(obj1.boarding(1, 19, 2021));
        // should be true
        System.out.println(obj1.boarding(12, 31, 2020));
        // should be false
        System.out.println(obj1.boarding(2, 28, 2021));
/*
* unit test output
DOG:
Spot owned by Susan
Color: white
Sex: spayed
Size: medium

true
true
true
false
* */
    }
}
