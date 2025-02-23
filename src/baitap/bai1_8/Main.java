package bai1_8;

public class Main {
    public static void main(String[] args) {
        Time time1 = new Time(23, 59, 59);
        System.out.println("Current Time: " + time1); // 23:59:59

        time1.nextSecond();
        System.out.println("After next second: " + time1); // 00:00:00

        time1.previousSecond();
        System.out.println("After previous second: " + time1); // 23:59:59
    }
}
