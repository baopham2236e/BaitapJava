package bai4_5;

public class Circle extends Shape{
    private double radius = 1.0;
    Circle (){
        //
    }
    Circle (double radius){
        this.radius = radius;
    }
    Circle (double radius, String color, boolean filled){
        super(filled, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
    @Override
    public String toString(){
        return " bai6_1.Circle: ["+ super.toString() + " radius=" + radius + "]";
    }
}

