package by.trjava.trips.chekun.domain.util;

import by.trjava.trips.chekun.domain.util.creator.TripCreator;
import by.trjava.trips.chekun.domain.util.creator.impl.TripCreatorImpl;
import by.trjava.trips.chekun.domain.util.idfinder.FreeIdFinder;
import by.trjava.trips.chekun.domain.util.idfinder.impl.FreeIdFinderImpl;
import by.trjava.trips.chekun.domain.util.validator.TripValidator;
import by.trjava.trips.chekun.domain.util.validator.impl.TripValidatorImpl;

public final class UtilFactory {

    private static UtilFactory instance = new UtilFactory();

    private UtilFactory() {
    }

    private TripCreator tripCreatorImpl = new TripCreatorImpl();

    private FreeIdFinder freeIdFinder = new FreeIdFinderImpl();

    private TripValidator tripValidator = new TripValidatorImpl();

    public TripCreator getTripCreatorImpl() {
        return tripCreatorImpl;
    }

    public FreeIdFinder getFreeIdFinder() {
        return freeIdFinder;
    }

    public TripValidator getTripValidator() {
        return tripValidator;
    }


    public static UtilFactory getInstance() {
        return instance;
    }

}
