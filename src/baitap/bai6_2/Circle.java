package bai6_2;

public class Circle implements GeometricObject {
    private double radiu;

    public Circle(double radiu) {
        this.radiu = radiu;
    }

    @Override
    public double getArea() {
        return Math.PI * radiu * radiu;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * radiu;
    }

    public String toString() {
        return "[radiu " + radiu + "]";
    }
}