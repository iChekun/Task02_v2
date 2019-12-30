package by.trjava.trips.chekun.domain.util.factory.command.impl;

import by.trjava.trips.chekun.domain.entity.ExcursionTrip;
import by.trjava.trips.chekun.domain.util.factory.command.TripBuildingCommand;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.COUNT_OF_EXCURSIONS;
import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.EXCURSION_PLACE_NAME;


public class BuildExcursionTrip implements TripBuildingCommand {

    private ExcursionTrip excursionTrip;

    public BuildExcursionTrip(final ExcursionTrip excursionTrip) {
        this.excursionTrip = excursionTrip;
    }

    @Override
    public void execute(final String[] parameters) {
        BuildTrip buildTrip = new BuildTrip(excursionTrip);
        buildTrip.execute(parameters);


        excursionTrip.setCountOfExcursions(Integer.parseInt(parameters[COUNT_OF_EXCURSIONS]));
        excursionTrip.setExcursionPlaceName(parameters[EXCURSION_PLACE_NAME]);
    }
}

