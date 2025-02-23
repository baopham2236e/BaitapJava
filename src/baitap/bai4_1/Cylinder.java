package bai4_1;

public class Cylinder extends Circle{
    double height = 1.0;

    Cylinder(){
        //
    }
    Cylinder(double radius){
        super();
    }
    Cylinder(double radius, double height){
        super();
        this.height = height;
    }
    Cylinder(double radius, double height, String color){
        super(radius, color);
        this.height = height;
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getVolume(){
        return getArea() * height;
    }

    public String toSring(){
        return "Cylinder [" + super.toString() + ", Height: " + height + "]";
    }


}