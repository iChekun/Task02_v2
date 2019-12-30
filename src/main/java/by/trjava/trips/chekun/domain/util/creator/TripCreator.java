package by.trjava.trips.chekun.domain.util.creator;

import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.util.exception.WrongTripArgumentsUtilException;

/**
 * Using for creating new Trips.
 */
public interface TripCreator {
    /**
     *
     * @param values {@code String} Trip parameters
     * @return {@code Trip} if all parameters correct.
     * @throws WrongTripArgumentsUtilException throws if {@code values} are not valid
     */
    public Trip create(String values) throws WrongTripArgumentsUtilException;

}
