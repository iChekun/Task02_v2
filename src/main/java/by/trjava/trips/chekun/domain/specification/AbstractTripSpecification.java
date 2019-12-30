package by.trjava.trips.chekun.domain.specification;

public abstract class AbstractTripSpecification implements TripSpecification {

    @Override
    public abstract boolean isSatisfiedBy(String string);

    @Override
    public TripSpecification and(final TripSpecification tripSpecification) {
        return new AndSpecification(this, tripSpecification);
    }

    @Override
    public TripSpecification or(final TripSpecification tripSpecification) {
        return new OrSpecification(this, tripSpecification);
    }

    @Override
    public TripSpecification not(TripSpecification tripSpecification) {
        return new NotSpecification(tripSpecification);
    }
}
