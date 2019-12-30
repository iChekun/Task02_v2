package by.trjava.trips.chekun.domain.util.validator.command.impl;

import java.util.Arrays;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.*;
import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.getMaxDayCount;

class TripValidatorCommand implements by.trjava.trips.chekun.domain.util.validator.command.TripValidatorCommand {

    @Override
    public boolean validate(final String[] values) {
        return     isTripIDCorrect(values[ID_POSITION])
                && isLocationCorrect(values[TRIP_LOCATION])
                && isTransportTypeCorrect(values[TRANSPORT_TYPE])
                && isTypeOfFoodCorrect(values[TYPE_OF_FOOD])
                && isTripDayCountCorrect(values[DAY_COUNT])
                && isTripCostCorrect(values[COST]);
    }

    private boolean isTripIDCorrect(final String value) {
        try {
            final int id = Integer.parseInt(value);
            return id > 0;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean isTransportTypeCorrect(final String value) {
        return Arrays.stream(TRIP_TRANSPORT_TYPES).anyMatch(s -> s.equalsIgnoreCase(value));
    }

    private boolean isTypeOfFoodCorrect(final String value) {
        return Arrays.stream(TRIP_TYPES_OF_FOOD).anyMatch(s -> s.equalsIgnoreCase(value));
    }

    private boolean isLocationCorrect(final String value) {
        return Arrays.stream(TRIP_LOCATIONS).anyMatch(s -> s.equalsIgnoreCase(value));
    }

    private boolean isTripCostCorrect(final String value) {
        try {
            final double cost = Double.parseDouble(value);
            return       cost >= getMinCost()
                    &&   cost <= getMaxCost();
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean isTripDayCountCorrect(final String value) {
        try {
            final int  dayCount = Integer.parseInt(value);
            return     dayCount >= getMinDayCount()
                    && dayCount <= getMaxDayCount();
        } catch (NumberFormatException ex) {
            return false;
        }
    }


}
