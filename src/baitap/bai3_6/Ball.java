package bai3_6;

public class Ball {
    private int x, y, radius, xDelta, yDelta;

    public Ball(int x, int y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = (int) (speed * Math.cos(Math.toRadians(direction)));
        this.yDelta = (int) (-speed * Math.sin(Math.toRadians(direction))); // Trục y hướng xuống
    }

    // Getter và Setter
    public int getX() { return x; }
    public int getY() { return y; }
    public int getRadius() { return radius; }
    public int getXDelta() { return xDelta; }
    public int getYDelta() { return yDelta; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setRadius(int radius) { this.radius = radius; }
    public void setXDelta(int xDelta) { this.xDelta = xDelta; }
    public void setYDelta(int yDelta) { this.yDelta = yDelta; }

    // Di chuyển bóng
    public void move() {
        x += xDelta;
        y += yDelta;
    }

    // Đảo chiều khi va chạm với biên
    public void reflectHorizontal() {
        xDelta = -xDelta;
    }

    public void reflectVertical() {
        yDelta = -yDelta;
    }

    @Override
    public String toString() {
        return String.format("Ball[(%d,%d), speed=(%d,%d)]", x, y, xDelta, yDelta);
    }
}
