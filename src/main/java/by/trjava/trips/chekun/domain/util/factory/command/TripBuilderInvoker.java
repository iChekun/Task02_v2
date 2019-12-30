package by.trjava.trips.chekun.domain.util.factory.command;

public class TripBuilderInvoker implements TripBuildingCommand {

    private TripBuildingCommand tripBuildingCommand;

    public TripBuilderInvoker(final TripBuildingCommand tripBuildingCommand) {
        this.tripBuildingCommand = tripBuildingCommand;
    }

    @Override
    public void execute(final String[] parameters) {
        this.tripBuildingCommand.execute(parameters);
    }
}
