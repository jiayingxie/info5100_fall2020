public class IceCream extends DessertItem{
    private double cost;

    public IceCream() {
    }

    public IceCream(String name) {
        super(name);
    }

    public IceCream(double cost) {
        this.cost = cost;
    }

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
        return String.format("%-25.25s %6s", name, DessertShoppe.cents2dollarsAndCents(getCost()));
    }
}
