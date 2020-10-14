public abstract class DessertItem {
    protected String name;

    // Null constructor for DessertItem class
    public DessertItem() {
    }

    // Initializes DessertItem data
    public DessertItem(String name) {
        this.name = name;
    }

    // Returns name of DessertItem
    public final String getName() {
        return name;
    }

    // Returns cost of DessertItem
    public abstract int getCost();
}
