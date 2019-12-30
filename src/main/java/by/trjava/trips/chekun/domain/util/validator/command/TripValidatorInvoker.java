package by.trjava.trips.chekun.domain.util.validator.command;


public class TripValidatorInvoker implements TripValidatorCommand {

    private TripValidatorCommand tripValidatorCommand;

    public TripValidatorInvoker(final TripValidatorCommand tripValidatorCommand) {
        this.tripValidatorCommand = tripValidatorCommand;
    }

    @Override
    public boolean validate(final String[] values) {
        return tripValidatorCommand.validate(values);
    }
}
