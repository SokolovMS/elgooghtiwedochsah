package com.eight.zero.three.input;

import static com.eight.zero.three.algorithm.Utils.getDistance;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vehicle {
    private final Integer number;
    private final List<Ride> rides;
    Coord prevFinish = new Coord(0,0);
    private int busySteps = 0;

    public Vehicle(Integer number) {
        this.number = number;
        this.rides = new ArrayList<>();
    }

    public void assignRide(final Ride ride) {
        rides.add(ride);
        busySteps += getDistance(prevFinish, ride.getSrc());
        busySteps += getDistance(ride.getSrc(), ride.getDst());
        prevFinish = ride.getDst();

    }

    public Integer getNumber() {
        return number;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public int getBusySteps() {
        return busySteps;
    }

    public boolean isBusy(final int curStep) {
        return busySteps > curStep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(number, vehicle.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
