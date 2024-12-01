package Lab3.Prob3.composition;

public class Cylinder {
    private Circle base;
    private double height;

    public Cylinder(double radius, double height) {
        this.base = new Circle(radius); // Composition
        this.height = height;
    }

    public double computeVolume() {
        return base.computeArea() * height; // Volume = Base Area * Height
    }

    public double getRadius() {
        return base.getRadius();
    }

    public double getHeight() {
        return height;
    }
}