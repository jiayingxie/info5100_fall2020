public class Pet {
    // four public static final int values, ??? would it
    // be better to use enum?
    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final int SPAYED = 2;
    public static final int NEUTERED = 3;

    private String petName;
    private String ownerName;
    private String color;
    protected int sex;

    // constructor
    public Pet(String name, String ownerName, String color) {
        this.petName = name;
        this.ownerName = ownerName;
        this.color = color;
    }

    public String getPetName() {
        return petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getColor() {
        return color;
    }

    public void setSex(int sexid) {
        this.sex = sexid;
    }

    public String getSex() {
        String s = null;
        switch (this.sex) {
            case 0:
                s = "male";
                break;
            case 1:
                s = "female";
                break;
            case 2:
                s = "spayed";
                break;
            case 3:
                s = "neutered";
                break;
        }
        return s;
    }

    @Override
    public String toString() {
        return this.petName + " owned by " + this.ownerName
                + "\nColor: " + this.color + "\nSex: " + getSex() + "\n";
    }

    // unit test
    public static void main(String[] args) {
        Pet obj = new Pet("Spot", "Mary", "Black and White");
        obj.setSex(0);
        System.out.println(obj);
/*
* output
Spot owned by Mary
Color: Black and White
Sex: male
* */
    }
}
