package bai2_5;

public class Main2_5 {
    public static void main(String[] args) {
        Customer c1 = new Customer(1001, "tantai", 't');
        System.out.println(c1);

        Accont a1 = new Accont(2511, c1, 20000);
        System.out.println(a1);

        System.out.println("customer name: "+ a1.getCustomerName());
        System.out.println("deposit: "+ a1.deposit(12000));
        System.out.println("withdraw: "+ a1.withdraw(12000));
    }
}
