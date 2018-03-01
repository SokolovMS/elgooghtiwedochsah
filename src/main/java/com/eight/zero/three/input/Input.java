package com.eight.zero.three.input;

public class Input {
    private final int r;
    private final int c;
    private final int f;
    private final int n;
    private final int b;
    private final int t;
    private final int [][] rides;

    public Input(final int r, final int c, final int f, final int n, final int b, final int t, final int[][] rides) {
        this.r = r;
        this.c = c;
        this.f = f;
        this.n = n;
        this.b = b;
        this.t = t;
        this.rides = rides;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public int getF() {
        return f;
    }

    public int getN() {
        return n;
    }

    public int getB() {
        return b;
    }

    public int getT() {
        return t;
    }

    public int[][] getRides() {
        return rides;
    }
}
