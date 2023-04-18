import org.apache.commons.math3.distribution.NormalDistribution;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        /*ContinuousDistribution exp = new ExponentialDistr(System.currentTimeMillis(), 10);
        for (int i = 0; i < 10; i++) {
            System.out.println(exp.sample());
        }*/

      /*  PrometheusUtils.initPrometheus();



        Thread t = new Thread(new Uniform());
        t.start();
*/
        NormalDistribution exp = new NormalDistribution(0.5, 0.15);

        for (int i = 0; i < 100; i++) {
            double s  = exp.sample();
            System.out.println( s);
        }

      /*  double trans = (1.0/8.0)*(s+4);
        System.out.println(trans);*/

    }



}



 class Uniform implements Runnable {

    @Override
    public void run() {

        ContinuousDistribution exp = new LognormalDistr(new Random(System.currentTimeMillis()), 0.5, 1);

        while(true) {
            double s = exp.sample();
            PrometheusUtils.sample.setSample(s);
            System.out.println(s);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}



class NormalFraction implements Runnable {

    @Override
    public void run() {

        NormalDistribution exp = new NormalDistribution(0, 1);
        exp.getSupportLowerBound();

        while(true) {
            double s = exp.sample();
            PrometheusUtils.sample.setSample(s);
            System.out.println(s);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
