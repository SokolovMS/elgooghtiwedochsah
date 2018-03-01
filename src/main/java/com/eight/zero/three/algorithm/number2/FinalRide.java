package com.eight.zero.three.algorithm.number2;

import com.eight.zero.three.input.Coord;
import com.eight.zero.three.input.Ride;

public class FinalRide {
    private final int id;
    private final Coord src;
    private final Coord dst;
    private final int score;
    private final int t0;
    private final int t1;

    private final boolean isBonus;

    public FinalRide(final int t0, final Ride ride) {
        this.id = ride.getId();
        this.src = ride.getSrc();
        this.dst = ride.getDst();
        this.score = ride.getScore();
        this.t0 = t0;
        this.t1 = t0 + ride.getScore();

        this.isBonus = (t0 == ride.getStartInterval().gettMin());
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
        return score;
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
