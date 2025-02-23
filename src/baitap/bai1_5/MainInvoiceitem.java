package bai1_5;

public class MainInvoiceitem {
    public static void main(String[] args) {
        Invoiceitem i1 = new Invoiceitem("A1001", "Pen red", 888, 0.08);
        System.out.println(i1);
        Invoiceitem i2 = new Invoiceitem("A1002", "Pen red", 999, 0.99);
        System.out.println(i2);

        System.out.println("id is: " + i2.getId());
        System.out.println("desc is: " + i2.getDesc());
        System.out.println("qty is: " + i2.getQty());
        System.out.println("unitPrice is: " + i2.getUnitPrice());
        System.out.println("total is: " + i2.getTotal());


    }

}
