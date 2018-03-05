package com.eight.zero.three.algorithm.number2;

import com.eight.zero.three.algorithm.Utils;
import com.eight.zero.three.input.Input;
import com.eight.zero.three.input.PossibleRide;

import java.util.LinkedList;
import java.util.List;

public class TimeLine {
    private final int Bonus;
    private final int TSteps;
    private final List<FinalRide> finalRides;

    public List<FinalRide> getFinalRides() {
        return finalRides;
    }

    public TimeLine(final int Bonus, final int TSteps) {
        this.Bonus = Bonus;
        this.TSteps = TSteps;

        finalRides = new LinkedList<>();
        finalRides.add(new StartRide());
    }

    public TimeLine(Input input) {
        this(input.getBonus(), input.getTSteps());
    }

    public PointsAfterInsert getPointsAfterInsert(final PossibleRide ride) {
        int i = 0;
        while (i < finalRides.size() - 1) {
            FinalRide left = finalRides.get(i);
            FinalRide right = finalRides.get(i + 1);

            PointsAfterInsert result = getPointsAfterInsertBetween(left, ride, right);
            if (result.canInsert()) {
                return result;
            }

            i++;
        }

        PointsAfterInsert result = getPointsAfterInsertToTheEnd(finalRides.get(i), ride);
        return result;
    }

    private PointsAfterInsert getPointsAfterInsertBetween(FinalRide left, PossibleRide ride, FinalRide right) {
        int tl1 = left.getT1() + Utils.getDistance(left.getDst(), ride.getSrc());
        int tr0 = right.getT0() - Utils.getDistance(ride.getDst(), right.getSrc());

        // TODO. Now will take min t0 for possible ride.
        if (tl1 > ride.getStartInterval().getMax()) {
            return new PointsAfterInsert(ride, false, -1, -1);
        }
        int t0 = Math.max(tl1, ride.getStartInterval().getMin());

        if (tr0 < ride.getFinishInterval().getMin()) {
            return new PointsAfterInsert(ride, false, -1, -1);
        }
        int t1 = ride.getFinishInterval().getMin() + t0 - ride.getStartInterval().getMin();

        if ((t0 <= ride.getStartInterval().getMax()) && (t1 <= tr0)) {
            return new PointsAfterInsert(ride, true, t0, Bonus);
        } else {
            return new PointsAfterInsert(ride, false, -1, -1);
        }
    }

    private PointsAfterInsert getPointsAfterInsertToTheEnd(FinalRide left, PossibleRide ride) {
        int tl1 = left.getT1() + Utils.getDistance(left.getDst(), ride.getSrc());

        if (tl1 > ride.getStartInterval().getMax()) {
            return new PointsAfterInsert(ride, false, -1, -1);
        }
        int t0 = Math.max(tl1, ride.getStartInterval().getMin());

        int t1 = ride.getFinishInterval().getMin() + t0 - ride.getStartInterval().getMin();

        if ((t0 <= ride.getStartInterval().getMax()) && (t1 <= TSteps)) {
            return new PointsAfterInsert(ride, true, t0, Bonus);
        } else {
            return new PointsAfterInsert(ride, false, -1, -1);
        }
    }

    public void add(FinalRide bestFinalRide) {
        int i = 0;
        while ((i < finalRides.size()) && (bestFinalRide.getT1() >= finalRides.get(i).getT1())) {
            i++;
        }

        finalRides.add(i, bestFinalRide);
    }
}
