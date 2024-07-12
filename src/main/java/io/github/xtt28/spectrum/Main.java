package io.github.xtt28.spectrum;

import java.util.Arrays;

import io.github.xtt28.spectrum.config.ConfigLoader;
import io.github.xtt28.spectrum.logging.LogFormatter;
import io.github.xtt28.spectrum.storage.CsvDataEntry;
import io.github.xtt28.spectrum.task.PingScheduler;

public class Main {

    public static void main(String[] args) {
        LogFormatter.setup();

        var config = ConfigLoader.loadSpectrumConfig();
        PingScheduler.schedulePing(config);

        if (!Arrays.asList(args).contains("--no-header"))
            System.out.println(CsvDataEntry.HEADER);
    }
}