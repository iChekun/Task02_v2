package by.trjava.trips.chekun.domain.util.validator;

import by.trjava.trips.chekun.domain.configuration.TripConfiguration;

/**
 * Use to validate trips.
 */
public interface TripValidator {
    /**
     * @param tripParameters {@code String} trip parameters
     * @return true -> if parameters is valid
     * false -> otherwise
     * @see TripConfiguration
     */
    boolean validate(final String tripParameters);

}
