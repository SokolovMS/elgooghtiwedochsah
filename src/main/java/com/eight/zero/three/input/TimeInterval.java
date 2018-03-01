package com.eight.zero.three.input;

public class TimeInterval {
    private final int tMin;
    private final int tMax;

    public TimeInterval(int tMin, int tMax) {
        this.tMin = tMin;
        this.tMax = tMax;
    }

    public int gettMin() {
        return tMin;
    }

    public int gettMax() {
        return tMax;
    }
}
