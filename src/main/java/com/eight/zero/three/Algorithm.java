package com.eight.zero.three;

import com.eight.zero.three.input.Coord;
import com.eight.zero.three.input.Input;
import com.eight.zero.three.output.Output;

/**
 * I am just testing git plugin in Idea.
 */
public class Algorithm {
    public static Output run(final Input input) {
        return new Output(100);
    }

    public static int getDistance(final Coord a, final Coord b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }

}
