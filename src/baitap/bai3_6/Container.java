package bai3_6;

public class Container {
    private int x, y, width, height;

    public Container(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Kiểm tra xem bóng có chạm vào biên không
    public boolean collidesWith(Ball ball) {
        if (ball.getX() - ball.getRadius() <= x || ball.getX() + ball.getRadius() >= x + width) {
            ball.reflectHorizontal();
            return true;
        }
        if (ball.getY() - ball.getRadius() <= y || ball.getY() + ball.getRadius() >= y + height) {
            ball.reflectVertical();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Container[(%d,%d), width=%d, height=%d]", x, y, width, height);
    }
}

