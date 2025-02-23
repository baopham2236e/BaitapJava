package bai2_4;

public class Main2_4 {
    public static void main(String[] args) {
        Customer c1 = new Customer(88, "tai", 10);
        System.out.println(c1);
        c1.setDiscount(8);
        System.out.println(c1);
        System.out.println("ID: "+c1.getId());
        System.out.println("Name: "+c1.getName());
        System.out.println("Discount: "+c1.getDiscount());

        Invoice i1 = new Invoice(1001, c1, 888.8);
        System.out.println(i1);
        i1.setAmount(999.9);
        System.out.println(i1);
        System.out.println("ID: "+i1.getId());
        System.out.println("customer: "+i1.getCustomer());
        System.out.println("amount: "+i1.getAmount());
        System.out.println("customer's ID: "+i1.getCustomerId());
        System.out.println("customer's Name: "+ i1.getCustomerName());
        System.out.println("customer's Discount: "+ i1.getCustomerDiscount());
        System.out.println("amount after discount: "+i1.getAmountAferDiscount());

    }
}
