package bai1_7;

public class MainDate {
    public static void main(String[] args) {
        Date d1 = new Date(23, 05, 2006);
        Date d2 = new Date(25, 11, 2008);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println("day: "+d2.getDay());
        System.out.println("month: "+d2.getMonth());
        System.out.println("year: "+d2.getYear());

    }
}
