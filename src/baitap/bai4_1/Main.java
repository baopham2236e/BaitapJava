package bai4_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cylinder cyl1 = new Cylinder(5, 10, "black");
        System.out.println(cyl1);
        System.out.println("height: " + cyl1.getHeight());
        System.out.println("Area: " + cyl1.getArea());
        System.out.println("Volume: " + cyl1.getVolume());

    }
}
