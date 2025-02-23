package bai3_5;
public class MyDate {
    private int day, month, year;
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Constructor
    public MyDate(int day, int month, int year) {
        setDate(day, month, year);
    }

    // Kiểm tra năm nhuận
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Lấy số ngày tối đa trong tháng
    private int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) return 29;
        return DAYS_IN_MONTH[month];
    }

    // Đặt lại ngày tháng năm với kiểm tra hợp lệ
    public void setDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1 || day > getDaysInMonth(month, year)) {
            throw new IllegalArgumentException("Ngày tháng không hợp lệ!");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Getter
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    // Setter
    public void setDay(int day) {
        setDate(day, this.month, this.year);
    }

    public void setMonth(int month) {
        setDate(this.day, month, this.year);
    }

    public void setYear(int year) {
        setDate(this.day, this.month, year);
    }

    // Chuyển đổi thành chuỗi DD/MM/YYYY
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    // Tăng ngày
    public MyDate nextDay() {
        if (day < getDaysInMonth(month, year)) {
            day++;
        } else {
            day = 1;
            nextMonth();
        }
        return this;
    }

    // Giảm ngày
    public MyDate previousDay() {
        if (day > 1) {
            day--;
        } else {
            previousMonth();
            day = getDaysInMonth(month, year);
        }
        return this;
    }

    // Tăng tháng
    public MyDate nextMonth() {
        if (month < 12) {
            month++;
        } else {
            month = 1;
            nextYear();
        }
        day = Math.min(day, getDaysInMonth(month, year));
        return this;
    }

    // Giảm tháng
    public MyDate previousMonth() {
        if (month > 1) {
            month--;
        } else {
            month = 12;
            previousYear();
        }
        day = Math.min(day, getDaysInMonth(month, year));
        return this;
    }

    // Tăng năm
    public MyDate nextYear() {
        year++;
        day = Math.min(day, getDaysInMonth(month, year));
        return this;
    }

    // Giảm năm
    public MyDate previousYear() {
        if (year > 1) {
            year--;
            day = Math.min(day, getDaysInMonth(month, year));
        }
        return this;
    }
}
