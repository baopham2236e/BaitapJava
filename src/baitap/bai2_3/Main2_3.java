package bai2_3;

public class Main2_3 {
    public static void main(String[] args) {
        Author a1 = new Author("tantai", "tai@gmail.com");
        System.out.println(a1);

        Book b1 = new Book("pntt", "tai", a1, 100, 10 );
        System.out.println(b1);

    }
}
