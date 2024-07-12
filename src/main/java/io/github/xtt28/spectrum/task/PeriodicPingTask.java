package io.github.xtt28.spectrum.task;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.azalim.mcserverping.MCPing;
import br.com.azalim.mcserverping.MCPingOptions;
import io.github.xtt28.spectrum.config.ConfigData;

public class PeriodicPingTask implements Runnable {

    private ConfigData config;
    private MCPingOptions options;

    public PeriodicPingTask(ConfigData config, MCPingOptions options) {
        this.config = config;
        this.options = options;
    }

    @Override
    public void run() {
        try {
            var data = MCPing.getPing(options);
            Logger.getGlobal().info(String.format("Player count on %s: %d/%d", config.targetHostname(), data.getPlayers().getOnline(), data.getPlayers().getMax()));
        } catch (IOException ex) {
            Logger.getGlobal().log(Level.WARNING, "Could not ping server.", ex);
        }
    }
}
