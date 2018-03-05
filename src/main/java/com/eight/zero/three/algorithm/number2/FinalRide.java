package com.eight.zero.three.algorithm.number2;

import com.eight.zero.three.input.PossibleRide;

public class FinalRide extends PossibleRide {
    private final int t0;
    private final int t1;
    private final int bonusScore;

    public FinalRide(final PossibleRide possibleRide, final int t0, final int bonusScore) {
        super(possibleRide);

        this.t0 = t0;
        this.t1 = possibleRide.getFinishInterval().getMin() + t0 - possibleRide.getStartInterval().getMin();

        if (t0 == possibleRide.getStartInterval().getMin()) {
            this.bonusScore = bonusScore;
        } else {
            this.bonusScore = 0;
        }
    }

    @Override
    public int getScore() {
        return super.getScore() + bonusScore;
    }

    public int getT0() {
        return t0;
    }

    public int getT1() {
        return t1;
    }
}
