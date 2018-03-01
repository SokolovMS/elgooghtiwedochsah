package com.eight.zero.three.algorithm;

import com.eight.zero.three.algorithm.number2.TimeLine;
import com.eight.zero.three.input.Input;
import com.eight.zero.three.input.Ride;
import com.eight.zero.three.output.Output;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GreedyBreedy {
    public static Output run(final Input input) {
        // Empty timelines
        Queue<TimeLine> timeLines = new LinkedList<>();
        for (int i = 0; i < input.getFVehicles(); i++) {
            timeLines.add(new TimeLine(input));
        }

        List<Ride> ridesToProcess = new ArrayList<>(input.getRides());

        // Greedy get one by one
        int operations = 1;
        while (operations != 0) {
            operations = 0;

            Ride top = null;
            ridesToProcess.forEach(ride -> {

            });
        }

        return null;
    }
}
