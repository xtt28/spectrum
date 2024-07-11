package io.github.xtt28.spectrum.config;

public record ConfigData(
        int pingDelay,
        String targetHostname,
        short targetPort,
        int targetTimeout,
        short targetProtocol) {
}
