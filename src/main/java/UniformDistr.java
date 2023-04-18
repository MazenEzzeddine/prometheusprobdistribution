import org.apache.commons.math3.distribution.UniformRealDistribution;

import java.util.Random;


public class UniformDistr implements ContinuousDistribution {

    private final UniformRealDistribution numGen;


    public UniformDistr(double min, double max) {
        numGen = new UniformRealDistribution(min, max);
    }


    public UniformDistr(double min, double max, long seed) {
        this(min, max);
        numGen.reseedRandomGenerator(seed);
    }

    @Override
    public double sample() {
        return numGen.sample();
    }


    public static double sample(Random rd, double min, double max) {
        if (min >= max) {
            throw new IllegalArgumentException("Maximum must be greater than the minimum.");
        }

        return (rd.nextDouble() * (max - min)) + min;
    }


    public void setSeed(long seed) {
        numGen.reseedRandomGenerator(seed);
    }

}
