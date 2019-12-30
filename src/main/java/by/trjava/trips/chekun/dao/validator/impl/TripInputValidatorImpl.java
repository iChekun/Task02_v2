package by.trjava.trips.chekun.dao.validator.impl;

import by.trjava.trips.chekun.dao.validator.TripInputValidator;
import by.trjava.trips.chekun.domain.entity.fields.TripField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.TRIP_TYPE_POSITION;
import static by.trjava.trips.chekun.domain.util.parser.Parser.parseStringIntoArgsArray;

public class TripInputValidatorImpl implements TripInputValidator {

    private static final Logger logger = LogManager.getLogger(TripInputValidatorImpl.class);


    public boolean validate(final String line) {
        logger.debug("Validation started. Received line: " + line);
        boolean result = false;

        if (line != null && !line.equals(" ")) {

            final String[] parameters = parseStringIntoArgsArray(line);
            final Class<? extends Enum<?>> enumWithFieldsOfTrip = TripField.getEnumWithTripFields(parameters[TRIP_TYPE_POSITION]);

            if (enumWithFieldsOfTrip != null) {
                final String[] expectedValues = Arrays.stream(enumWithFieldsOfTrip.getEnumConstants())
                                                                                        .map(Enum::name)
                                                                                        .toArray(String[]::new);
                result = isArgsCorrect(parameters, expectedValues);
            }
        }

        logger.debug("Final result: Is line correct? ->  " + result);
        return result;
    }


    private boolean isArgsCorrect(final String[] parameters, final String[] expected) {

        int matchCounter = 0;
        boolean result = false;

        for (final String value : parameters) {
            for (final String expectedValue : expected) {
                if (value.equalsIgnoreCase(expectedValue)) {
                    matchCounter++;
                    break;
                }
            }
        }

        if (matchCounter == expected.length) {
            result = true;
        }

        return result;
    }


}
