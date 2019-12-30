package by.trjava.trips.chekun.domain.util.factory.command.impl;

import by.trjava.trips.chekun.domain.entity.Trip;
import by.trjava.trips.chekun.domain.util.factory.command.TripBuildingCommand;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.*;

/**
 * Package level class.
 * Encapsulated the common of all trips
 */
class BuildTrip implements TripBuildingCommand {

    private Trip trip;

    BuildTrip(final Trip trip) {
        this.trip = trip;
    }

    @Override
    public void execute(final String[] parameters) {
        trip.setId(Integer.parseInt(parameters[ID_POSITION]));
        trip.setTransportType(parameters[TRANSPORT_TYPE]);
        trip.setTripLocation(parameters[TRIP_LOCATION]);
        trip.setTypeOfFood(parameters[TYPE_OF_FOOD]);
        trip.setDayCount(Integer.parseInt(parameters[DAY_COUNT]));
        trip.setCost(Double.parseDouble(parameters[COST]));
    }
}
