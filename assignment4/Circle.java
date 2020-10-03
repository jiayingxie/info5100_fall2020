public class Circle {
    private double radius = 1.0;
    private String color = "red";

    // constructors
    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // return the area of this Circle
    public double getArea() {
        // The area of the Circle: πr^2
        return Math.PI * this.radius * this.radius;
    }

    @Override
    public String toString() {
        return "Radius is " + this.radius
                + ", Color is " + this.color
                +", Base area is " + this.getArea();
    }
}
