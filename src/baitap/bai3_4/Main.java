package bai3_4;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo đối tượng MyTime
        MyTime time = new MyTime(23, 59, 59);
        System.out.println("Thời gian ban đầu: " + time);

        // Thử tăng 1 giây
        time.nextSecond();
        System.out.println("Sau khi tăng 1 giây: " + time);

        // Thử giảm 1 giây
        time.previousSecond();
        System.out.println("Sau khi giảm 1 giây: " + time);

        // Thử đặt lại thời gian
        time.setTime(12, 30, 45);
        System.out.println("Sau khi đặt lại thời gian: " + time);
    }
}

