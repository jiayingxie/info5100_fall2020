public class Sundae extends IceCream{
    private String toppingName;
    private double toppingCost;


    public Sundae(String name, double cost, String toppingName, double toppingCost) {
        super(name, cost);
        this.toppingName = toppingName;
        this.toppingCost = toppingCost;
    }

    @Override
    public int getCost() {
        return (int) (super.getCost() + toppingCost);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(toppingName
                + "Sundae with\n");
        sb.append(String.format("%-25.25s %5.2f", super.name, DessertShoppe.cents2dollarsAndCents(getCost())));
        return sb.toString();
    }
}
