package bai4_5;

public class Shape {
    private String color = "red";
    private boolean filled = true;

    public Shape(){
        //
    }
    public Shape(boolean filled, String color) {
        this.filled = filled;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled(){
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return " bai6_1.Shape [ " + " color: " + color + ", filled=" + filled + "]";
    }

}
