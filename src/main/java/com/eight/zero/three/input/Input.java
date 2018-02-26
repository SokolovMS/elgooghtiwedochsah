package com.eight.zero.three.input;

public class Input {
    private final int r;
    private final int c;
    private final int l;
    private final int h;
    private final char [][] arr;

    public Input(final int r, final int c, final int l, final int h, final char[][] arr) {
        this.r = r;
        this.c = c;
        this.l = l;
        this.h = h;
        this.arr = arr;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public int getL() {
        return l;
    }

    public int getH() {
        return h;
    }

    public char[][] getArr() {
        return arr;
    }
}
