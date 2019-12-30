package by.trjava.trips.chekun.domain.specification.impl;

import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.COST;
import static by.trjava.trips.chekun.domain.util.parser.Parser.parseStringIntoArgsArray;

public class TripSpecificationByCostRange extends AbstractTripSpecification {

    private double startRange;
    private double endRange;

    public TripSpecificationByCostRange(final double startRange, final double endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    @Override
    public boolean isSatisfiedBy(final String string) {
        final double cost = checkDouble(string);
        return cost != -1
                && cost >= startRange
                && cost <= endRange;
    }


    private double checkDouble(final String string) {
        double result = -1;

        try {
            final String[] values = parseStringIntoArgsArray(string);
            result = Double.parseDouble(values[COST]);
        } catch (Exception ignore) {
            /*NOP*/
        }
        return result;
    }

}
