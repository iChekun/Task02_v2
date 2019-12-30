package by.trjava.trips.chekun.domain.util.factory;

import by.trjava.trips.chekun.domain.entity.Trip;

/**
 * Base interface for creating Trips.
 *
 * @see Trip
 * @see by.trjava.trips.chekun.domain.util.idfinder.FreeIdFinder
 */
public interface TripFactory {
    /**
     * @param parameters {@code String} parameters of new Trip
     * @return {@code Trip} or any it implementation
     */
    Trip createTrip(final String[] parameters);
}
