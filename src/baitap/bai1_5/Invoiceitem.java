package bai1_5;

public class Invoiceitem {
    private String id;
    private String desc;
    private int qty;
    private double unitPrice;
    Invoiceitem(String id, String desc, int qty, double unitPrice) {
        this.id=id;
        this.desc=desc;
        this.qty=qty;
        this.unitPrice=unitPrice;
    }

    public String getId() {
        return id;
    }

    public String getDesc(){
        return desc;
    }

    public int getQty(){
        return qty;
    }

    public void setQty(int qty){
        this.qty=qty;
    }

    public double getUnitPrice(){
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice){
        this.unitPrice=unitPrice;
    }

    public double getTotal(){
        return qty*unitPrice;
    }

    @Override
    public String toString() {
        return "bai1_5.Invoiceitem{" +
                "id= " + id +
                ", desc= '" + desc + '\'' +
                ", qty= " + qty +
                ", unitPrice= " + unitPrice +
                '}';
    }
}
