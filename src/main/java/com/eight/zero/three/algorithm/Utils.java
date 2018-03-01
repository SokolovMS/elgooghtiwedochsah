package com.eight.zero.three.algorithm;

import com.eight.zero.three.input.Coord;

public class Utils {
    public static int getDistance(final Coord a, final Coord b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }
}
