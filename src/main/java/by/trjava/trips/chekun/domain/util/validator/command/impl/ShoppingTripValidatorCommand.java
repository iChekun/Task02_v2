package by.trjava.trips.chekun.domain.util.validator.command.impl;

import java.util.Arrays;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.*;

public class ShoppingTripValidatorCommand implements by.trjava.trips.chekun.domain.util.validator.command.TripValidatorCommand {

    @Override
    public boolean validate(final String[] values) {
        boolean result = false;

        if (values.length == SHOPPING_TRIP_ARGUMENTS_COUNT) {
            TripValidatorCommand tripValidatorCommand = new TripValidatorCommand();

            result =   tripValidatorCommand.validate(values)
                    && isShopCentreNameCorrect(values[SHOP_CENTRE_NAME])
                    && isBaggageWeightLimitCorrect(values[BAGGAGE_WEIGHT_LIMIT]);
        }
        return result;
    }


    private boolean isShopCentreNameCorrect(final String value) {
        return Arrays.stream(SHOPPING_TRIP_CENTRE_NAMES).anyMatch(s -> s.equalsIgnoreCase(value));
    }

    private boolean isBaggageWeightLimitCorrect(final String value) {
        try {
            final double baggageWeight = Double.parseDouble(value);
            return       baggageWeight <= getMaxBaggageWeight();
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
