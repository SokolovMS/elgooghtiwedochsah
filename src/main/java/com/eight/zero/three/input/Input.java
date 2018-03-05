package com.eight.zero.three.input;

import java.util.List;

public class Input {
    private final int rows;
    private final int cols;
    private final int nVehicles;
    private final int nRides;
    private final int bonus;
    private final int tSteps;
    private final List<PossibleRide> rides;

    public Input(final int rows, final int cols,
                 final int nVehicles, final int nRides,
                 final int bonus, final int tSteps,
                 final List<PossibleRide> rides) {
        this.rows = rows;
        this.cols = cols;
        this.nVehicles = nVehicles;
        this.nRides = nRides;
        this.bonus = bonus;
        this.tSteps = tSteps;
        this.rides = rides;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getnVehicles() {
        return nVehicles;
    }

    public int getnRides() {
        return nRides;
    }

    public int getBonus() {
        return bonus;
    }

    public int gettSteps() {
        return tSteps;
    }

    public List<PossibleRide> getRides() {
        return rides;
    }
}
