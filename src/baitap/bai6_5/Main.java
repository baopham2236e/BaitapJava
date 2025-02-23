package bai6_5;
public class Main {
    public static void main(String[] args) {
        Circle c1=new Circle(4.0);
        System.out.println(c1);
        System.out.println("chu vi "+c1.getperimeter());
        System.out.println("dien tich "+c1.getArea());
        ResizableCircle c2=new ResizableCircle(3.5);
        System.out.println(c2);
        System.out.println("chu vi "+c2.getperimeter());
        System.out.println("dien tich "+c2.getArea());
        c2.resize(70);
        System.out.println("chu vi "+c2.getperimeter());
        System.out.println("dien tich"+c2.getArea());
    }
}