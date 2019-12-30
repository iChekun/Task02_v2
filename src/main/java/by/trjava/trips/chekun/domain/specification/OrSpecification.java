package by.trjava.trips.chekun.domain.specification;

public class OrSpecification extends AbstractTripSpecification {


    private TripSpecification firstSpec;
    private TripSpecification secondSpec;

    /**
     * Create a new OR specification based on two other spec.
     *
     * @param firstSpec  Specification one.
     * @param secondSpec Specification two.
     */
    public OrSpecification(final TripSpecification firstSpec, final TripSpecification secondSpec) {
        this.firstSpec = firstSpec;
        this.secondSpec = secondSpec;
    }

    @Override
    public boolean isSatisfiedBy(final String string) {
        return firstSpec.isSatisfiedBy(string) || secondSpec.isSatisfiedBy(string);
    }
}
