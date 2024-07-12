package io.github.xtt28.spectrum.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import br.com.azalim.mcserverping.MCPingOptions;
import io.github.xtt28.spectrum.config.ConfigData;

public class PingScheduler {
    
    public static void schedulePing(ConfigData config) {
        var options = MCPingOptions.builder()
            .hostname(config.targetHostname())
            .port(config.targetPort())
            .timeout(config.targetTimeout())
            .protocolVersion(config.targetProtocol())
            .build();
        var pinger = new PeriodicPingTask(config, options);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(pinger, 0, config.pingDelay(), TimeUnit.MILLISECONDS);
    } 
}
