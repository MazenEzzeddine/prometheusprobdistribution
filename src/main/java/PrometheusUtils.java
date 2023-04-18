import com.sun.net.httpserver.HttpServer;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Timer;
import io.micrometer.prometheus.PrometheusConfig;
import io.micrometer.prometheus.PrometheusMeterRegistry;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class PrometheusUtils {
    public static PrometheusMeterRegistry prometheusRegistry;
    public static Sample sample;
    public static Gauge sampleGauge;
    //public static Timer timer;


    public static void initPrometheus() {
        prometheusRegistry = new PrometheusMeterRegistry(PrometheusConfig.DEFAULT);
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/prometheus", httpExchange -> {
                String response = prometheusRegistry.scrape();
                httpExchange.sendResponseHeaders(200, response.getBytes().length);
                try (OutputStream os = httpExchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            });
            new Thread(server::start).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }













        sample = new Sample(0.0);
        sampleGauge = Gauge.builder("sample",  sample, Sample::getSample).register(prometheusRegistry);//prometheusRegistry.gauge("timergauge" );

        //latencygauge = Gauge.builder("latencygauge",  latencygaugemeasure, TimeMeasure::getDuration).tag("child", "testtopic1").register(prometheusRegistry);
        //prometheusRegistry.gauge("timergauge" );

        /* timer = Timer
                .builder("event.time")
                .description("a description of what this timer does")
                .publishPercentiles(0.9, 0.95, 0.99)
                .publishPercentileHistogram()
                .tags("maz", "ezz")
                .register(prometheusRegistry);
*/

    }

}