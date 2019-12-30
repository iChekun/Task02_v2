package by.trjava.trips.chekun.domain.util.validator.command.impl;

import java.util.Arrays;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.*;

public class ExcursionTripValidatorCommand implements by.trjava.trips.chekun.domain.util.validator.command.TripValidatorCommand {

    @Override
    public boolean validate(final String[] values) {
        boolean result = false;

        if (values.length == EXCURSION_TRIP_ARGUMENTS_COUNT) {
            TripValidatorCommand tripValidatorCommand = new TripValidatorCommand();

            result =   tripValidatorCommand.validate(values)
                    && isCountOfExcursionsCorrect(values[COUNT_OF_EXCURSIONS])
                    && isExcursionPlaceNameCorrect(values[EXCURSION_PLACE_NAME]);

        }
        return result;
    }

    private boolean isExcursionPlaceNameCorrect(final String value) {
        return Arrays.stream(EXCURSION_TRIP_PLACE_NAMES).anyMatch(s -> s.equalsIgnoreCase(value));
    }

    private boolean isCountOfExcursionsCorrect(final String value) {
        try {
            final int  countOfExcursions = Integer.parseInt(value);
            return     countOfExcursions >= getMinCountOfExcursions()
                    && countOfExcursions <= getMaxCountOfExcursions();
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
