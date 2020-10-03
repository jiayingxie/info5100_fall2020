public class Cylinder extends Circle{
    private double height = 1.0;

    // constructors
    public Cylinder() {
        super();
    }
    public Cylinder(double height) {
        super();
        this.height = height;
    }

    public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // return the volume of this Cylinder. Please use
    // Circle's getArea() method
    public double getVolume() {
        // The volume of the Cylinder: πr^2h
        return super.getArea() * this.height;
    }

    @Override
    public double getArea() {
        // The area of the Cylinder: 2πr(r+h)
        return 2 * Math.PI * this.getRadius()
                * (this.getRadius() + this.height);
    }

    @Override
    public String toString() {
        return "Radius is " + this.getRadius()
                + ", Height is " + this.height
                + ", Color is " + this.getColor()
                + ", Base area is " + this.getArea()
                + ", Volume is " + this.getVolume();
    }
}
