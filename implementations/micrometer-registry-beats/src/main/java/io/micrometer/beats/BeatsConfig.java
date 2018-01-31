package io.micrometer.beats;

import io.micrometer.core.instrument.step.StepRegistryConfig;

/**
 * @author Geoff Bourne
 * @since Jan 2018
 */
public interface BeatsConfig extends StepRegistryConfig {
    @Override
    default String prefix() {
        return "newrelic";
    }

    /**
     * Returns the host:port of a Beats TCP endpoint, such as Logstash Beats input plugin.
     */
    default String endpoint() {
        String v = get(prefix() + ".endpoint");
        return (v == null) ? "localhost:5044" : v;
    }

}
