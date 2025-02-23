package bai3_6;

public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(50, 50, 10, 5, 45);
        Container box = new Container(0, 0, 100, 100);

        System.out.println("Bắt đầu: " + ball);

        // Di chuyển bóng 10 lần
        for (int i = 0; i < 10; i++) {
            ball.move();
            if (box.collidesWith(ball)) {
                System.out.println("Va chạm! " + ball);
            } else {
                System.out.println("Vị trí mới: " + ball);
            }
        }
    }
}
