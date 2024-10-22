package data;

public enum Mode {
    FULLSCREEN("--start-fullscreen"),
    HEADLESS("--headless"),
    KIOSK("--kiosk");

    private String argument;

    Mode(String argument) {
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }
}
