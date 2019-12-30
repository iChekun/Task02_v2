package by.trjava.trips.chekun.domain.comparator;

import by.trjava.trips.chekun.domain.entity.Trip;

import java.util.Comparator;

public class TripComparatorByCost implements Comparator<Trip> {

    @Override
    public int compare(Trip o1, Trip o2) {
        return Double.compare(o1.getCost(), o2.getCost());
    }
}
