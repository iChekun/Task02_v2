package by.trjava.trips.chekun.domain.specification.impl.shoppingtrip;

import by.trjava.trips.chekun.domain.entity.fields.TripField;
import by.trjava.trips.chekun.domain.entity.type.TripType;
import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;
import by.trjava.trips.chekun.domain.specification.criteria.Criteria;
import by.trjava.trips.chekun.domain.specification.criteria.InputLineValidator;

public class ShoppingTripSpecificationByBaggageWeightLimit extends AbstractTripSpecification {

    private Criteria criteria = new Criteria(TripType.ShoppingTrip.toString());
    private InputLineValidator validator;


    public ShoppingTripSpecificationByBaggageWeightLimit(double baggageWeight) {
        this.criteria.add(TripField.ShoppingTrip.BAGGAGE_WEIGHT_LIMIT.name(), baggageWeight);
        validator = new InputLineValidator(criteria);
    }

    @Override
    public boolean isSatisfiedBy(String string) {
        return validator.validate(string);
    }
}
