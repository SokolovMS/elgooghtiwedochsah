package com.eight.zero.three.algorithm;

import com.eight.zero.three.input.Input;
import com.eight.zero.three.input.Ride;
import com.eight.zero.three.output.Output;

import java.util.ArrayList;
import java.util.List;

/**
 * I am just testing git plugin in Idea.
 */
public class Algorithm {
    public static Output run(final Input input) {
        List<Ride> unassignedRides = new ArrayList<>(input.getRides());
        for (int curStep = 0; curStep < input.getTSteps(); curStep++) {

        }

        return new Output(100);
    }
}