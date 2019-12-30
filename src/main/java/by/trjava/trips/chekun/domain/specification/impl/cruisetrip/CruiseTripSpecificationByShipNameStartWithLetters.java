package by.trjava.trips.chekun.domain.specification.impl.cruisetrip;

import by.trjava.trips.chekun.domain.entity.fields.TripField;
import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;

public class CruiseTripSpecificationByShipNameStartWithLetters extends AbstractTripSpecification {


    private String letters = null;

    public CruiseTripSpecificationByShipNameStartWithLetters(String letters) {
        if (!letters.equals("")) {
            this.letters = TripField.CruiseTrip.SHIP_NAME.name() + "=" + letters;
        }
    }

    @Override
    public boolean isSatisfiedBy(String data) {
        return letters != null && data.toUpperCase().contains(letters.toUpperCase());
    }


}
