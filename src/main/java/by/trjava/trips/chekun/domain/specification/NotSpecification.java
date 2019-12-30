package by.trjava.trips.chekun.domain.specification;

public class NotSpecification extends AbstractTripSpecification {

    private TripSpecification firstSpec;


    /**
     * Create a new NOT specification based on another spec.
     *
     * @param firstSpec Specification instance to not.
     */
    public NotSpecification(final TripSpecification firstSpec) {
        this.firstSpec = firstSpec;
    }

    @Override
    public boolean isSatisfiedBy(String string) {
        return !firstSpec.isSatisfiedBy(string);
    }
}
