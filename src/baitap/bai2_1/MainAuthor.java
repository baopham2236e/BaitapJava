package bai2_1;

public class MainAuthor {
    public static void main(String[] args) {
        Author a1 = new Author("tan tai", "tai@gmail.com", 't');
        System.out.println(a1);

        Book b1 = new Book("tai", a1, 12000, 10  );
        System.out.println(b1);
    }
}
