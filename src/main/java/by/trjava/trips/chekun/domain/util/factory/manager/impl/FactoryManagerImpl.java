package by.trjava.trips.chekun.domain.util.factory.manager.impl;

import by.trjava.trips.chekun.domain.entity.type.TripType;

import by.trjava.trips.chekun.domain.util.exception.WrongTripTypeUtilException;
import by.trjava.trips.chekun.domain.util.factory.*;
import by.trjava.trips.chekun.domain.util.factory.impl.*;
import by.trjava.trips.chekun.domain.util.factory.manager.FactoryManager;

public final class FactoryManagerImpl implements FactoryManager {

    private static FactoryManagerImpl instance = new FactoryManagerImpl();

    public static FactoryManagerImpl getInstance() { return instance; }

    private FactoryManagerImpl() { }

    @Override
    public TripFactory getFactory(final TripType tripType) {

        switch (tripType) {
            case RestTrip:
                return new RestTripFactory();
            case ShoppingTrip:
                return new ShoppingTripFactory();
            case CruiseTrip:
                return new CruiseTripFactory();
            case MedicalTrip:
                return new MedicalTripFactory();
            case ExcursionTrip:
                return new ExcursionTripFactory();

            default:
                return null; //that normal, because factory used in Creator and he will control this situation
        }
    }

}
