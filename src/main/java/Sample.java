


public class Sample {
    public Sample(double sample) {
        this.sample = sample;
    }

    double sample;

    public double getSample() {
        return sample;
    }

    public void setSample(double sample) {
        this.sample = sample;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "sample=" + sample +
                '}';
    }
}
