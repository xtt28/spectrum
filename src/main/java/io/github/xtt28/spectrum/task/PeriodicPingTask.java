package io.github.xtt28.spectrum.task;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.azalim.mcserverping.MCPing;
import br.com.azalim.mcserverping.MCPingOptions;
import io.github.xtt28.spectrum.config.ConfigData;
import io.github.xtt28.spectrum.storage.CsvDataEntry;

public class PeriodicPingTask implements Runnable {

    private ConfigData config;
    private MCPingOptions options;

    public PeriodicPingTask(ConfigData config, MCPingOptions options) {
        this.config = config;
        this.options = options;
    }

    @Override
    public void run() {
        var formattedServerIp = config.targetHostname() + ":" + config.targetPort();
        var now = LocalDateTime.now();

        try {
            var data = MCPing.getPing(options);
            var csvEntry = new CsvDataEntry(now, formattedServerIp, true, data.getPlayers().getOnline());
            System.out.println(csvEntry.toString());
        } catch (IOException ex) {
            Logger.getGlobal().log(Level.WARNING, "Could not ping server.", ex);
            var csvEntry = new CsvDataEntry(now, formattedServerIp, false, 0);
            System.out.println(csvEntry.toString());
        }
    }
}
