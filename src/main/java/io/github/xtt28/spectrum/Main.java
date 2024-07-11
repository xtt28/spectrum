package io.github.xtt28.spectrum;

import java.util.logging.Logger;

import io.github.xtt28.spectrum.config.ConfigLoader;

public class Main {
    
    public static void main(String[] args) {
        var config = ConfigLoader.loadSpectrumConfig();
        Logger.getGlobal().info(config.toString());
    }
}