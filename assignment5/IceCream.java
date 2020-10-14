public class IceCream extends DessertItem{
    private double cost;

    public IceCream(String name, double cost) {
        super(name);
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return (int) cost;
    }

    @Override
    public String toString() {
        return String.format("%-25.25s %5.2f", name, DessertShoppe.cents2dollarsAndCents(getCost()));
    }
}
