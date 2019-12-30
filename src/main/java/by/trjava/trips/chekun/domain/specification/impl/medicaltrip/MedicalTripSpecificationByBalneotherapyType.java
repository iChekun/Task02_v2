package by.trjava.trips.chekun.domain.specification.impl.medicaltrip;

import by.trjava.trips.chekun.domain.entity.MedicalTrip;
import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.entity.fields.TripField;
import by.trjava.trips.chekun.domain.entity.type.TripType;
import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;
import by.trjava.trips.chekun.domain.specification.TripSpecification;
import by.trjava.trips.chekun.domain.specification.criteria.Criteria;
import by.trjava.trips.chekun.domain.specification.criteria.InputLineValidator;

public class MedicalTripSpecificationByBalneotherapyType extends AbstractTripSpecification {

    private Criteria criteria = new Criteria(TripType.MedicalTrip.toString());
    private InputLineValidator validator;

    public MedicalTripSpecificationByBalneotherapyType(String balneoTherapyType) {
        this.criteria.add(TripField.MedicalTrip.BALNEOTHERAPY_TYPE.toString(), balneoTherapyType);
        this.validator = new InputLineValidator(this.criteria);
    }


    @Override
    public boolean isSatisfiedBy(String string) {
        return validator.validate(string);
    }


}

