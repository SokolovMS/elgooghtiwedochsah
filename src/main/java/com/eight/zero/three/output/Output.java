package com.eight.zero.three.output;

import com.eight.zero.three.input.PossibleRide;
import com.eight.zero.three.input.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Output {
    private List<Integer> [] schedule;

    public Output(final List<Vehicle> vehicles) {
        schedule = new List[vehicles.size()];

        for (int i = 0; i < vehicles.size(); i++) {
            if (schedule[i] == null) {
                schedule[i] = new ArrayList<>();
            }

            for (PossibleRide ride : vehicles.get(i).getRides()) {
                schedule[i].add(ride.getId());
            }
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
