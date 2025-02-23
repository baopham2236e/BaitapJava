package bai1_3;

public class Retangle {
    private float length;
    private float width;
    Retangle(){
        length = 1.0f;
        width = 1.0f;
    }
    Retangle(float length, float width){
        this.length = length;
        this.width = width;
    }

    public void setLenght(float length){
        this.length = length;
    }
    public float getLength(){
        return length;
    }

    public void setWidth (float width){
        this.width = width;
    }

    public float getWidth(){
        return width ;
    }

    public float area(){
        return length*width;
    }

    public float primeter(){
        return (length+width)*2;
    }
    public String toString(){
        return "bai1_3.bai6_1.Retangle{" + "length=" + length + ", width=" + width + '}';
    }
}


