package by.trjava.trips.chekun.domain.entity;

public class ExcursionTrip extends Trip {

    private int countOfExcursions;

    private String excursionPlaceName;


    public ExcursionTrip() {
        super(ExcursionTrip.class.getSimpleName());
    }

    public ExcursionTrip(int id, String transportType, String typeOfFood, String country, int dayCount, double cost, int countOfExcursions, String excursionPlaceName) {
        super(id, ExcursionTrip.class.getSimpleName(), transportType, typeOfFood, country, dayCount, cost);

        this.countOfExcursions = countOfExcursions;
        this.excursionPlaceName = excursionPlaceName;
    }

    public int getCountOfExcursions() {
        return countOfExcursions;
    }

    public void setCountOfExcursions(int countOfExcursions) {
        this.countOfExcursions = countOfExcursions;
    }

    public String getExcursionPlaceName() {
        return excursionPlaceName;
    }

    public void setExcursionPlaceName(String excursionPlaceName) {
        this.excursionPlaceName = excursionPlaceName;
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

        ExcursionTrip excursionTrip = (ExcursionTrip) obj;

        return countOfExcursions == excursionTrip.countOfExcursions
                && (excursionPlaceName == excursionTrip.excursionPlaceName || (excursionPlaceName != null && excursionPlaceName.equalsIgnoreCase(excursionTrip.excursionPlaceName)));
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return hash * 31 + countOfExcursions
                + (excursionPlaceName == null ? 0 : excursionPlaceName.hashCode());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " : " +
                super.toString() +
                ", COUNT_OF_EXCURSIONS=" + countOfExcursions +
                ", EXCURSION_PLACE_NAME=" + excursionPlaceName + ";";
    }
}
