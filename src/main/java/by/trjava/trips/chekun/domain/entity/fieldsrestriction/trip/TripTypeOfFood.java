package by.trjava.trips.chekun.domain.entity.fieldsrestriction.trip;

public enum TripTypeOfFood {

    BB("Bed&Breakfast"),
    НВ("Нalf-Board"),
    FB("Full-Board"),
    AI("All-Inclusive"),
    UAI("Ultra-All-Inclusive"),
    NA("Not-Available"),
    RO("Room-Only");


    private String name;

    private TripTypeOfFood(final String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return this.name;
    }


}
