package by.trjava.trips.chekun.domain.specification.impl;

import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;


public class TripSpecificationGetAllTrips extends AbstractTripSpecification {

    @Override
    public boolean isSatisfiedBy(String tripString) {
        //true cause we want get all trips
        return true;
    }
}
