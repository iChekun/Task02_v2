package by.trjava.trips.chekun.domain.entity;



public class RestTrip extends Trip {

    private String hotelName;

    private int hotelLevel;


    public RestTrip() {
        super(RestTrip.class.getSimpleName());
    }

    public RestTrip(int id, String transportType, String typeOfFood, String country, int dayCount, double cost, String hotelName, int hotelLevel) {
        super(id, RestTrip.class.getSimpleName(), transportType, typeOfFood, country, dayCount, cost);

        this.hotelName = hotelName;
        this.hotelLevel = hotelLevel;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(int hotelLevel) {
        this.hotelLevel = hotelLevel;
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

        RestTrip restTrip = (RestTrip) obj;

        return (hotelName == restTrip.hotelName || (hotelName != null && hotelName.equalsIgnoreCase(restTrip.hotelName)))
                && hotelLevel == restTrip.hotelLevel;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return hash * 31 + (hotelLevel
                + (hotelName == null ? 0 : hotelName.hashCode()));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " : "
                + super.toString() +
                ", HOTEL_NAME=" + hotelName +
                ", HOTEL_LEVEL=" + hotelLevel + ";";
    }
}
