package bai3_4;

public class MyTime {
    private int hour, minute, second;

    // Constructor
    public MyTime(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

    // Đặt lại thời gian với kiểm tra hợp lệ
    public void setTime(int hour, int minute, int second) {
        if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60 && second >= 0 && second < 60) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        } else {
            throw new IllegalArgumentException("Thời gian không hợp lệ!");
        }
    }

    // Getter
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    // Setter
    public void setHour(int hour) {
        if (hour >= 0 && hour < 24) this.hour = hour;
        else throw new IllegalArgumentException("Giờ không hợp lệ!");
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute < 60) this.minute = minute;
        else throw new IllegalArgumentException("Phút không hợp lệ!");
    }

    public void setSecond(int second) {
        if (second >= 0 && second < 60) this.second = second;
        else throw new IllegalArgumentException("Giây không hợp lệ!");
    }

    // Chuyển đổi thành chuỗi HH:MM:SS
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    // Tăng thời gian lên 1 giây
    public MyTime nextSecond() {
        second++;
        if (second == 60) {
            second = 0;
            minute++;
            if (minute == 60) {
                minute = 0;
                hour = (hour + 1) % 24;
            }
        }
        return this;
    }

    // Giảm thời gian xuống 1 giây
    public MyTime previousSecond() {
        second--;
        if (second < 0) {
            second = 59;
            minute--;
            if (minute < 0) {
                minute = 59;
                hour = (hour - 1 + 24) % 24;
            }
        }
        return this;
    }
}
