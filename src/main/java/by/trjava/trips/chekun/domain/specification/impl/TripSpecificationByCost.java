package by.trjava.trips.chekun.domain.specification.impl;

import by.trjava.trips.chekun.domain.entity.fields.TripField;
import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;
import by.trjava.trips.chekun.domain.specification.TripSpecification;
import by.trjava.trips.chekun.domain.specification.criteria.Criteria;
import by.trjava.trips.chekun.domain.specification.criteria.InputLineValidator;

public class TripSpecificationByCost extends AbstractTripSpecification {

    private Criteria criteria = new Criteria();
    private InputLineValidator validator;

    public TripSpecificationByCost(double cost) {
        this.criteria.add(TripField.Trip.COST.toString(), cost);
        this.validator = new InputLineValidator(this.criteria);
    }


    @Override
    public boolean isSatisfiedBy(String string) {
        return validator.validate(string);
    }

}