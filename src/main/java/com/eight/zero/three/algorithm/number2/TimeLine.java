package com.eight.zero.three.algorithm.number2;

import com.eight.zero.three.algorithm.Utils;
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

    public int pointsAfterConnectingNewRide(final int t0, final Ride ride) {
        FinalRide newFinalRide = new FinalRide(t0, ride);
        if (finalRides.isEmpty()) {
            return isRideCorrect(newFinalRide);
        }

        for (FinalRide current : finalRides) {
            // TODO: need improvements
            if (!canRidesBeConnected(current, newFinalRide)) {
                return false;
            }
        }

        return isRideCorrect(newFinalRide);
    }

    public boolean canBeAdded(final int t0, final Ride ride) {
        FinalRide newFinalRide = new FinalRide(t0, ride);
        if (finalRides.isEmpty()) {
            return isRideCorrect(newFinalRide);
        }

        for (FinalRide current : finalRides) {
            // TODO: need improvements
            if (!canRidesBeConnected(current, newFinalRide)) {
                return false;
            }
        }

        return isRideCorrect(newFinalRide);
    }

    private boolean canRidesBeConnected(FinalRide current, FinalRide newFinalRide) {
        return canBeConnected(newFinalRide, current) || canBeConnected(current, newFinalRide);
    }

    private boolean canBeConnected(FinalRide left, FinalRide right) {
        return left.getT1() + Utils.getDistance(left.getDst(), right.getSrc()) <
    }

    public boolean isRideCorrect(final FinalRide finalRide) {
        return (finalRide.getT0() >= 0 && finalRide.getT0() <= TSteps &&
                finalRide.getT0() <= finalRide.getT1() &&
                finalRide.getT1() >= 0 && finalRide.getT1() <=TSteps);
    }
}
