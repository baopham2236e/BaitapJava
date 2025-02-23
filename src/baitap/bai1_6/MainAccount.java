package bai1_6;

public class MainAccount {
    public static void main(String[] args) {
        Account a1 = new Account("A1001", "tan tai", 88);
        Account a2 = new Account("A1002", "duc thang");
        System.out.println(a1);
        System.out.println(a2);

        System.out.println("ID: "+a1.getId());
        System.out.println("Name: "+a1.getName());
        System.out.println("Balance: "+a1.getBalance());

        a1.credit(100);
        System.out.println(a1);
        a1.debit(50);
        System.out.println(a1);
        a1.credit(500);
        System.out.println(a1);

        a1.transferTo(a2, 100);
        System.out.println(a1);
        System.out.println(a2);

    }
}
