package by.trjava.trips.chekun.domain.specification.impl;


import by.trjava.trips.chekun.domain.entity.fields.TripField;
import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;


public class TripSpecificationByLocationStartWithLetters extends AbstractTripSpecification {


    private String letter = null;

    public TripSpecificationByLocationStartWithLetters(String letter) {
        if (!letter.equals("")) {
            this.letter = TripField.Trip.TRIP_LOCATION.name() + "=" + letter;
        }
    }

    @Override
    public boolean isSatisfiedBy(String data) {
        return letter != null && data.toUpperCase().contains(letter.toUpperCase());
    }


}
