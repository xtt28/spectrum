package io.github.xtt28.spectrum.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import io.github.xtt28.spectrum.config.ConfigData;

public class PingScheduler {
    
    public static void schedulePing(ConfigData config) {
        var pinger = new PeriodicPingTask(config);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(pinger, 0, config.pingDelay(), TimeUnit.MILLISECONDS);
    } 
}
