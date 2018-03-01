package com.eight.zero.three.algorithm.number2;

import com.eight.zero.three.algorithm.Utils;
import com.eight.zero.three.input.Input;
import com.eight.zero.three.input.Ride;

import java.util.LinkedList;
import java.util.List;

public class TimeLine {
    private final int Bonus;
    private final int TSteps;
    private final List<FinalRide> finalRides;

    public TimeLine(final int Bonus, final int TSteps) {
        this.Bonus = Bonus;
        this.TSteps = TSteps;
        finalRides = new LinkedList<>();
    }

    public TimeLine(Input input) {
        this(input.getBonus(), input.getTSteps());
    }

    public int pointsAfterConnectingNewRide(final int t0, final Ride ride) {
        FinalRide newFinalRide = new FinalRide(t0, ride);
        if (finalRides.isEmpty()) {
            return ridePoints(newFinalRide);
        }

        for (FinalRide current : finalRides) {
            // TODO: need improvements
            if (!canRidesBeConnected(current, newFinalRide)) {
                return -1;
            }
        }

        return ridePoints(newFinalRide);
    }

    public void add(final int t0, final Ride ride) {
        FinalRide newFinalRide = new FinalRide(t0, ride);
        if (finalRides.isEmpty()) {
            finalRides.add(newFinalRide);
            return;
        }

        // If can connect from left
        int indexToPaste = 0;
        while (indexToPaste < finalRides.size() && !canBeConnected(newFinalRide, finalRides.get(indexToPaste))) {
            indexToPaste++;
        }

        finalRides.add(indexToPaste, newFinalRide);
    }

    private boolean canRidesBeConnected(FinalRide current, FinalRide newFinalRide) {
        return canBeConnected(newFinalRide, current) || canBeConnected(current, newFinalRide);
    }

    private boolean canBeConnected(FinalRide left, FinalRide right) {
        return left.getT1() + Utils.getDistance(left.getDst(), right.getSrc()) <= right.getT0();
    }

    private boolean isRideCorrect(final FinalRide finalRide) {
        return (finalRide.getT0() >= 0 && finalRide.getT0() <= TSteps &&
                finalRide.getT0() <= finalRide.getT1() &&
                finalRide.getT1() >= 0 && finalRide.getT1() <=TSteps);
    }

    private int ridePoints(final FinalRide ride) {
        int bonus = ride.isBonus() ? Bonus : 0;
        return isRideCorrect(ride) ? ride.getScore() + bonus : -1;
    }
}
