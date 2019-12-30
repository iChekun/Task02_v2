package by.trjava.trips.chekun.domain.specification.impl.shoppingtrip;

import by.trjava.trips.chekun.domain.entity.ShoppingTrip;
import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.entity.fields.TripField;
import by.trjava.trips.chekun.domain.entity.type.TripType;
import by.trjava.trips.chekun.domain.specification.AbstractTripSpecification;
import by.trjava.trips.chekun.domain.specification.TripSpecification;
import by.trjava.trips.chekun.domain.specification.criteria.Criteria;
import by.trjava.trips.chekun.domain.specification.criteria.InputLineValidator;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.BAGGAGE_WEIGHT_LIMIT;
import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.COST;
import static by.trjava.trips.chekun.domain.util.parser.Parser.parseStringIntoArgsArray;

public class ShoppingTripSpecificationByBaggageWeightRange extends AbstractTripSpecification {

    private double startRange;
    private double endRange;

    public ShoppingTripSpecificationByBaggageWeightRange(final double startRange, final double endRange) {
        this.startRange = startRange;
        this.endRange = endRange;
    }

    @Override
    public boolean isSatisfiedBy(final String string) {

        double baggageWeight = checkDouble(string);

        return baggageWeight != -1
                && baggageWeight >= startRange
                && baggageWeight <= endRange;
    }


    private double checkDouble(final String string) {
        double result = -1;

        try {
            final String[] values = parseStringIntoArgsArray(string);
            result = Double.parseDouble(values[BAGGAGE_WEIGHT_LIMIT]);
        } catch (Exception ignore) {
            /*NOP*/
        }
        return result;
    }

}