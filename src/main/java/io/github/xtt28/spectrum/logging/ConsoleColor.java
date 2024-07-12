package io.github.xtt28.spectrum.logging;

public enum ConsoleColor {

    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m");

    private final String value;

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }

    private ConsoleColor(String value) {
        this.value = value;
    }

}