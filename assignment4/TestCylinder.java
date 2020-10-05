public class TestCylinder {
    public static void main(String[] args) {

        //Constructed a Circle with Circle()
        Circle circle1 = new Circle();
        //Run of the program should produce the following output:
        //Radius is 2.0, Color is yellow, Base area is (your answer)
        circle1.setRadius(2.0);
        circle1.setColor("yellow");
        // ??? do we need to set the precision
        System.out.println(circle1);

        //Constructed a Cylinder with Cylinder()
        Cylinder cylinder1 = new Cylinder();
        //Run of the program should produce the following output:
        //Radius is 1.0, Height is 1.0, Color is red, Base area is (your answer), Volume is (your answer)
// the parameters are all default values
//        cylinder1.setRadius(1.0);
//        cylinder1.setHeight(1.0);
//        cylinder1.setColor("red");
        System.out.println(cylinder1);

        //Constructed a Cylinder with Cylinder(height, radius)
        Cylinder cylinder2 = new Cylinder(5.0, 2.0);
        //Run of the program should produce the following output:
        //Radius is 2.0, Height is 5.0, Color is red, Base area is (your answer), Volume is (your answer)
        System.out.println(cylinder2);
    }
}
/*
* console output:
Radius is 2.0, Color is yellow, Base area is 12.566370614359172
Radius is 1.0, Height is 1.0, Color is red, Base area is 12.566370614359172, Volume is 3.141592653589793
Radius is 2.0, Height is 5.0, Color is red, Base area is 87.96459430051421, Volume is 62.83185307179586

Process finished with exit code 0

* */