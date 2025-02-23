package bai7_1;

public class DiscountRate {
    private static final double PREMIUM_SERVICE_DISCOUNT = 0.2;
    private static final double GOLD_SERVICE_DISCOUNT = 0.15;
    private static final double SILVER_SERVICE_DISCOUNT = 0.1;
    private static final double PRODUCT_DISCOUNT = 0.1;

    public static double getServiceDiscountRate(String type) {
        switch (type) {
            case "Premium":
                return PREMIUM_SERVICE_DISCOUNT;
            case "Gold":
                return GOLD_SERVICE_DISCOUNT;
            case "Silver":
                return SILVER_SERVICE_DISCOUNT;
            default:
                return 0.0;
        }
    }

    public static double getProductDiscountRate() {
        return PRODUCT_DISCOUNT;
    }
}
