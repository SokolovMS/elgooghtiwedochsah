package com.eight.zero.three.input;

import com.eight.zero.three.algorithm.Utils;

public class Ride {
    private final int id;
    private final Coord src;
    private final Coord dst;
    private final int score;
    private final TimeInterval startInterval;
    private final TimeInterval finishInterval;

    public Ride(int id,
                final int a, final int b,
                final int x, final int y,
                final int s, final int f) {
        this.id = id;
        this.src = new Coord(a, b);
        this.dst = new Coord(x, y);
        this.score = Utils.getDistance(src, dst);
        this.startInterval = new TimeInterval(s, f - score);
        this.finishInterval = new TimeInterval(s + score, f);
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

    public TimeInterval getStartInterval() {
        return startInterval;
    }

    public TimeInterval getFinishInterval() {
        return finishInterval;
    }
}
