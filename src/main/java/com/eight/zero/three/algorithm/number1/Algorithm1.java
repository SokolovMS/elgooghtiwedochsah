package com.eight.zero.three.algorithm.number1;

import com.eight.zero.three.algorithm.Utils;
import com.eight.zero.three.input.Input;
import com.eight.zero.three.input.PossibleRide;
import com.eight.zero.three.output.Output;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * I am just testing git plugin in Idea.
 */
public class Algorithm1 {
    public static Output run(final Input input) {
        LinkedList<PossibleRide> unassignedRides = new LinkedList<>(input.getRides());
        unassignedRides = Utils.sortRides(unassignedRides);
        List<Vehicle> vehicles = generateVehicles(input.getnVehicles());

        for (int curStep = 0; curStep < input.gettSteps(); curStep++) {
            List<Vehicle> freeVehicles = getFreeVehicles(vehicles, curStep);
            LinkedList<PossibleRide> candidateRides = new LinkedList<>(unassignedRides);

            while (!freeVehicles.isEmpty() && !candidateRides.isEmpty()) {
                Vehicle assignedVehicle = null;
                PossibleRide topRide = candidateRides.removeFirst();

                for (Vehicle freeVehicle : freeVehicles) {
                    if (freeVehicle.canBeAssign(topRide)) {
                        freeVehicle.assignRide(topRide);
                        assignedVehicle = freeVehicle;
                        break;
                    }
                }

                if (assignedVehicle != null) {
                    freeVehicles.remove(assignedVehicle);
                    unassignedRides.remove(topRide);
                }
            }
        }

        return Output.fromVehicles(vehicles);
    }

    private static List<Vehicle> generateVehicles(int fVehicles) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < fVehicles; i++) {
            vehicles.add(new Vehicle(i));
        }

        return vehicles;
    }

    private static List<Vehicle> getFreeVehicles(List<Vehicle> vehicles, int curStep) {
        List<Vehicle> freeVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (!vehicle.isBusy(curStep)) {
                freeVehicles.add(vehicle);
            }
        }

        return freeVehicles;
    }
}
