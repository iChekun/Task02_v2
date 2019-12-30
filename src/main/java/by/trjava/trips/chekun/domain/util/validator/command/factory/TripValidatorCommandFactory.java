package by.trjava.trips.chekun.domain.util.validator.command.factory;

import by.trjava.trips.chekun.domain.entity.type.TripType;
import by.trjava.trips.chekun.domain.util.validator.command.TripValidatorCommand;
import by.trjava.trips.chekun.domain.util.validator.command.impl.*;


public final class TripValidatorCommandFactory {

    private static TripValidatorCommandFactory INSTANCE = new TripValidatorCommandFactory();

    public static TripValidatorCommandFactory getInstance() {
        return INSTANCE;
    }

    private TripValidatorCommandFactory() {
    }


    public TripValidatorCommand create(final TripType tripType) {

        switch (tripType) {
            case RestTrip:
                return new RestTripValidatorCommand();
            case ShoppingTrip:
                return new ShoppingTripValidatorCommand();
            case CruiseTrip:
                return new CruiseTripValidatorCommand();
            case MedicalTrip:
                return new MedicalTripValidatorCommand();
            case ExcursionTrip:
                return new ExcursionTripValidatorCommand();

            default:
                return null; // this can't be because caller checking type before give
        }
    }
}
