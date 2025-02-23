package bai3_3;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập hai số nguyên lớn từ bàn phím
        System.out.print("Nhập số nguyên lớn thứ nhất: ");
        BigInteger num1 = new BigInteger(scanner.nextLine());

        System.out.print("Nhập số nguyên lớn thứ hai: ");
        BigInteger num2 = new BigInteger(scanner.nextLine());

        // Thực hiện phép toán
        BigInteger sum = num1.add(num2);
        BigInteger difference = num1.subtract(num2);
        BigInteger product = num1.multiply(num2);

        // Hiển thị kết quả
        System.out.println("Tổng: " + sum);
        System.out.println("Hiệu: " + difference);
        System.out.println("Tích: " + product);

        scanner.close();
    }
}
