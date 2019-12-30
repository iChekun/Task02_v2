package by.trjava.trips.chekun.domain.service;

import by.trjava.trips.chekun.domain.service.impl.TripServiceImpl;
import by.trjava.trips.chekun.domain.service.impl.TripConfigurationServiceImpl;


public final class ServiceFactory {

    private static ServiceFactory instance = new ServiceFactory();

    private ServiceFactory() {
    }

    private TripService tripService = new TripServiceImpl();

    private TripConfigurationServiceImpl tripConfigurationServiceImpl = new TripConfigurationServiceImpl();

    public TripService getTripService() {
        return tripService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public TripConfigurationService getTripConfigurationServiceImpl() {
        return tripConfigurationServiceImpl;
    }
}
