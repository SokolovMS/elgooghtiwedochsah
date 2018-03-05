package com.eight.zero.three.algorithm.number2;

import com.eight.zero.three.input.PossibleRide;

public class PointsAfterInsert {
    private PossibleRide possibleRide;
    private boolean canInsert;
    private int t0;
    private int bonus;

    public PointsAfterInsert(PossibleRide possibleRide, boolean canInsert, int t0, int bonus) {
        this.possibleRide = possibleRide;
        this.canInsert = canInsert;
        this.t0 = t0;
        this.bonus = bonus;
    }

    public boolean canInsert() {
        return canInsert;
    }

    public FinalRide getFinalRide() {
        return new FinalRide(possibleRide, t0, bonus);
    }
}
