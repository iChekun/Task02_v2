package by.trjava.trips.chekun.domain.util.factory.impl;

import by.trjava.trips.chekun.domain.entity.MedicalTrip;
import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.util.factory.TripFactory;
import by.trjava.trips.chekun.domain.util.factory.command.TripBuilderInvoker;
import by.trjava.trips.chekun.domain.util.factory.command.TripBuildingCommand;
import by.trjava.trips.chekun.domain.util.factory.command.impl.BuildMedicalTrip;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.*;

public class MedicalTripFactory implements TripFactory {


    @Override
    public Trip createTrip(final String[] parameters) {

        final MedicalTrip medicalTrip = new MedicalTrip();

        TripBuildingCommand buildingCommand = new BuildMedicalTrip(medicalTrip);
        TripBuildingCommand executeCommand = new TripBuilderInvoker(buildingCommand);
        executeCommand.execute(parameters);

        return medicalTrip;
    }
}
