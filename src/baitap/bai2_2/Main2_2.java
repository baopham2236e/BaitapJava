package bai2_2;

public class Main2_2 {
    public static void main(String[] args) {
        Author a1= new Author  ("tan", "tai123@gmail.com", 't');
        System.out.println(a1);
        Book b1 = new Book("vy", a1, 100, 10  );
        System.out.println(b1);
    }
}
