package by.trjava.trips.chekun.domain.util.factory.impl;

import by.trjava.trips.chekun.domain.entity.CruiseTrip;
import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.util.factory.TripFactory;
import by.trjava.trips.chekun.domain.util.factory.command.TripBuilderInvoker;
import by.trjava.trips.chekun.domain.util.factory.command.TripBuildingCommand;
import by.trjava.trips.chekun.domain.util.factory.command.impl.BuildCruiseTrip;
import by.trjava.trips.chekun.domain.util.factory.command.impl.BuildRestTrip;

import java.util.Arrays;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.*;

public class CruiseTripFactory implements TripFactory {


    @Override
    public Trip createTrip(final String[] parameters) {

        final CruiseTrip cruiseTrip = new CruiseTrip();

        TripBuildingCommand buildingCommand = new BuildCruiseTrip(cruiseTrip);
        TripBuildingCommand executeCommand = new TripBuilderInvoker(buildingCommand);
        executeCommand.execute(parameters);

        return cruiseTrip;
    }
}
