package by.trjava.trips.chekun.domain.util.factory.command.impl;

import by.trjava.trips.chekun.domain.entity.CruiseTrip;
import by.trjava.trips.chekun.domain.util.factory.command.TripBuildingCommand;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.*;

public class BuildCruiseTrip implements TripBuildingCommand {

    private CruiseTrip cruiseTrip;

    public BuildCruiseTrip(final CruiseTrip cruiseTrip) {
        this.cruiseTrip = cruiseTrip;
    }

    @Override
    public void execute(final String[] parameters) {
        BuildTrip buildTrip = new BuildTrip(cruiseTrip);
        buildTrip.execute(parameters);
//        cruiseTrip.setId(Integer.parseInt(parameters[ID_POSITION]));
//        cruiseTrip.setTransportType(parameters[TRANSPORT_TYPE]);
//        cruiseTrip.setTripLocation(parameters[TRIP_LOCATION]);
//        cruiseTrip.setDayCount(Integer.parseInt(parameters[DAY_COUNT]));
//        cruiseTrip.setCost(Double.parseDouble(parameters[COST]));

        cruiseTrip.setShipName(parameters[SHIP_NAME]);
        cruiseTrip.setDailyTips(Double.parseDouble(parameters[DAILY_TIPS]));
        cruiseTrip.setNumberOfPortsToVisit(Integer.parseInt(parameters[NUMBER_OF_PORTS_TO_VISIT]));
        cruiseTrip.setCruiseType(parameters[CRUISE_TYPE]);
    }
}
