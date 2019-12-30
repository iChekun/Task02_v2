package by.trjava.trips.chekun.domain.specification.impl.cruisetrip;

import by.trjava.trips.chekun.domain.entity.CruiseTrip;
import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.entity.fields.TripField;
import by.trjava.trips.chekun.domain.entity.type.TripType;
import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;
import by.trjava.trips.chekun.domain.specification.TripSpecification;
import by.trjava.trips.chekun.domain.specification.criteria.Criteria;
import by.trjava.trips.chekun.domain.specification.criteria.InputLineValidator;

public class CruiseTripSpecificationByDailyTips extends AbstractTripSpecification {

    private Criteria criteria = new Criteria(TripType.CruiseTrip.toString());
    private InputLineValidator validator;

    public CruiseTripSpecificationByDailyTips(double dailyTips) {
        this.criteria.add(TripField.CruiseTrip.DAILY_TIPS.name(), dailyTips);
        this.validator = new InputLineValidator(this.criteria);
    }


    @Override
    public boolean isSatisfiedBy(String string) {
        return validator.validate(string);
    }

}