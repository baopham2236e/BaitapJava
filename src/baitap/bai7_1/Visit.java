package bai7_1;

import java.util.Date;

public class Visit {
    private Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit(Customer customer, Date date) {
        this.customer = customer;
        this.date = date;
        this.serviceExpense = 0.0;
        this.productExpense = 0.0;
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public double getTotalExpense() {
        double serviceDiscount = serviceExpense * DiscountRate.getServiceDiscountRate(customer.getMemberType());
        double productDiscount = productExpense * DiscountRate.getProductDiscountRate();
        return (serviceExpense - serviceDiscount) + (productExpense - productDiscount);
    }

    @Override
    public String toString() {
        return String.format("Visit[Customer=%s, Date=%s, ServiceExpense=%.2f, ProductExpense=%.2f, TotalExpense=%.2f]",
                customer, date, serviceExpense, productExpense, getTotalExpense());
    }
}
