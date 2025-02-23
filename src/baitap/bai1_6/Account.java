package bai1_6;

public class Account {
    private String id;
    private String name;
    private int balance;

    Account(){
        int balance = 0;
    }

    Account( String id, String name){
        this.id = id;
        this.name = name;
    }
    Account( String id, String name, int balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getBalance(){
        return balance;
    }

    public int credit(int amount){
        balance += amount; // = balance + amount
        return balance;
    }

    public int debit(int amount){
        if (amount <= balance) {
            balance -= amount; // = balance - amount
        }
        else {
            System.out.println("amount exceeded balance");
        }
        return balance;
    }

    public int transferTo(Account another, int amount){
        if (amount <= balance) {
            this.debit(amount);
        }else{
            System.out.println("amount exceeded balance");
        }
        return balance;
    }

    @Override
    public String toString() {
        return "bai1_6.Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}



