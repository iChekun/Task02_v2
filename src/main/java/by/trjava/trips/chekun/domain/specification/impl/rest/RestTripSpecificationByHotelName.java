package by.trjava.trips.chekun.domain.specification.impl.rest;

import by.trjava.trips.chekun.domain.entity.fields.TripField;
import by.trjava.trips.chekun.domain.entity.type.TripType;
import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;
import by.trjava.trips.chekun.domain.specification.criteria.Criteria;
import by.trjava.trips.chekun.domain.specification.criteria.InputLineValidator;

public class RestTripSpecificationByHotelName extends AbstractTripSpecification {

    private Criteria criteria = new Criteria(TripType.RestTrip.toString());
    private InputLineValidator validator;


    public RestTripSpecificationByHotelName(String hotelName) {
        this.criteria.add(TripField.RestTrip.HOTEL_NAME.name(), hotelName);
        validator = new InputLineValidator(criteria);
    }

    @Override
    public boolean isSatisfiedBy(String string) {
        return validator.validate(string);
    }
}
