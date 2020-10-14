public class Candy extends DessertItem{
    // ??? 2.30 lbs.of fudge @ .89 /lb. = 205 cents?
    private double weight;
    private double pricePerPound;

    public Candy(String name, double weight, double pricePerPound) {
        super(name);
        this.weight = weight;
        this.pricePerPound = pricePerPound;
    }

    @Override
    public int getCost() {
        return (int) Math.round(weight * pricePerPound);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(weight);
        sb.append(" lbs. @ ");
        sb.append(DessertShoppe.cents2dollarsAndCents((int) pricePerPound));
        sb.append(" /lb.\n");
        sb.append(String.format("%-25.25s %5.2f", name, DessertShoppe.cents2dollarsAndCents(getCost())));
        return sb.toString();
    }
}
