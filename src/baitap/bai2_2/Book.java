package bai2_2;

public class Book {
    private String name;
    private Author authors;
    private double price;
    private int qty = 0;

    Book (String name, Author authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    Book(String name, Author authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "bai2_2.Book[ name= " + name + "authors= " + authors + "price= " + price + "qty= " + qty + "]";

    }

    public String getAuthorName(){
        return authors.getClass().getName();
    }
}

