package by.trjava.trips.chekun.domain.service;

import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.service.exception.TripServiceException;
import by.trjava.trips.chekun.domain.specification.TripSpecification;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface TripService {

    void saveTrip(final Trip trip) throws TripServiceException;

    void deleteTrip(final Trip trip) throws TripServiceException;

    void updateTrip(final Trip trip) throws TripServiceException;

    List<Trip> query(final TripSpecification tripSpecification) throws TripServiceException;

    List<Trip> sort(final Comparator<Trip> comparator) throws TripServiceException;

    void clearRepository() throws TripServiceException;

    //----------------------
    Trip createTrip(final String values) throws TripServiceException;

}
