package com.eight.zero.three.algorithm.number2;

import com.eight.zero.three.algorithm.Utils;
import com.eight.zero.three.input.Coord;
import com.eight.zero.three.input.Input;
import com.eight.zero.three.input.Ride;

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
    }

    public TimeLine(Input input) {
        this(input.getBonus(), input.getTSteps());
    }

    public FinalRide pointsAfterConnectingRide(final Ride ride) {
        if (finalRides.isEmpty()) {
            int ind = getIndexIfSingle(ride);
            if (ind >= 0) {
                return new FinalRide(ind, ride, Bonus);
            } else {
                return null;
            }
        }

        // If can connect from left
        for (int i = 0; i < finalRides.size() - 1; i++) {
            FinalRide left = finalRides.get(i);
            FinalRide right = finalRides.get(i+1);

            int indexIfBetween = getIndexIfBetween(left, ride, right);
            if (indexIfBetween >= 0) {
                return new FinalRide(indexIfBetween, ride, Bonus);
            }
        }

        int firstInd = getIndexIfFirst(ride);
        if (firstInd >= 0) {
            return new FinalRide(firstInd, ride, Bonus);
        }

        int lastInd = getIndexIfLast(ride);
        if (lastInd >= 0) {
            return new FinalRide(lastInd, ride, Bonus);
        }

        return null;
    }

    private int getIndexIfSingle(Ride ride) {
        int finalX = ride.getDst().getX();
        int finalY = ride.getDst().getY();
        return getIndexIfBetween(new FinalRide(0, new Ride(-1, 0, 0, 0, 0, 0, 0), 0),
                ride,
                new FinalRide(TSteps, new Ride(-1, finalX, finalY, finalX, finalY, TSteps, TSteps), 0));
    }

    private int getIndexIfLast(Ride ride) {
        int finalX = ride.getDst().getX();
        int finalY = ride.getDst().getY();
        return getIndexIfBetween(finalRides.get(finalRides.size() - 1), ride, new FinalRide(TSteps, new Ride(-1, finalX, finalY, finalX, finalY, TSteps, TSteps), 0));
    }

    private int getIndexIfFirst(Ride ride) {
        return getIndexIfBetween(new FinalRide(0, new Ride(-1, 0, 0, 0, 0, 0, 0), 0), ride, finalRides.get(0));
    }

    private int getIndexIfBetween(FinalRide left, Ride ride, FinalRide right) {
        int start = left.getT1() + Utils.getDistance(left.getDst(), ride.getSrc());
        int finish = right.getT0() - Utils.getDistance(ride.getDst(), right.getSrc());

        if ((ride.getStartInterval().getMax() >= start) && //(ride.getStartInterval().getMin() <= start) &&
//                ((ride.getFinishInterval().getMax() >= finish) &&
                        (ride.getFinishInterval().getMin() <= finish)) {
            return Math.max(start, ride.getStartInterval().getMin());
        } else {
            return -1;
        }
    }

    public void add(final FinalRide finalRide) {
        if (finalRides.isEmpty()) {
            finalRides.add(finalRide);
            return;
        }

        // If can connect from left
        int indexToPaste = 0;
        while (indexToPaste < finalRides.size() && !canBeConnected(finalRide, finalRides.get(indexToPaste))) {
            indexToPaste++;
        }

        finalRides.add(indexToPaste, finalRide);
    }

    private boolean canBeConnected(FinalRide left, FinalRide right) {
        return left.getT1() + Utils.getDistance(left.getDst(), right.getSrc()) <= right.getT0();
    }
}
