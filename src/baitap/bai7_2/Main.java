package bai7_2;

public class Main {
    public static void main(String[] args) {
        Polyline polyline = new Polyline();
        polyline.addPoint(new Point(1, 2));
        polyline.addPoint(new Point(4, 6));
        polyline.addPoint(new Point(7, 10));

        System.out.println(polyline);
        System.out.println("Total Length: " + polyline.getLength());
    }
}
