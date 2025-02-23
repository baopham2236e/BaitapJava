package bai4_5;

public class Square extends Shape {
    public double side;

    Square(){
    }
    Square(double side){
        this.side = side;
    }
    Square(double side,String color, boolean filled){
        super(filled, color);
        this.side = side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public String toString(){
        return "Square " + "side=" + side;
    }
}

