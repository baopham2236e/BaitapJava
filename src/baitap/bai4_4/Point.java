package bai4_4;

public class Point {
    protected float x;
    public float y;
    public Point(float x, float y) {
        this.x=x;
        this.y=y;
    }
    public Point() {
    }
    public float getX(){
        return x;
    }
    public void setX(float x){
        this.x=x;
    }
    public float getY(){
        return y;
    }
    public void setY(float y){
        this.y=y;
    }
    public void setXY(float x, float y){
        this.x=x;
        this.y=y;
    }
    public float[] getXY(){
        float[] result = new float[2];
        result[0]=x;
        result[1]=y;
        return result;
    }
    public String toString(){
        return "x="+x+" y="+y;
    }
}
