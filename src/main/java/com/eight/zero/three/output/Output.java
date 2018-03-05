package com.eight.zero.three.output;

import com.eight.zero.three.algorithm.number2.StartRide;
import com.eight.zero.three.algorithm.number2.TimeLine;
import com.eight.zero.three.input.PossibleRide;
import com.eight.zero.three.algorithm.number1.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private List<List<Integer>> schedule;

    public Output(final List<List<Integer>> schedule) {
        this.schedule = schedule;
    }

    public static Output fromVehicles(final List<Vehicle> vehicles) {
        List<List<Integer>> schedule = new ArrayList<>();

        for (Vehicle vehicle : vehicles) {
            schedule.add(vehicle.getRides().stream()
                    .map(PossibleRide::getId)
                    .collect(Collectors.toList()));
        }

        return new Output(schedule);
    }

    public static Output fromTimeLines(final List<TimeLine> timeLines) {
        List<List<Integer>> schedule = new ArrayList<>();

        for (TimeLine timeLine : timeLines) {
            schedule.add(timeLine.getFinalRides().stream()
                    .filter(ride -> !(ride instanceof StartRide))
                    .map(PossibleRide::getId)
                    .collect(Collectors.toList()));
        }

        return new Output(schedule);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(List<Integer> rides : schedule) {

            if (rides != null && rides.size() != 0) {
                sb.append(rides.size());
                for(int ride : rides) {
                    sb.append(" ");
                    sb.append(ride);
                }

                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
