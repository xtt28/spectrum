package io.github.xtt28.spectrum.logging;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LogFormatter extends Formatter {

    private static final int INFO_VALUE = 800;
    private static final int WARNING_VALUE = 900;
    private static final int SEVERE_VALUE = 1000;

    @Override
    public String format(LogRecord record) {
        var formatted = String.format("%s[%s] " + ConsoleColor.RESET.getValue() + "%s", getColor(record.getLevel()), record.getLevel(), record.getMessage());
        if (record.getParameters() != null) {
            formatted += "\t";
            for (var i = 0; i < record.getParameters().length; i++) {
                formatted += record.getParameters()[i];
                if (i < record.getParameters().length - 1)
                    formatted += ", ";
            }
        }
        formatted += "\n" + ConsoleColor.RESET.getValue();

        if (record.getThrown() != null)
            Arrays.stream(record.getThrown().getStackTrace()).forEach(element -> Logger.getGlobal().severe(element.toString()));
            
        return formatted;
    }

    private String getColor(Level logLevel) {
        switch (logLevel.intValue()) {
            case INFO_VALUE:
                return ConsoleColor.BLUE.toString();
            case WARNING_VALUE:
                return ConsoleColor.YELLOW.toString();
            case SEVERE_VALUE:
                return ConsoleColor.RED.toString();
            default:
                return ConsoleColor.RESET.toString();
        }
    }

    public static void setup() {
        var logger = Logger.getGlobal();
        logger.setUseParentHandlers(false);
        var handler = new ConsoleHandler();
        handler.setFormatter(new LogFormatter());
        logger.addHandler(handler);
    }
    
}