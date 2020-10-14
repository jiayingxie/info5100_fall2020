public class Cookie extends DessertItem{
    // ??? 4 cookies @ 399 cents /dz. = 133 cents
    private int number;
    private double pricePerDozen;

    public Cookie() {
    }

    public Cookie(String name) {
        super(name);
    }

    public Cookie(int number, double pricePerDozen) {
        this.number = number;
        this.pricePerDozen = pricePerDozen;
    }

    public Cookie(String name, int number, double pricePerDozen) {
        super(name);
        this.number = number;
        this.pricePerDozen = pricePerDozen;
    }

    @Override
    public int getCost() {
        return (int) Math.round(number * pricePerDozen / 12);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        sb.append(" @ ");
        sb.append(DessertShoppe.cents2dollarsAndCents((int) pricePerDozen));
        sb.append(" /dz.\n");
        sb.append(String.format("%-25.25s %5.2f", name, DessertShoppe.cents2dollarsAndCents(getCost())));
        return sb.toString();
    }
}
