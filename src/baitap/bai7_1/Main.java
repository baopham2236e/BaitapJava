package bai7_1;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Customer customer1 = new Customer("John Doe");
        customer1.setMember(true);
        customer1.setMemberType("Gold");

        Visit visit1 = new Visit(customer1, new Date());
        visit1.setServiceExpense(100);
        visit1.setProductExpense(50);

        System.out.println(visit1);

        Customer customer2 = new Customer("Alice");
        customer2.setMember(true);
        customer2.setMemberType("Premium");

        Visit visit2 = new Visit(customer2, new Date());
        visit2.setServiceExpense(200);
        visit2.setProductExpense(80);

        System.out.println(visit2);
    }
}

