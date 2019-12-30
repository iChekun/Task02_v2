package by.trjava.trips.chekun.dao.factory;

import by.trjava.trips.chekun.dao.TripDAO;
import by.trjava.trips.chekun.dao.impl.FileTripDAOImpl;


public final class DAOFactory {

    private static DAOFactory instance = new DAOFactory();

    private DAOFactory() {
    }

    private TripDAO tripDAO = new FileTripDAOImpl();

    public TripDAO getTripDAO() {
        return tripDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
