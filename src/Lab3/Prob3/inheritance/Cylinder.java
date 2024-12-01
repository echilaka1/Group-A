package Lab3.Prob3.inheritance;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double radius, double height) {
        super(radius); // Call the constructor of Circle
        this.height = height;
    }

    public double computeVolume() {
        return computeArea() * height; // Volume = Base Area * Height
    }
}