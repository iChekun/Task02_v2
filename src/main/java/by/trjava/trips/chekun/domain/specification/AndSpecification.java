package by.trjava.trips.chekun.domain.specification;

public class AndSpecification extends AbstractTripSpecification {

    private TripSpecification firstSpec;
    private TripSpecification secondSpec;

    public AndSpecification(final TripSpecification firstSpec, final TripSpecification secondSpec) {
        this.firstSpec = firstSpec;
        this.secondSpec = secondSpec;
    }

    @Override
    public boolean isSatisfiedBy(String string) {
        return firstSpec.isSatisfiedBy(string) && secondSpec.isSatisfiedBy(string);
    }
}
