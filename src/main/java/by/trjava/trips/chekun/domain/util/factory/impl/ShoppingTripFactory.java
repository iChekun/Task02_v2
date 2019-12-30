package by.trjava.trips.chekun.domain.util.factory.impl;

import by.trjava.trips.chekun.domain.entity.ShoppingTrip;
import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.util.factory.TripFactory;
import by.trjava.trips.chekun.domain.util.factory.command.TripBuilderInvoker;
import by.trjava.trips.chekun.domain.util.factory.command.TripBuildingCommand;
import by.trjava.trips.chekun.domain.util.factory.command.impl.BuildExcursionTrip;
import by.trjava.trips.chekun.domain.util.factory.command.impl.BuildShoppingTrip;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.*;

public class ShoppingTripFactory implements TripFactory {


    @Override
    public Trip createTrip(final String[] parameters) {

        final ShoppingTrip shoppingTrip = new ShoppingTrip();

        TripBuildingCommand buildingCommand = new BuildShoppingTrip(shoppingTrip);
        TripBuildingCommand executeCommand = new TripBuilderInvoker(buildingCommand);
        executeCommand.execute(parameters);

        return shoppingTrip;
    }
}
