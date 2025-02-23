package bai3_1;
public class Main {
    public static void main(String[] args) {
        // Tạo hai số phức
        MyComplex num1 = new MyComplex(3.0, 4.0);
        MyComplex num2 = new MyComplex(1.5, -2.5);

        // Hiển thị số phức
        System.out.println("Số phức 1: " + num1);
        System.out.println("Số phức 2: " + num2);

        // Kiểm tra số thực/số ảo
        System.out.println("Số phức 1 có phải số thực? " + num1.isReal());
        System.out.println("Số phức 1 có phải số ảo? " + num1.isImaginary());

        // So sánh hai số phức
        System.out.println("Hai số phức có bằng nhau? " + num1.equals(num2));

        // Tính độ lớn (magnitude)
        System.out.println("Độ lớn của số phức 1: " + num1.magnitude());

        // Cộng hai số phức
        MyComplex sum1 = num1.addNew(num2);
        System.out.println("Tổng của số phức 1 và số phức 2 (tạo số mới): " + sum1);

        num1.addInto(num2);
        System.out.println("Tổng của số phức 1 và số phức 2 (thay đổi trực tiếp): " + num1);
    }
}
