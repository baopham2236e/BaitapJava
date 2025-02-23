package bai2_1;

public class Book {
    private String name;
    private Author author;
    private double price;
    private int qty;

    Book(){
        int qty = 0;
    }
    Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    Book(String name, Author author, double price, int qty){
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public String getName(){
        return name;
    }
    public Author getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty){
        this.qty =qty;
    }

    @Override
    public String toString() {
        return "bai2_1.bai2_2.Book[ name: " + name + ", author: " + author + ", price: " + price + ", qty: " + qty + "]";
    }

}
