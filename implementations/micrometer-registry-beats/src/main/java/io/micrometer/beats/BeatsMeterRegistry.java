package io.micrometer.beats;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.config.NamingConvention;
import io.micrometer.core.instrument.step.StepMeterRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author Geoff Bourne
 * @since Jan 2018
 */
public class BeatsMeterRegistry extends StepMeterRegistry {
    private final Logger logger = LoggerFactory.getLogger(BeatsMeterRegistry.class);
    private final ObjectMapper mapper = new ObjectMapper();
    private final BeatsConfig config;

    public BeatsMeterRegistry(BeatsConfig config, Clock clock) {
        this(config, clock, Executors.defaultThreadFactory());
    }

    public BeatsMeterRegistry(BeatsConfig config, Clock clock, ThreadFactory threadFactory) {
        super(config, clock);
        this.config = config;
        config().namingConvention(NamingConvention.camelCase);
        start(threadFactory);
    }

    @Override
    protected void publish() {

    }

    @Override
    protected TimeUnit getBaseTimeUnit() {
        return TimeUnit.SECONDS;
    }
}
