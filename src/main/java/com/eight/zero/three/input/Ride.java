package com.eight.zero.three.input;

import com.eight.zero.three.Algorithm;

public class Ride {
    private final Coord src;
    private final Coord dst;
    private final int score;
    private final TimeInterval startInterval;
    private final TimeInterval finishInterval;

    public Ride(final int a, final int b,
                final int x, final int y,
                final int s, final int f) {
        this.src = new Coord(a, b);
        this.dst = new Coord(x, y);
        this.score = Algorithm.getDistance(src, dst);
        this.startInterval = new TimeInterval(s, f - score);
        this.finishInterval = new TimeInterval(s + score, f);
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

    public TimeInterval getStartInterval() {
        return startInterval;
    }

    public TimeInterval getFinishInterval() {
        return finishInterval;
    }
}
