package by.trjava.trips.chekun.domain.util.factory.command.impl;

import by.trjava.trips.chekun.domain.entity.RestTrip;
import by.trjava.trips.chekun.domain.util.factory.command.TripBuildingCommand;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.*;
import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.HOTEL_LEVEL;

public class BuildRestTrip implements TripBuildingCommand {

    private RestTrip restTrip;

    public BuildRestTrip(final RestTrip restTrip) {
        this.restTrip = restTrip;
    }

    @Override
    public void execute(final String[] parameters) {
        BuildTrip buildTrip = new BuildTrip(restTrip);
        buildTrip.execute(parameters);
//        restTrip.setId(Integer.parseInt(parameters[ID_POSITION]));
//        restTrip.setTransportType(parameters[TRANSPORT_TYPE]);
//        restTrip.setTripLocation(parameters[TRIP_LOCATION]);
//        restTrip.setDayCount(Integer.parseInt(parameters[DAY_COUNT]));
//        restTrip.setCost(Double.parseDouble(parameters[COST]));

        restTrip.setHotelName(parameters[HOTEL_NAME]);
        restTrip.setHotelLevel(Integer.parseInt(parameters[HOTEL_LEVEL]));
    }
}
