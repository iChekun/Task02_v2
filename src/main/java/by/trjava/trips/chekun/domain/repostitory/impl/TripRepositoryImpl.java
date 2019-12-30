package by.trjava.trips.chekun.domain.repostitory.impl;

import by.trjava.trips.chekun.dao.factory.DAOFactory;
import by.trjava.trips.chekun.dao.TripDAO;
import by.trjava.trips.chekun.dao.exception.*;
import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.repostitory.TripRepository;
import by.trjava.trips.chekun.domain.repostitory.exception.RepositoryException;
import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;
import by.trjava.trips.chekun.domain.specification.TripSpecification;
import by.trjava.trips.chekun.domain.specification.impl.TripSpecificationGetAllTrips;
import by.trjava.trips.chekun.domain.util.UtilFactory;
import by.trjava.trips.chekun.domain.util.creator.TripCreator;

import by.trjava.trips.chekun.domain.util.exception.WrongTripArgumentsUtilException;

import java.util.*;


public class TripRepositoryImpl implements TripRepository {

    private final DAOFactory daoFactory = DAOFactory.getInstance();
    private final TripDAO tripDAO = daoFactory.getTripDAO();

    private final UtilFactory utilFactory = UtilFactory.getInstance();
    private final TripCreator creator = utilFactory.getTripCreatorImpl();


    @Override
    public void saveTrip(final Trip trip) throws RepositoryException {
        try {
            tripDAO.saveTrip(trip.toString());
        } catch (NoDataStorageDAOException | WriteDAOException e) {
            throw new RepositoryException("Repository catch exception: " + e.getMessage());
        }
    }

    @Override
    public void deleteTrip(final Trip trip) throws RepositoryException {
        try {
            tripDAO.deleteTrip(trip.toString());
        } catch (DAOException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public void updateTrip(final Trip trip) throws RepositoryException {
        final int id = trip.getId();
        try {
            tripDAO.updateTrip(id, trip.toString());
        } catch (DAOException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    @Override
    public List query(final TripSpecification tripSpecification) throws RepositoryException {
        try {
            final List<String> tripsParameters = tripDAO.query(tripSpecification);
            final List<Trip> tripList = new ArrayList<>(tripsParameters.size());
            getCreatedTrips(tripList, tripsParameters);
            return tripList;
        } catch (NoDataStorageDAOException | ReadDAOException e) {
            throw new RepositoryException("Repository can`t do query cause : " + e.getMessage());
        }
    }

    private void getCreatedTrips(final List<Trip> tripList,
                                 final List<String> tripsParameters) {
        for (String tripParameters : tripsParameters) {
            try {
                final Trip trip = creator.create(tripParameters);
                tripList.add(trip);
            } catch (WrongTripArgumentsUtilException ignore) {/*NOP*/}
        }
    }


    @Override
    public List sort(final Comparator comparator) throws RepositoryException {
        try {
            final AbstractTripSpecification getAll = new TripSpecificationGetAllTrips();
            final List<String> tripsParameters = tripDAO.query(getAll);
            final List<Trip> tripList = new ArrayList<>(tripsParameters.size());

            getCreatedTrips(tripList, tripsParameters);
            tripList.sort(comparator);

            return tripList;

        } catch (NoDataStorageDAOException | ReadDAOException e) {
            throw new RepositoryException(e.getMessage());
        }
    }


    @Override
    public void clear() throws RepositoryException {
        try {
            tripDAO.clear();
        } catch (DAOStorageException e) {
            throw new RepositoryException(e.getMessage());
        }
    }
}
