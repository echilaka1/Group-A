package Lab3.Prob3.inheritance;

public class Circle {
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double computeArea() {
        return Math.PI * radius * radius;
    }
}