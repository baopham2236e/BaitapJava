package bai4_2;

public class Main4_2 {
    public static void main(String[] args) {
        Person p1 = new Person("tai", "quang nam");
        Student s1 = new Student("java", 2024, 30, "tan tai", "quang nam");
        Staff st = new Staff("DH CNTT Viet Han", 10000, "tantai", "quang nam");
        System.out.println(p1);
        System.out.println(s1);
        System.out.println(st);
    }
}
