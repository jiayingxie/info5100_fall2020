public class TestCheckOut {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();
        checkout.enterItem(new Candy("Peanut Butter Fudge", 2.25, 399));
        checkout.enterItem(new IceCream("Vanilla Ice Cream", 105));
        checkout.enterItem(new Sundae("Choc. Chip Ice Cream", 145, "Hot Fudge", 50));
                checkout.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));
        System.out.println("\nNumber of items: " + checkout.numberOfItems()
                + "\n");
        System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
        System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
        System.out.println("\nCost + Tax: " + (checkout.totalCost() +
                checkout.totalTax()) + "\n");
        System.out.println(checkout);
        checkout.clear();
        checkout.enterItem(new IceCream("Strawberry Ice Cream", 145));
        checkout.enterItem(new Sundae("Vanilla Ice Cream", 105, "Caramel",
                50));
        checkout.enterItem(new Candy("Gummy Worms", 1.33, 89));
        checkout.enterItem(new Cookie("Chocolate Chip Cookies", 4, 399));
        checkout.enterItem(new Candy("Salt Water Taffy", 1.5, 209));
        checkout.enterItem(new Candy("Candy Corn", 3.0, 109));
        System.out.println("\nNumber of items: " + checkout.numberOfItems()
                + "\n");
        System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
        System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
        System.out.println("\nCost + Tax: " + (checkout.totalCost() +
                checkout.totalTax()) + "\n");
        System.out.println(checkout);
    }
}
/*
* console output:

Number of items: 4


Total cost: 1331


Total tax: 87


Cost + Tax: 1418

     M & M Dessert Shoppe
     --------------------
2.25 lbs. @ 3.99 /lb.
Peanut Butter Fudge        8.98
Vanilla Ice Cream          1.05
Hot FudgeSundae with
Choc. Chip Ice Cream       1.95
4 @ 3.99 /dz.
Oatmeal Raisin Cookies     1.33

Tax                        0.87
Total                     14.18


Number of items: 6


Total cost: 1192


Total tax: 77


Cost + Tax: 1269

     M & M Dessert Shoppe
     --------------------
Strawberry Ice Cream       1.45
CaramelSundae with
Vanilla Ice Cream          1.55
1.33 lbs. @ 0.89 /lb.
Gummy Worms                1.18
4 @ 3.99 /dz.
Chocolate Chip Cookies     1.33
1.5 lbs. @ 2.09 /lb.
Salt Water Taffy           3.14
3.0 lbs. @ 1.09 /lb.
Candy Corn                 3.27

Tax                        0.77
Total                     12.69


* */