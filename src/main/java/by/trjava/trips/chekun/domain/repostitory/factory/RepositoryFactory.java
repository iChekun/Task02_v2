package by.trjava.trips.chekun.domain.repostitory.factory;

import by.trjava.trips.chekun.domain.repostitory.TripRepository;
import by.trjava.trips.chekun.domain.repostitory.impl.*;


public final class RepositoryFactory {

    private static RepositoryFactory instance = new RepositoryFactory();

    private RepositoryFactory() { }

    private TripRepository tripRepository = new TripRepositoryImpl();

    public TripRepository getTripRepository() {
        return tripRepository;
    }

    public static RepositoryFactory getInstance() {
        return instance;
    }
}
