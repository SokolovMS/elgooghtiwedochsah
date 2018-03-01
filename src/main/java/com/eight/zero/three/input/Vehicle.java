package com.eight.zero.three.input;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private final Integer number;
    private final List<Ride> rides;

    public Vehicle(Integer number) {
        this.number = number;
        this.rides = new ArrayList<>();
    }

    void assignRide(final Ride ride) {
        rides.add(ride);
    }

    public List<Ride> getRides() {
        return rides;
    }
}
