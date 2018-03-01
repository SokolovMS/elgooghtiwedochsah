package com.eight.zero.three.input;

public class Input {
    private final int Rows;
    private final int Cols;
    private final int FVehicles;
    private final int NRides;
    private final int Bonus;
    private final int TSteps;
    private final int [][] rides;

    public Input(final int Rows, final int Cols, final int FVehicles, final int NRides, final int Bonus, final int TSteps, final int[][] rides) {
        this.Rows = Rows;
        this.Cols = Cols;
        this.FVehicles = FVehicles;
        this.NRides = NRides;
        this.Bonus = Bonus;
        this.TSteps = TSteps;
        this.rides = rides;
    }

    public int getRows() {
        return Rows;
    }

    public int getCols() {
        return Cols;
    }

    public int getFVehicles() {
        return FVehicles;
    }

    public int getNRides() {
        return NRides;
    }

    public int getBonus() {
        return Bonus;
    }

    public int getTSteps() {
        return TSteps;
    }

    public int[][] getRides() {
        return rides;
    }
}
