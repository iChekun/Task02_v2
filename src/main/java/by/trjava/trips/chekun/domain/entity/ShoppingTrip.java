package by.trjava.trips.chekun.domain.entity;

public class ShoppingTrip extends Trip {

    private String shopCentreName;

    private double baggageWeightLimit;


    public ShoppingTrip() {
        super(ShoppingTrip.class.getSimpleName());
    }

    public ShoppingTrip(int id, String transportType, String typeOfFood, String country, int dayCount, double cost, String shopCentreName, double baggageWeightLimit) {
        super(id, ShoppingTrip.class.getSimpleName(), transportType, typeOfFood, country, dayCount, cost);

        this.shopCentreName = shopCentreName;
        this.baggageWeightLimit = baggageWeightLimit;
    }

    public String getShopCentreName() {
        return shopCentreName;
    }

    public void setShopCentreName(String shopCentreName) {
        this.shopCentreName = shopCentreName;
    }

    public double getBaggageWeightLimit() {
        return baggageWeightLimit;
    }

    public void setBaggageWeightLimit(double baggageWeightLimit) {
        this.baggageWeightLimit = baggageWeightLimit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }

        ShoppingTrip shoppingTrip = (ShoppingTrip) obj;

        return Double.compare(baggageWeightLimit, shoppingTrip.baggageWeightLimit) == 0
                && (shopCentreName == shoppingTrip.shopCentreName || (shopCentreName != null && shopCentreName.equalsIgnoreCase(shoppingTrip.shopCentreName)));
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return (int) (hash * 31 + (baggageWeightLimit
                + (shopCentreName == null ? 0 : shopCentreName.hashCode())));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " : "
                + super.toString() +
                ", SHOP_CENTRE_NAME=" + shopCentreName +
                ", BAGGAGE_WEIGHT_LIMIT=" + baggageWeightLimit + ";";
    }
}
