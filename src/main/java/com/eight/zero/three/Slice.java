package com.eight.zero.three;

public class Slice {
    private final int r1;
    private final int r2;
    private final int c1;
    private final int c2;

    public Slice(final int r1, final int r2, final int c1, final int c2) {
        this.r1 = r1;
        this.r2 = r2;
        this.c1 = c1;
        this.c2 = c2;
    }

    public int getR1() {
        return r1;
    }

    public int getR2() {
        return r2;
    }

    public int getC1() {
        return c1;
    }

    public int getC2() {
        return c2;
    }

    @Override
    public String toString() {
        return r1 + " " + c1 + " " + r2 + " " + c2;
    }
}
