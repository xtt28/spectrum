package io.github.xtt28.spectrum.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigLoader {
    
    private static final String CONFIG_FILE_NAME = "spectrum.properties";

    public static ConfigData loadSpectrumConfig() {
        try {
            Properties loadedConfig = readProperties(CONFIG_FILE_NAME);
            var pingDelay = Integer.parseInt(loadedConfig.getProperty("pinger.delay"));
            var targetHostname = loadedConfig.getProperty("target.hostname");
            var targetPort = Short.parseShort(loadedConfig.getProperty("target.port"));
            var targetTimeout = Integer.parseInt(loadedConfig.getProperty("target.timeout"));
            var targetProtocol = Short.parseShort(loadedConfig.getProperty("target.protocol"));

            return new ConfigData(pingDelay, targetHostname, targetPort, targetTimeout, targetProtocol);
        } catch (Exception ex) {
            Logger.getGlobal().log(Level.SEVERE, "The configuration file couldn't be loaded or is malformed.", ex);
            System.exit(1);
            return null;
        }
    }

    private static Properties readProperties(String fileName) throws IOException {
        FileInputStream inputStream = null;
        var properties = new Properties();

        try {
            inputStream = new FileInputStream(fileName);
            properties.load(inputStream);
        } catch (IOException ex) {
            Logger.getGlobal().log(Level.SEVERE, "Could not read properties file.", ex);
            System.exit(1);
        } finally {
            inputStream.close();
        }

        return properties;
    }
}
