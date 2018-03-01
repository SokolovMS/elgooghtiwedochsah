package com.eight.zero.three.algorithm;

import com.eight.zero.three.input.Coord;
import com.eight.zero.three.input.Ride;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Utils {
    public static int getDistance(final Coord a, final Coord b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY());
    }

    public static LinkedList<Ride> sortRides(List<Ride> rides) {
        // Sort by distance
        Collections.sort(rides, (ride1, ride2) -> {
            return ride1.getScore() - ride2.getScore();
        });

        // Sort by start time
        Collections.sort(rides, (ride1, ride2) -> {
            int ride1StartTime = ride1.getStartInterval().gettMin();
            int ride2StartTime = ride2.getStartInterval().gettMin();

            return ride1StartTime - ride2StartTime;
        });

        return new LinkedList<>(rides);
    }
}
