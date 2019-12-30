package by.trjava.trips.chekun.domain.specification.impl.medicaltrip;

import by.trjava.trips.chekun.domain.entity.MedicalTrip;
import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.entity.fields.TripField;
import by.trjava.trips.chekun.domain.entity.type.TripType;
import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;
import by.trjava.trips.chekun.domain.specification.TripSpecification;
import by.trjava.trips.chekun.domain.specification.criteria.Criteria;
import by.trjava.trips.chekun.domain.specification.criteria.InputLineValidator;

public class MedicalTripSpecificationByPhysioTherapyType extends AbstractTripSpecification {

    private Criteria criteria = new Criteria(TripType.MedicalTrip.toString());
    private InputLineValidator validator;

    public MedicalTripSpecificationByPhysioTherapyType(String physiotherapyType) {
        this.criteria.add(TripField.MedicalTrip.PHYSIOTHERAPY_TYPE.toString(), physiotherapyType);
        this.validator = new InputLineValidator(this.criteria);
    }


    @Override
    public boolean isSatisfiedBy(String string) {
        return validator.validate(string);
    }


}


