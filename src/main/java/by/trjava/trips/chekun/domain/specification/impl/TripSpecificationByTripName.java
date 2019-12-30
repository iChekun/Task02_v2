package by.trjava.trips.chekun.domain.specification.impl;


import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;
import by.trjava.trips.chekun.domain.specification.criteria.Criteria;
import by.trjava.trips.chekun.domain.specification.criteria.InputLineValidator;

public class TripSpecificationByTripName extends AbstractTripSpecification {

    private Criteria criteria;
    private InputLineValidator validator;

    public TripSpecificationByTripName(String name) {
        this.criteria =  new Criteria(name);
        this.validator = new InputLineValidator(this.criteria);
    }


    @Override
    public boolean isSatisfiedBy(String string) {
        return validator.validate(string);
    }


}


