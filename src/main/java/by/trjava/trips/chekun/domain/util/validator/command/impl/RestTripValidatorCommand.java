package by.trjava.trips.chekun.domain.util.validator.command.impl;

import java.util.Arrays;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.*;

public class RestTripValidatorCommand implements by.trjava.trips.chekun.domain.util.validator.command.TripValidatorCommand {

    @Override
    public boolean validate(final String[] values) {
        boolean result = false;

        if (values.length == REST_TRIP_ARGUMENTS_COUNT) {
            TripValidatorCommand tripValidatorCommand = new TripValidatorCommand();

            result =   tripValidatorCommand.validate(values)
                    && isHotelNameCorrect(values[HOTEL_NAME])
                    && isHotelLevelCorrect(values[HOTEL_LEVEL]);
        }
        return result;
    }

    private boolean isHotelNameCorrect(final String value) {
        return Arrays.stream(REST_TRIP_HOTELS_NAMES).anyMatch(s -> s.equalsIgnoreCase(value));
    }

    private boolean isHotelLevelCorrect(final String value) {
        try {
            final int  hotelLevel = Integer.parseInt(value);
            return     hotelLevel >= getMinHotelLevel()
                    && hotelLevel <= getMaxHotelLevel();
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
