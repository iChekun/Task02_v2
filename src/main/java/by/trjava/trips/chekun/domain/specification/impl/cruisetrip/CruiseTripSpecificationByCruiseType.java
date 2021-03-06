package by.trjava.trips.chekun.domain.specification.impl.cruisetrip;

import by.trjava.trips.chekun.domain.entity.CruiseTrip;
import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.entity.fields.TripField;
import by.trjava.trips.chekun.domain.entity.type.TripType;
import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;
import by.trjava.trips.chekun.domain.specification.TripSpecification;
import by.trjava.trips.chekun.domain.specification.criteria.Criteria;
import by.trjava.trips.chekun.domain.specification.criteria.InputLineValidator;

public class CruiseTripSpecificationByCruiseType extends AbstractTripSpecification {

    private Criteria criteria = new Criteria(TripType.CruiseTrip.toString());
    private InputLineValidator validator;

    public CruiseTripSpecificationByCruiseType(String cruiseType) {
        this.criteria.add(TripField.CruiseTrip.CRUISE_TYPE.name(), cruiseType);
        this.validator = new InputLineValidator(this.criteria);
    }


    @Override
    public boolean isSatisfiedBy(String string) {
        return validator.validate(string);
    }


}


