package bai2_5;

public class Accont {
    private int id;
    private Customer customer;
    private double balance = 0.0;

    public Accont(int id, Customer customer, double balance) {
        this.id = id;
        this.customer = customer;
        this.balance = balance;
    }

    public Accont(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "bai2_5.Accont [id=" + id + ", customer=" + customer + ", balance=" + balance + "]";
    }

    public String getCustomerName(){
        return customer.getName();
    }
    public Accont deposit(double amount) {
        balance += amount;
        return this;
    }
    public Accont withdraw(double amount) {
        balance -= amount;
        return this;
    }
}


