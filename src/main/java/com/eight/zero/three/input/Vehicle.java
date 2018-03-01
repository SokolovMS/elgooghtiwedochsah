package com.eight.zero.three.input;

import static com.eight.zero.three.algorithm.Utils.getDistance;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private final Integer number;
    private final List<Ride> rides;

    public Vehicle(Integer number) {
        this.number = number;
        this.rides = new ArrayList<>();
    }

    public void assignRide(final Ride ride) {
        rides.add(ride);
    }

    public Integer getNumber() {
        return number;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public boolean isBusy(final int curStep) {
        int busySteps = 0;
        Coord prevFinish = new Coord(0,0);

        for (Ride ride : rides) {
            busySteps += getDistance(prevFinish, ride.getSrc());
            prevFinish = ride.getDst();
        }

        return busySteps > curStep;
    }
}
