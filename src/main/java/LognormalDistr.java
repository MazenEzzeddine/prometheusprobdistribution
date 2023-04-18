import java.util.Random;

import org.apache.commons.math3.distribution.LogNormalDistribution;

/**
 * A pseudo random number generator following the
 * <a href="https://en.wikipedia.org/wiki/Log-normal_distribution">Lognormal</a> distribution.
 *
 * @author Marcos Dias de Assuncao
 * @since CloudSim Toolkit 1.0
 */
public class LognormalDistr implements ContinuousDistribution {


    private final LogNormalDistribution numGen;



    public LognormalDistr(Random seed, double shape, double scale) {
        this(shape, scale);
        numGen.reseedRandomGenerator(seed.nextLong());
    }


    public LognormalDistr(double shape, double scale) {
        numGen = new LogNormalDistribution(scale, shape);
    }

    @Override
    public double sample() {
        return numGen.sample();
    }

}