package bai3_2;

public class Main {
    public static void main(String[] args) {
        // Tạo các đa thức
        MyPolynomial p1 = new MyPolynomial(1.0, -3.0, 2.0); // 2.0x^2 - 3.0x + 1.0
        MyPolynomial p2 = new MyPolynomial(0.0, 2.0, 1.0);  // 1.0x^2 + 2.0x

        // In ra các đa thức
        System.out.println("Đa thức p1: " + p1);
        System.out.println("Đa thức p2: " + p2);

        // Cộng hai đa thức
        MyPolynomial p3 = p1.add(p2);
        System.out.println("p1 + p2 = " + p3);

        // Nhân hai đa thức
        MyPolynomial p4 = p1.multiply(p2);
        System.out.println("p1 * p2 = " + p4);

        // Tính giá trị của p1 tại x = 2.0
        double x = 2.0;
        System.out.println("Giá trị của p1 tại x = " + x + " là " + p1.evaluate(x));
    }
}
