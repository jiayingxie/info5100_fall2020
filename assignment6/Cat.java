public class Cat extends Pet implements Boardable{
    private MyDate boardStart;
    private MyDate boardEnd;
    private String hairLength;

    public Cat(String name, String ownerName, String color, String hairLength) {
        super(name, ownerName, color);
        this.hairLength = hairLength;
    }

    public String getHairLength() {
        return hairLength;
    }

    @Override
    public String toString() {
        return "CAT:\n" + super.toString() + "Hair: "
                + this.getHairLength() + "\n";
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
    // return true if the given data is between the start
    // and end dates, otherwise it returns false
    public boolean boarding(int month, int day, int year) {
        // Note, the month will be in the range 1-12, day in the range 1-31,
        // and year will be a four digit number.
        MyDate curDate = new MyDate(month, day, year);
        // You should also return true if the given date is equal to the start or end date.
        return (boardStart.compareTo(curDate) <= 0) &&
                (boardEnd.compareTo(curDate) >= 0);
    }

    // simple unit test
    public static void main(String[] args) {
        Cat obj1 = new Cat("Tom", "Bob", "black", "short");
        obj1.setSex(2);
        System.out.println(obj1);

        // set BoardStart and BoardEnd
        obj1.setBoardStart(01, 01, 2020);
        obj1.setBoardEnd(10, 18, 2020);
        // judge whether the given date is between start and end
        // the start date, should be true
        System.out.println(obj1.boarding(1, 1, 2020));
        // the end date, should be true
        System.out.println(obj1.boarding(10, 18, 2020));
        // should be false
        System.out.println(obj1.boarding(10, 19, 2020));
        // should be false
        System.out.println(obj1.boarding(2, 28, 2021));
        // should be true
        System.out.println(obj1.boarding(2, 28, 2020));
/* unit test output
CAT:
Tom owned by Bob
Color: black
Sex: spayed
Hair: short

true
true
false
false
true
* */
    }
}
