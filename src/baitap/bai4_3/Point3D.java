package bai4_3;

public class Point3D extends Point2D {
    private float z;
    public Point3D( float x, float y, float z){
        super(x,y);
        this.z = z;
    }
    public float getZ(){
        return z;
    }
    public void setz(float z){
        this.z = z;
    }
    public void setXYZ(float x, float y, float z){
        setX(x);
        setY(y);
    }
    public float[] getXYZ(){
        float[] result = new float[3];
        result[0] = 5;
        result[1] = 6;
        result[2] = 7;
        return result;
    }
    public String toString(){
        return "Point[" + super.toString() + ", z=" + z + "]";
    }
}

