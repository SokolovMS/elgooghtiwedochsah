package com.eight.zero.three.algorithm.number2;

import com.eight.zero.three.input.Input;
import com.eight.zero.three.input.PossibleRide;
import com.eight.zero.three.output.Output;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Each vehicle has its own timeline (vehicle ~ timeline).
 * Lets iterate over all timelines and add most profitable ride to each.
 */
public class Algorithm2 {
    public static Output run(final Input input) {
        List<TimeLine> timeLines = new LinkedList<>();
        for (int i = 0; i < input.getnVehicles(); i++) {
            timeLines.add(new TimeLine(input));
        }

        List<PossibleRide> ridesToProcess = new ArrayList<>(input.getRides());

        boolean wasChanges = true;
        while (wasChanges) {
            wasChanges = false;

            for (TimeLine timeLine : timeLines) {
                FinalRide bestInsertion = null;

                for (PossibleRide ride : ridesToProcess) {
                    PointsAfterInsert pointsAfterInsert = timeLine.getPointsAfterInsert(ride);
                    if (!pointsAfterInsert.canInsert()) {
                        continue;
                    }

                    FinalRide currentInsertion = pointsAfterInsert.getFinalRide();
                    if ((bestInsertion == null) ||
                            (currentInsertion.getScore() > bestInsertion.getScore())) {
                        bestInsertion = currentInsertion;
                    }
                }

                if (bestInsertion != null) {
                    timeLine.add(bestInsertion);
                    ridesToProcess.remove(bestInsertion);
                    wasChanges = true;
                }
            }
        }

        return Output.fromTimeLines(timeLines);
    }
}
