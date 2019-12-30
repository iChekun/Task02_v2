package by.trjava.trips.chekun.domain.entity;


public abstract class Trip {

    private String name;

    private int id;

    private String transportType;

    private String typeOfFood;

    private String tripLocation;

    private int dayCount;

    private double cost;


    public Trip() {
    }

    public Trip(String name) {
        this.name = name;
    }

    public Trip(int id, String name, String transportType, String typeOfFood, String tripLocation, int dayCount, double cost) {
        this(name);

        this.id = id;
        this.transportType = transportType;
        this.typeOfFood = typeOfFood;
        this.tripLocation = tripLocation;
        this.dayCount = dayCount;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    public String getTripLocation() {
        return tripLocation;
    }

    public void setTripLocation(String tripLocation) {
        this.tripLocation = tripLocation;
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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

        Trip trip = (Trip) obj;


        return (transportType == trip.transportType || (transportType != null && transportType.equalsIgnoreCase(trip.transportType)))
                && (typeOfFood == trip.typeOfFood || (typeOfFood != null && typeOfFood.equalsIgnoreCase(trip.typeOfFood)))
                && (tripLocation == trip.tripLocation || (tripLocation != null && tripLocation.equalsIgnoreCase(trip.tripLocation)))
                && dayCount == trip.dayCount
                && Double.compare(cost, trip.cost) == 0;

    }

    @Override
    public int hashCode() {
        return (int) (31 * cost + dayCount
                + ((transportType == null) ? 0 : transportType.hashCode())
                + ((typeOfFood == null) ? 0 : typeOfFood.hashCode())
                + ((tripLocation == null) ? 0 : tripLocation.hashCode()));
    }

    @Override
    public String toString() {
        return "ID=" + id +
                ", TRANSPORT_TYPE=" + transportType +
                ", TYPE_OF_FOOD=" + typeOfFood +
                ", TRIP_LOCATION=" + tripLocation +
                ", DAY_COUNT=" + dayCount +
                ", COST=" + cost;
    }


}
