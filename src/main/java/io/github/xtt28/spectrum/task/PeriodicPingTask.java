package io.github.xtt28.spectrum.task;

import java.util.logging.Logger;

import io.github.xtt28.spectrum.config.ConfigData;

public class PeriodicPingTask implements Runnable {

    private ConfigData config;

    public PeriodicPingTask(ConfigData config) {
        this.config = config;
    }

    @Override
    public void run() {
        Logger.getGlobal().info(String.format("The server %s would've been pinged now.", config.targetHostname()));
    }
}
