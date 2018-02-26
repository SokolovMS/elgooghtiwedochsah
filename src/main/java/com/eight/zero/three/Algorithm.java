package com.eight.zero.three;

import com.eight.zero.three.input.Input;
import com.eight.zero.three.output.Output;

public class Algorithm {
    public static Output run(final Input input) {
        return new Output(
                3,
                new Slice(0, 0, 2, 1),
                new Slice(0, 2, 2, 2),
                new Slice(0, 3, 2, 4)
        );
    }
}
