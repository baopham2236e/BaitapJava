package bai1_8;

public class Time {
    private int hour;
    private int minute;
    private int second;

    // Constructor mặc định
    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    // Constructor có tham số
    public Time(int hour, int minute, int second) {
        setTime(hour, minute, second);
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

    // Setter với kiểm tra hợp lệ
    public void setTime(int hour, int minute, int second) {
        if (hour >= 0 && hour < 24) this.hour = hour;
        if (minute >= 0 && minute < 60) this.minute = minute;
        if (second >= 0 && second < 60) this.second = second;
    }

    // Phương thức toString để hiển thị thời gian
    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    // Tăng 1 giây
    public Time nextSecond() {
        second++;
        if (second == 60) {
            second = 0;
            minute++;
            if (minute == 60) {
                minute = 0;
                hour++;
                if (hour == 24) {
                    hour = 0;
                }
            }
        }
        return this;
    }

    // Giảm 1 giây
    public Time previousSecond() {
        second--;
        if (second < 0) {
            second = 59;
            minute--;
            if (minute < 0) {
                minute = 59;
                hour--;
                if (hour < 0) {
                    hour = 23;
                }
            }
        }
        return this;
    }
}
