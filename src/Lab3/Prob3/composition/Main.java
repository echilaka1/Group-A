package Lab3.Prob3.composition;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println("Circle Area: " + circle.computeArea());

        Cylinder cylinder = new Cylinder(5, 10);
        System.out.println("Cylinder Volume: " + cylinder.computeVolume());
    }
}