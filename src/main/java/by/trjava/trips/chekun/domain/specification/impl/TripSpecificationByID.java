package by.trjava.trips.chekun.domain.specification.impl;

import by.trjava.trips.chekun.domain.entity.fields.TripField;
import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;
import by.trjava.trips.chekun.domain.specification.criteria.Criteria;
import by.trjava.trips.chekun.domain.specification.criteria.InputLineValidator;

public class TripSpecificationByID extends AbstractTripSpecification {

    private Criteria criteria = new Criteria();
    private InputLineValidator validator;

    public TripSpecificationByID(int id) {
        this.criteria.add(TripField.Trip.ID.toString(), id);
        this.validator = new InputLineValidator(this.criteria);
    }


    @Override
    public boolean isSatisfiedBy(String string) {
        return validator.validate(string);
    }

}
