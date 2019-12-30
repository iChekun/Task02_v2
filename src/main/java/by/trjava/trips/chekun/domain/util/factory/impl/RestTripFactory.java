package by.trjava.trips.chekun.domain.util.factory.impl;

import by.trjava.trips.chekun.domain.entity.RestTrip;
import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.util.factory.TripFactory;
import by.trjava.trips.chekun.domain.util.factory.command.TripBuilderInvoker;
import by.trjava.trips.chekun.domain.util.factory.command.TripBuildingCommand;
import by.trjava.trips.chekun.domain.util.factory.command.impl.BuildRestTrip;

public class RestTripFactory implements TripFactory {

    @Override
    public Trip createTrip(final String[] parameters) {

        final RestTrip restTrip = new RestTrip();

        TripBuildingCommand buildingCommand = new BuildRestTrip(restTrip);
        TripBuildingCommand executeCommand = new TripBuilderInvoker(buildingCommand);
        executeCommand.execute(parameters);

        return restTrip;
    }
}
