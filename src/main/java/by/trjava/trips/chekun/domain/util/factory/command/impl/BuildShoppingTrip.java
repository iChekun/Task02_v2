package by.trjava.trips.chekun.domain.util.factory.command.impl;

import by.trjava.trips.chekun.domain.entity.ShoppingTrip;
import by.trjava.trips.chekun.domain.util.factory.command.TripBuildingCommand;

import static by.trjava.trips.chekun.domain.configuration.TripConfiguration.*;


public class BuildShoppingTrip implements TripBuildingCommand {

    private ShoppingTrip shoppingTrip;

    public BuildShoppingTrip(final ShoppingTrip shoppingTrip) {
        this.shoppingTrip = shoppingTrip;
    }

    @Override
    public void execute(final String[] parameters) {
        BuildTrip buildTrip = new BuildTrip(shoppingTrip);
        buildTrip.execute(parameters);

        shoppingTrip.setShopCentreName(parameters[SHOP_CENTRE_NAME]);
        shoppingTrip.setBaggageWeightLimit(Double.parseDouble(parameters[BAGGAGE_WEIGHT_LIMIT]));
    }
}