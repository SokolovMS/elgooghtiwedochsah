package com.eight.zero.three;

import com.eight.zero.three.input.Coord;
import com.eight.zero.three.input.Input;
import com.eight.zero.three.output.Output;

/**
 * I am just testing git plugin in Idea.
 */
public class Algorithm {
    public static Output run(final Input input) {
        return new Output(
                3,
                new Slice(0, 2, 0, 1),
                new Slice(0, 2, 2, 2),
                new Slice(0, 2, 3, 4)
        );
    }

    public static int getDistance(final int startRow, final int startCol, final int finRow, final int finCol) {
        return Math.abs(startRow - finRow) + Math.abs(startCol - finCol);
    }

    public static int getDistance(final Coord a, final Coord b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }

}
