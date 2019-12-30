package by.trjava.trips.chekun.domain.util.validator.impl;

import by.trjava.trips.chekun.domain.entity.type.TripType;

import by.trjava.trips.chekun.domain.util.validator.TripValidator;
import by.trjava.trips.chekun.domain.util.validator.command.TripValidatorCommand;
import by.trjava.trips.chekun.domain.util.validator.command.TripValidatorInvoker;
import by.trjava.trips.chekun.domain.util.validator.command.factory.TripValidatorCommandFactory;

import java.util.Arrays;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.TRIP_TYPE_POSITION;
import static by.trjava.trips.chekun.domain.util.parser.Parser.parseStringIntoArgsArray;

public class TripValidatorImpl implements TripValidator {


    @Override
    public boolean validate(final String tripParameters) {
        boolean result = false;

        if (tripParameters != null && tripParameters.length() > 1) {

            final String[] tripValues = parseStringIntoArgsArray(tripParameters);

            if (isTripTypeCorrect(tripValues[TRIP_TYPE_POSITION])) {

                final TripType tripType = TripType.valueOf(tripValues[TRIP_TYPE_POSITION]);

                final TripValidatorCommandFactory tripValidatorCommandFactory = TripValidatorCommandFactory.getInstance();

                final TripValidatorCommand tripValidatorCommand = tripValidatorCommandFactory.create(tripType);

                final TripValidatorInvoker executor = new TripValidatorInvoker(tripValidatorCommand);

                result = executor.validate(tripValues);
            }
        }

        return result;
    }

    private boolean isTripTypeCorrect(final String type) {
        return Arrays.toString(TripType.values()).contains(type.trim());
    }
}
