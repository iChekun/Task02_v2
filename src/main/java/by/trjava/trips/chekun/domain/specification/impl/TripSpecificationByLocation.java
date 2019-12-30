package by.trjava.trips.chekun.domain.specification.impl;

import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.entity.fields.TripField;
import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;
import by.trjava.trips.chekun.domain.specification.TripSpecification;
import by.trjava.trips.chekun.domain.specification.criteria.Criteria;
import by.trjava.trips.chekun.domain.specification.criteria.InputLineValidator;

public class TripSpecificationByLocation extends AbstractTripSpecification {

    private Criteria criteria = new Criteria();
    private InputLineValidator validator;

    public TripSpecificationByLocation(String location) {
        this.criteria.add(TripField.Trip.TRIP_LOCATION.toString(), location);
        this.validator = new InputLineValidator(this.criteria);
    }


    @Override
    public boolean isSatisfiedBy(String string) {
        return validator.validate(string);
    }


}



