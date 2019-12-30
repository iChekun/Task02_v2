package by.trjava.trips.chekun.domain.util.factory.impl;

import by.trjava.trips.chekun.domain.entity.ExcursionTrip;
import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.util.factory.TripFactory;
import by.trjava.trips.chekun.domain.util.factory.command.TripBuilderInvoker;
import by.trjava.trips.chekun.domain.util.factory.command.TripBuildingCommand;
import by.trjava.trips.chekun.domain.util.factory.command.impl.BuildExcursionTrip;
import by.trjava.trips.chekun.domain.util.factory.command.impl.BuildMedicalTrip;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.*;

public class ExcursionTripFactory implements TripFactory {


    @Override
    public Trip createTrip(final String[] parameters) {

        final ExcursionTrip excursionTrip = new ExcursionTrip();

        TripBuildingCommand buildingCommand = new BuildExcursionTrip(excursionTrip);
        TripBuildingCommand executeCommand = new TripBuilderInvoker(buildingCommand);
        executeCommand.execute(parameters);

        return excursionTrip;
    }
}


