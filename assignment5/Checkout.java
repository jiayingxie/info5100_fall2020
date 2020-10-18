import java.util.List;
import java.util.Vector;

public class Checkout {
    List<DessertItem> list;
    // Creates a Checkout instance with an empty list of DessertItem's
    public Checkout() {
        // The Checkout class must use a Vector to store the DessertItem's.
        list = new Vector<>();
    }

    // Returns the number of DessertItem's in the list
    public int numberOfItems() {
        return list.size();
    }

    // A DessertItem is added to the end of the list of items
    public void enterItem(DessertItem item) {
        list.add(item);
    }

    // Clears the Checkout to begin checking out a new set of items
    public void clear() {
        list.clear();
    }

    // Returns total cost of items in cents (without tax)
    public int totalCost() {
        int total = 0;
        for (DessertItem d: list) {
            total += d.getCost();
        }
        return total;
    }

    // Returns total tax on items in cents
    public int totalTax() {
        return (int) Math.round(totalCost() * DessertShoppe.TAX_RATE);
    }

    // Returns a String representing a receipt for the current
    // list of items
    @Override
    public java.lang.String toString() {
        // to put the store name in the middle
        int totalLength = DessertShoppe.MAXMIUM_SIZE + DessertShoppe.WIDTH;
        int storeNameLength = DessertShoppe.STORE_NAME.length();
        StringBuilder sb = new StringBuilder();
        int leftWidth = (totalLength - storeNameLength) / 2;
        for (int i = 0; i < leftWidth; ++i) {
            sb.append(" ");
        }
        sb.append(DessertShoppe.STORE_NAME + "\n");
        for (int i = 0; i < leftWidth; ++i) {
            sb.append(" ");
        }
        for (int i = 0; i < storeNameLength; ++i) {
            sb.append("-");
        }
        sb.append("\n");
        // each item
        for (DessertItem d: list) {
            sb.append(d);
            sb.append("\n");
        }
        sb.append("\n");
        // tax
        String tax = DessertShoppe.cents2dollarsAndCents(totalTax());
        sb.append(String.format("%-25s %6s\n", "Tax", tax));
        // tax + cost
        String totalCost = DessertShoppe.cents2dollarsAndCents(totalTax() + totalCost());
        sb.append(String.format("%-25s %6s\n", "Total", totalCost));
        return sb.toString();
    }
}
