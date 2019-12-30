package by.trjava.trips.chekun.domain.util.factory.manager;

import by.trjava.trips.chekun.domain.entity.type.TripType;
import by.trjava.trips.chekun.domain.util.factory.TripFactory;

public interface FactoryManager {
    /**
     * @param tripType {@code TripType}
     * @return {@code TripFactory } implementation according with received tripType
     * @see TripFactory
     * @see TripType
     */
    TripFactory getFactory(final TripType tripType);

}
