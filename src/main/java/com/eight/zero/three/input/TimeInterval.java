package com.eight.zero.three.input;

public class TimeInterval {
    private final int tMin;
    private final int tMax;

    public TimeInterval(int tMin, int tMax) {
        this.tMin = tMin;
        this.tMax = tMax;
    }

    public int getMin() {
        return tMin;
    }

    public int getMax() {
        return tMax;
    }

    public boolean isIn(final int t) {
        return (t >= tMin) && (t <= tMax);
    }
}
