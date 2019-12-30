package by.trjava.trips.chekun.dao;

import by.trjava.trips.chekun.dao.exception.*;

import by.trjava.trips.chekun.domain.specification.TripSpecification;


import java.util.List;

public interface TripDAO {

    void saveTrip(String trip) throws NoDataStorageDAOException, WriteDAOException;

    void deleteTrip(String trip) throws DAOException;

    void updateTrip(int id, String trip) throws DAOException;

    List<String> query(TripSpecification tripSpecification) throws NoDataStorageDAOException, ReadDAOException;

    void clear() throws DAOStorageException;
}
