package by.trjava.trips.chekun.domain.entity;


public class CruiseTrip extends Trip {

    private String shipName;

    private double dailyTips;

    private int numberOfPortsToVisit;

    private String cruiseType;


    public CruiseTrip() {
        super(CruiseTrip.class.getSimpleName());
    }

    public CruiseTrip(int id, String transportType, String typeOfFood, String country, int dayCount, double cost,
                      String shipName, double dailyTips, int numberOfPortsToVisit, String cruiseType) {
        super(id, CruiseTrip.class.getSimpleName(), transportType, typeOfFood, country, dayCount, cost);

        this.shipName = shipName;
        this.dailyTips = dailyTips;
        this.numberOfPortsToVisit = numberOfPortsToVisit;
        this.cruiseType = cruiseType;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public double getDailyTips() {
        return dailyTips;
    }

    public void setDailyTips(double dailyTips) {
        this.dailyTips = dailyTips;
    }

    public int getNumberOfPortsToVisit() {
        return numberOfPortsToVisit;
    }

    public void setNumberOfPortsToVisit(int numberOfPortsToVisit) {
        this.numberOfPortsToVisit = numberOfPortsToVisit;
    }

    public String getCruiseType() {
        return cruiseType;
    }

    public void setCruiseType(String cruiseType) {
        this.cruiseType = cruiseType;
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

        CruiseTrip cruiseTrip = (CruiseTrip) obj;

        return numberOfPortsToVisit == cruiseTrip.numberOfPortsToVisit
                && Double.compare(dailyTips, cruiseTrip.dailyTips) == 0
                && (shipName == cruiseTrip.shipName || (shipName != null && shipName.equalsIgnoreCase(cruiseTrip.shipName)))
                && (cruiseType == cruiseTrip.cruiseType || (cruiseType != null && cruiseType.equalsIgnoreCase(cruiseTrip.cruiseType)));
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return hash * 31 + (numberOfPortsToVisit
                + (shipName == null ? 0 : shipName.hashCode())
                + (cruiseType == null ? 0 : cruiseType.hashCode()));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " : "
                + super.toString() +
                ", SHIP_NAME=" + shipName +
                ", DAILY_TIPS=" + dailyTips +
                ", NUMBER_OF_PORTS_TO_VISIT=" + numberOfPortsToVisit +
                ", CRUISE_TYPE=" + cruiseType + ";";
    }
}
