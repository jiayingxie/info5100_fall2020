public class DessertShoppe {
    public static final double TAX_RATE = 0.065;
    public static final String STORE_NAME = "M & M Dessert Shoppe";
    public static final int MAXMIUM_SIZE = 25;
    public static final int WIDTH = 6;

    public static String cents2dollarsAndCents(int cents) {
        String s = " ";
        int dollars = cents / 100;
        cents = cents % 100;

        if (dollars > 0) {
            s += dollars;
        }

        s += ".";

        if (cents < 10)
            s += "0";

        s += cents;

        return s;
    }
}
