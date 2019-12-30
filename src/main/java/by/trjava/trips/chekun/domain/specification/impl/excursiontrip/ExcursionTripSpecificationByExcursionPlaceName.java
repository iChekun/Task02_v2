package by.trjava.trips.chekun.domain.specification.impl.excursiontrip;


import by.trjava.trips.chekun.domain.entity.fields.TripField;
import by.trjava.trips.chekun.domain.entity.type.TripType;
import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;
import by.trjava.trips.chekun.domain.specification.criteria.Criteria;
import by.trjava.trips.chekun.domain.specification.criteria.InputLineValidator;

public class ExcursionTripSpecificationByExcursionPlaceName extends AbstractTripSpecification {

    private Criteria criteria = new Criteria(TripType.ExcursionTrip.toString());
    private InputLineValidator validator;

    public ExcursionTripSpecificationByExcursionPlaceName(String excursionPlaceName) {
        this.criteria.add(TripField.ExcursionTrip.EXCURSION_PLACE_NAME.toString(), excursionPlaceName);
        this.validator = new InputLineValidator(this.criteria);
    }

    @Override
    public boolean isSatisfiedBy(String string) {
        return validator.validate(string);
    }


}


