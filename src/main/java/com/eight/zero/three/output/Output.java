package com.eight.zero.three.output;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private List<Integer> [] schedule;

    public Output(int vehicleQnt) {
        schedule = new List[vehicleQnt];
    }

    public void addRides(int vehicle, int... rides) {
        if (schedule[vehicle] == null) {
            schedule[vehicle] = new ArrayList<>();
        }

        for (int ride : rides) {
            schedule[vehicle].add(ride);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(List<Integer> rides : schedule) {

            if(rides != null && rides.size() != 0) {
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
