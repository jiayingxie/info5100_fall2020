import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class Mreview implements Comparable<Mreview>{
    // instance variables
    private String title;   // title of the movie
    private ArrayList<Integer> ratings; // list of ratings stored in a Store object

    // constructors
    // Sets title to "" and creates an empty ArrayList to ratings.
    public Mreview() {
        this.title = "";
        this.ratings = new ArrayList<>();
    }

    // Sets title to the parameter string and creates an empty
    // ArrayList to ratings.
    public Mreview(String title) {
        this.title = title;
        this.ratings = new ArrayList<>();
    }

    // Sets title to the parameter string and creates a ratings
    // list whose size() is one, having the parameter int as the
    // (only/first) element.
    public Mreview(String title, int firstRating) {
        this.title = title;
        this.ratings = new ArrayList<>();
        this.ratings.add(firstRating);
    }

    // methods
    // Returns the title string.
    public String getTitle() {
        return this.title;
    }

    // Inserts the parameter rating in the ratings list.
    public void addRating(int r) {
        this.ratings.add(r);
    }

    // Returns the average of the ratings stored in the rating list.
    public double aveRating() {
        // if there is no rating, we just return 0
        if (this.ratings.size() == 0) return 0;
        int sum = this.ratings.stream().mapToInt(Integer::intValue).sum();
        return sum * 1.0 / this.ratings.size();

//        // use average() in stream to get the result,
//        // pay attention!!! since the return is OptionalDouble,
//        // we need to define an OptionalDouble object.
//        OptionalDouble ave = this.ratings.stream().mapToDouble(Integer::doubleValue).average();
//        return ave.getAsDouble();
    }

    // Returns the size (not capacity) of the rating list.
    public int numRatings() {
        return this.ratings.size();
    }

    @Override
    public int compareTo(Mreview obj) {
        // Returns a negative number if this title is before the
        // title of the parameter object, or a positive number if
        // this title is after the title of the parameter object,
        // or 0 otherwise.
        return this.title.compareTo(obj.title);
    }

    @Override
    public boolean equals(Object obj) {
        // Returns true if two title String's are equal, or false otherwise.
        Mreview parameterObj = (Mreview) obj;
        return this.title.equals(parameterObj.title);
    }

    @Override
    public String toString() {
        // Returns a string of the form "XXX, average YYY out of
        // ZZZ ratings" where XXX is the title, YYY is the average
        // ratings and ZZZ is the number of ratings.
        return this.title + ", average " + this.aveRating()
                + " out of " + this.numRatings() + " ratings";
    }

    public static void main(String[] args) {
        Mreview obj1 = new Mreview("test", 1);
        obj1.addRating(2);
        obj1.addRating(3);

        Mreview obj2 = new Mreview("apple");

        Mreview obj3 = new Mreview("Test", 2);
        obj3.addRating(0);
        obj3.addRating(10);

        Mreview obj4 = new Mreview();

        // simple unit test
        List<Mreview> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        list.add(obj4);
        for (Mreview m: list) {
            System.out.println("Movie: " + m + ", and its average rating is "
                    + m.aveRating());
        }
/*
* unit test output
Movie: test, average 2.0 out of 3 ratings, and its average rating is 2.0
Movie: apple, average 0.0 out of 0 ratings, and its average rating is 0.0
Movie: Test, average 4.0 out of 3 ratings, and its average rating is 4.0
Movie: , average 0.0 out of 0 ratings, and its average rating is 0.0
* */
    }
}
