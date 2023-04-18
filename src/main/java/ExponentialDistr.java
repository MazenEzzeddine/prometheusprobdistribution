import org.apache.commons.math3.distribution.ExponentialDistribution;


public class ExponentialDistr implements ContinuousDistribution {

    /** The internal exponential number generator. */
    private final ExponentialDistribution numGen;


    /**
     * Creates a new exponential pseudo random number generator.
     *
     * @param seed the seed to be used.
     * @param mean the mean for the distribution.
     */
    public ExponentialDistr(long seed, double mean) {
        this(mean);
        numGen.reseedRandomGenerator(seed);
    }

    /**
     * Creates a new exponential pseudo random number generator.
     *
     * @param mean the mean for the distribution.
     */
    public ExponentialDistr(double mean) {
        numGen = new ExponentialDistribution(mean);
    }

    @Override
    public double sample() {
        return numGen.sample();
    }

}