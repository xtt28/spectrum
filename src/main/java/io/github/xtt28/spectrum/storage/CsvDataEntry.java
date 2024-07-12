package io.github.xtt28.spectrum.storage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record CsvDataEntry(
    LocalDateTime time,
    String server,
    boolean successful,
    int playerCount
) {
    
    public static final String HEADER = "time,server,successful,player_count";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String toString() {
        var formattedDateTime = formatter.format(time);
        return String.format("%s,%s,%b,%d", formattedDateTime, server, successful, playerCount);
    }
}
