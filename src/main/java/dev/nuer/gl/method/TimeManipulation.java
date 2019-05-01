package dev.nuer.gl.method;

import java.util.concurrent.TimeUnit;

public class TimeManipulation {

    private int days;
    private long hours;
    private long minutes;
    private long seconds;

    public TimeManipulation(int secondsToConvert) {
        this.days = (int) TimeUnit.SECONDS.toDays(secondsToConvert);
        this.hours = TimeUnit.SECONDS.toHours(secondsToConvert) - (days * 24);
        this.minutes = TimeUnit.SECONDS.toMinutes(secondsToConvert) - (TimeUnit.SECONDS.toHours(secondsToConvert) * 60);
        this.seconds = TimeUnit.SECONDS.toSeconds(secondsToConvert) - (TimeUnit.SECONDS.toMinutes(secondsToConvert) * 60);
    }

    public String getDays() {
        return String.valueOf(days);
    }

    public String getHours() {
        return String.valueOf(hours);
    }

    public String getMinutes() {
        return String.valueOf(minutes);
    }

    public String getSeconds() {
        return String.valueOf(seconds);
    }
}