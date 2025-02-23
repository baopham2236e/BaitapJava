package bai7_2;

import java.util.ArrayList;

public class Polyline {
    private ArrayList<Point> points;

    public Polyline() {
        this.points = new ArrayList<>();
    }

    public void addPoint(Point p) {
        points.add(p);
    }

    public double getLength() {
        double totalLength = 0.0;
        for (int i = 1; i < points.size(); i++) {
            totalLength += points.get(i - 1).distance(points.get(i));
        }
        return totalLength;
    }

    @Override
    public String toString() {
        return "Polyline" + points.toString();
    }
}
