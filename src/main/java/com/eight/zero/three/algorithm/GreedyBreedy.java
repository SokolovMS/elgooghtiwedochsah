package com.eight.zero.three.algorithm;

import com.eight.zero.three.algorithm.number2.FinalRide;
import com.eight.zero.three.algorithm.number2.TimeLine;
import com.eight.zero.three.input.Input;
import com.eight.zero.three.input.Ride;
import com.eight.zero.three.input.Vehicle;
import com.eight.zero.three.output.Output;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GreedyBreedy {
    public static Output run(final Input input) {
        // Empty timelines
        List<TimeLine> timeLines = new LinkedList<>();
        for (int i = 0; i < input.getFVehicles(); i++) {
            timeLines.add(new TimeLine(input));
        }

        List<Ride> ridesToProcess = new ArrayList<>(input.getRides());

        boolean wasChanges = true;
        while (wasChanges) {
            wasChanges = false;

            for (TimeLine timeLine : timeLines) {
                FinalRide currentTopRide = null;

                for (Ride ride : ridesToProcess) {
                    FinalRide rideWithCorrectTime = timeLine.pointsAfterConnectingRide(ride);
                    if (rideWithCorrectTime == null || rideWithCorrectTime.getScore() < 0) {
                        continue;
                    }

                    if ((currentTopRide == null) ||
                            (rideWithCorrectTime.getScore() > currentTopRide.getScore())) {
                        currentTopRide = rideWithCorrectTime;
                    }
                }

                if (currentTopRide != null) {
                    timeLine.add(currentTopRide);
                    ridesToProcess.remove(rideStub(currentTopRide));
                    wasChanges = true;
                }
            }
        }

        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < timeLines.size(); i++) {
            Vehicle vehicle= new Vehicle(i);
            for (FinalRide ride : timeLines.get(i).getFinalRides()) {
                vehicle.assignRide(ride.getRide());
            }

            vehicles.add(vehicle);

        }
        return new Output(vehicles);
    }

    private static Ride rideStub(FinalRide finalRide) {
        return new Ride(finalRide.getId(), 0, 0, 0, 0, 0, 0);
    }
}
