package io.github.xtt28.spectrum;

import io.github.xtt28.spectrum.config.ConfigLoader;
import io.github.xtt28.spectrum.task.PingScheduler;

public class Main {

    public static void main(String[] args) {
        var config = ConfigLoader.loadSpectrumConfig();
        PingScheduler.schedulePing(config);
    }
}