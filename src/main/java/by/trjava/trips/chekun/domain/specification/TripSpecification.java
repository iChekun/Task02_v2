package by.trjava.trips.chekun.domain.specification;


public interface TripSpecification {

    /**
     * Check if {@code t} is satisfied by the specification.
     *
     * @param string String to test.
     * @return {@code true} if {@code t} satisfies the specification.
     * @throws ClassCastException Thrown if o can not be cast to expected type.
     */
    boolean isSatisfiedBy(String string);


    /**
     * Create a new specification that is the AND operation of {@code this} specification and another specification.
     *
     * @param tripSpecification Specification to AND.
     * @return A new specification.
     */
    TripSpecification and(TripSpecification tripSpecification);

    /**
     * Create a new specification that is the OR operation of {@code this} specification and another specification.
     *
     * @param tripSpecification Specification to OR.
     * @return A new specification.
     */
    TripSpecification or(TripSpecification tripSpecification);

    /**
     * Create a new specification that is the NOT operation of {@code this} specification.
     *
     * @param tripSpecification Specification to NOT.
     * @return A new specification.
     */
    TripSpecification not(TripSpecification tripSpecification);

}
