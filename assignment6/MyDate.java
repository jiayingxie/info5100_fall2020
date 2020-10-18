public class MyDate implements Comparable<MyDate> {
    private int day;
    private int month;
    private int year;

    public MyDate(int month, int day, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public int compareTo(MyDate o) {
        // compare year
        if (year < o.year) return -1;
        else if (year > o.year) return 1;
        else {
            // compare month
            if (month < o.month) return -1;
            else if (month > o.month) return 1;
            else {
                // compare day
                if (day < o.day) return -1;
                else if (day > o.day) return 1;
                else return 0;
            }
        }
    }

    // simple unit test
    public static void main(String[] args) {
        MyDate obj1 = new MyDate(1, 20, 2020);
        MyDate obj2 = new MyDate(1, 20, 2019);
        System.out.println(obj1.compareTo(obj2));
    }
/*
* unit test output
1
* */
}
