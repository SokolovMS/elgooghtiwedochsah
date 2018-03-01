package com.eight.zero.three.algorithm.number2;

import com.eight.zero.three.input.Coord;
import com.eight.zero.three.input.Ride;

public class FinalRide {
    private final int id;
    private final Coord src;
    private final Coord dst;
    private final int totalScore;
    private final int t0;
    private final int t1;

    private final boolean isBonus;
    private final Ride ride;

    public FinalRide(final int t0, final Ride ride, int bonus) {
        this.id = ride.getId();
        this.src = ride.getSrc();
        this.dst = ride.getDst();
        this.t0 = t0;
        this.t1 = t0 + ride.getScore();

        this.isBonus = (t0 == ride.getStartInterval().getMin());
        this.totalScore = ride.getScore() + (isBonus ? bonus : 0);

        this.ride = ride;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public Ride getRide() {
        return ride;
    }

    public int getId() {
        return id;
    }

    public Coord getSrc() {
        return src;
    }

    public Coord getDst() {
        return dst;
    }

    public int getScore() {
        return totalScore;
    }

    public int getT0() {
        return t0;
    }

    public int getT1() {
        return t1;
    }

    public boolean isBonus() {
        return isBonus;
    }
}
