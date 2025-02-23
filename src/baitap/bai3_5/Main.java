package bai3_5;


    public class Main {
        public static void main(String[] args) {
            // Khởi tạo đối tượng MyDate
            MyDate date = new MyDate(28, 2, 2024);
            System.out.println("Ngày ban đầu: " + date);

            // Thử tăng 1 ngày
            date.nextDay();
            System.out.println("Sau khi tăng 1 ngày: " + date);

            // Thử giảm 1 ngày
            date.previousDay();
            System.out.println("Sau khi giảm 1 ngày: " + date);

            // Thử tăng 1 tháng
            date.nextMonth();
            System.out.println("Sau khi tăng 1 tháng: " + date);

            // Thử giảm 1 tháng
            date.previousMonth();
            System.out.println("Sau khi giảm 1 tháng: " + date);

            // Thử tăng 1 năm
            date.nextYear();
            System.out.println("Sau khi tăng 1 năm: " + date);

            // Thử giảm 1 năm
            date.previousYear();
            System.out.println("Sau khi giảm 1 năm: " + date);
        }
    }



