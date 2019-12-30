package by.trjava.trips.chekun.domain.util.validator.command.impl;

import java.util.Arrays;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.*;

public class CruiseTripValidatorCommand implements by.trjava.trips.chekun.domain.util.validator.command.TripValidatorCommand {

    @Override
    public boolean validate(final String[] values) {
        boolean result = false;

        if (values.length == CRUISE_TRIP_ARGUMENTS_COUNT) {
            TripValidatorCommand tripValidatorCommand = new TripValidatorCommand();

            result =   tripValidatorCommand.validate(values)
                    && isShipNameCorrect(values[SHIP_NAME])
                    && isDailyTipsCorrect(values[DAILY_TIPS])
                    && isNumberOfPortsToVisitCorrect(values[NUMBER_OF_PORTS_TO_VISIT])
                    && isCruiseTypeCorrect(values[CRUISE_TYPE]);
        }
        return result;
    }

    private boolean isShipNameCorrect(final String value) {
        return Arrays.stream(CRUISE_TRIP_SHIP_NAMES).anyMatch(s -> s.equalsIgnoreCase(value));
    }

    private boolean isDailyTipsCorrect(final String value) {
        try {
            final double daileTips = Double.parseDouble(value);
            return       daileTips >= getMinDailyTips()
                    &&   daileTips <= getMaxDailyTips();
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean isNumberOfPortsToVisitCorrect(final String value) {
        try {
            final int  numberOfPortsToVisit = Integer.parseInt(value);
            return     numberOfPortsToVisit >= getMinNumberPortsToVisit()
                    && numberOfPortsToVisit <= getMaxNumberPortsToVisit();
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean isCruiseTypeCorrect(final String value) {
        return Arrays.stream(CRUISE_TRIP_TYPES).anyMatch(s -> s.equalsIgnoreCase(value));
    }
}
