package by.trjava.trips.chekun.domain.service.impl;

import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.repostitory.factory.RepositoryFactory;
import by.trjava.trips.chekun.domain.repostitory.TripRepository;
import by.trjava.trips.chekun.domain.repostitory.exception.RepositoryException;
import by.trjava.trips.chekun.domain.service.exception.TripServiceException;
import by.trjava.trips.chekun.domain.specification.TripSpecification;
import by.trjava.trips.chekun.domain.util.UtilFactory;
import by.trjava.trips.chekun.domain.util.creator.TripCreator;
import by.trjava.trips.chekun.domain.service.TripService;
import by.trjava.trips.chekun.domain.util.exception.WrongTripArgumentsUtilException;
import by.trjava.trips.chekun.domain.util.validator.TripValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;

public class TripServiceImpl implements TripService {
    private static final Logger logger = LogManager.getLogger(TripServiceImpl.class);

    private final RepositoryFactory repositoryFactory = RepositoryFactory.getInstance();
    private final TripRepository repository = repositoryFactory.getTripRepository();

    private final UtilFactory utilFactory = UtilFactory.getInstance();
    private final TripCreator tripCreatorImpl = utilFactory.getTripCreatorImpl();
    private final TripValidator validator = utilFactory.getTripValidator();


    @Override
    public void saveTrip(final Trip trip) throws TripServiceException {
        if (trip != null && validator.validate(trip.toString())) {
            logger.debug("Save trip: " + trip);
            try {
                repository.saveTrip(trip);
            } catch (RepositoryException e) {
                throw new TripServiceException("Can`t saveTrip trip cause repository is not available :  " + e.getMessage());
            }
        } else {
            logger.debug("Can`t saveTrip trip cause it not valid");
            throw new TripServiceException("Can`t saveTrip trip cause it not valid!");
        }
    }


    @Override
    public void deleteTrip(final Trip trip) throws TripServiceException {
        if (trip != null) {
            logger.debug("Delete trip: " + trip);
            try {
                repository.deleteTrip(trip);
            } catch (RepositoryException e) {
                logger.debug("Cant deleteTrip trip! " + e.getMessage());
                throw new TripServiceException("Cant deleteTrip trip! " + e.getMessage());
            }
        } else {
            logger.debug("Received trip is null!");
            throw new TripServiceException("Received trip is null!");
        }
    }

    @Override
    public void updateTrip(final Trip trip) throws TripServiceException {
        logger.debug("Updated trip");
        if (trip != null && validator.validate(trip.toString())) {
            try {
                repository.updateTrip(trip);
            } catch (RepositoryException e) {
                logger.debug(e.getMessage());
                throw new TripServiceException(e.getMessage());
            }
        } else {
            logger.debug("Can`t updateTrip trip! Input data is not valid! Try again");
            throw new TripServiceException("Can`t updateTrip trip! Input data is not valid! Try again!");
        }
    }


    @Override
    public Trip createTrip(final String values) throws TripServiceException {
        logger.debug("Start creating trip with values: " + values);
        try {
            final Trip trip;
            trip = tripCreatorImpl.create(values);
            logger.debug("Trip has created: " + trip);
            return trip;
        } catch (WrongTripArgumentsUtilException e) {
            logger.debug("Can`t createTrip new trip: " + e.getMessage());
            throw new TripServiceException("Can`t createTrip new trip: " + e.getMessage());
        }
    }

    @Override
    public List<Trip> query(final TripSpecification tripSpecification) throws TripServiceException {
        if (tripSpecification != null) {
        logger.debug("Start query wih spec: " + tripSpecification.getClass().getSimpleName());
            try {
                List<Trip> trips = repository.query(tripSpecification);
                return trips;
            } catch (RepositoryException e) {
                logger.debug("Query mistake! Problem: " + e.getMessage());
                throw new TripServiceException("Query mistake! Problem: " + e.getMessage());
            }
        }
        logger.debug("Received tripSpecification is bad!");
        throw new TripServiceException("Received tripSpecification is bad!");
    }


    @Override
    public List<Trip> sort(final Comparator<Trip> comparator) throws TripServiceException {
        logger.debug("Sort has started");

        if (comparator != null) {
            try {
                final List<Trip> tripCollection = repository.sort(comparator);
                return tripCollection;
            } catch (RepositoryException e) {
                logger.debug("Repository problems:  " + e.getMessage());
                throw new TripServiceException("Repository problems:  " + e.getMessage());
            }

        } else {
            logger.debug("Trip service received bad comparator!");
            throw new TripServiceException("Trip service received bad comparator!");
        }
    }

    @Override
    public void clearRepository() throws TripServiceException {
        logger.debug("Clearing repository has started");
        try {
            repository.clear();
        } catch (RepositoryException e) {
            logger.debug("Can`t clean repository: " + e.getMessage());
            throw new TripServiceException("Can`t clean repository: " + e.getMessage());
        }
    }
}
