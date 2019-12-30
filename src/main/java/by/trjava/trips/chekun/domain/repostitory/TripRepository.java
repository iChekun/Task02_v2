package by.trjava.trips.chekun.domain.repostitory;

import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.repostitory.exception.RepositoryException;
import by.trjava.trips.chekun.domain.specification.TripSpecification;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;


public interface TripRepository<T extends Trip> {

    void saveTrip(T t) throws RepositoryException;

    void deleteTrip(T t) throws RepositoryException;

    void updateTrip(T t) throws RepositoryException;

    List<T> query(final TripSpecification tripSpecification) throws RepositoryException;

    List<T> sort(Comparator<T> comparator) throws RepositoryException;

    void clear() throws RepositoryException;

}
