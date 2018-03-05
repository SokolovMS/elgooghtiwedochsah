package com.eight.zero.three.algorithm.number1;

import com.eight.zero.three.algorithm.Utils;
import com.eight.zero.three.input.Input;
import com.eight.zero.three.input.PossibleRide;
import com.eight.zero.three.input.Vehicle;
import com.eight.zero.three.output.Output;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * I am just testing git plugin in Idea.
 */
public class Algorithm {
    public static Output run(final Input input) {
        LinkedList<PossibleRide> unassignedRides = new LinkedList<>(input.getRides());
        unassignedRides = Utils.sortRides(unassignedRides);
        List<Vehicle> vehicles = generateVehicles(input.getFVehicles());

        for (int curStep = 0; curStep < input.getTSteps(); curStep++) {
            List<Vehicle> freeVehicles = getFreeVehicles(vehicles, curStep);
            unassignedRides = reorderRides(unassignedRides);

            while (!freeVehicles.isEmpty() && !unassignedRides.isEmpty()) {
                Vehicle assignedVehicle = null;
                PossibleRide topRide = unassignedRides.removeFirst();

                for (Vehicle freeVehicle : freeVehicles) {
                    if (freeVehicle.canBeAssign(topRide)) {
                        freeVehicle.assignRide(topRide);
                        assignedVehicle = freeVehicle;
                    }
                }

                if (assignedVehicle != null) {
                    freeVehicles.remove(assignedVehicle);
                }
            }
        }

        return new Output(vehicles);
    }

    private static List<Vehicle> generateVehicles(int fVehicles) {
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < fVehicles; i++) {
            vehicles.add(new Vehicle(i));
        }

        return vehicles;
    }

    private static LinkedList<PossibleRide> reorderRides(LinkedList<PossibleRide> unassignedRides) {
        return Utils.sortRides(unassignedRides);
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
