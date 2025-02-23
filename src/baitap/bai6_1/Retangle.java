package bai6_1;

public class Retangle extends Shape {
    protected double width = 1.0;
    protected double length = 1.0;

    public Retangle() {

    }
    public Retangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    public Retangle(double width, double length, String color, Boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }


    @Override
    public double getArea(){
        return width * length;
    }
    @Override
    public double getPerimeter(){
        return 2 * (width + length);
    }

    @Override
    public String toString() {
        return "bai6_1.Retangle[ bai6_1.Shape: "+super.toString()+", Width: "+width+", Length: "+length+"]";
    }


}

