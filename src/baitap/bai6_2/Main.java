package bai6_2;

public class Main {
    public static void main(String[] args) {
        Circle c1=new Circle(2);
        System.out.println(c1);
        System.out.println("dien tich la : "+c1.getArea());
        System.out.println("chu vi la " +c1.getPerimeter());
        Rectangle r1=new Rectangle(4,5);
        System.out.println(r1);
        System.out.println("Dien tich la  "+r1.getArea());
        System.out.println("chu vi la "+r1.getPerimeter());
    }
}
