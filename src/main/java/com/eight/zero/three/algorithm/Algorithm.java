package com.eight.zero.three.algorithm;

import com.eight.zero.three.input.Input;
import com.eight.zero.three.input.Ride;
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
        LinkedList<Ride> unassignedRides = new LinkedList<>(input.getRides());
        unassignedRides = Utils.sortRides(unassignedRides);
        List<Vehicle> vehicles = generateVehicles(input.getFVehicles());

        for (int curStep = 0; curStep < input.getTSteps(); curStep++) {
            LinkedList<Vehicle> freeVehicles = getFreeVehicles(vehicles, curStep);
            unassignedRides = reorderRides(unassignedRides);

            while (!freeVehicles.isEmpty() || !unassignedRides.isEmpty()) {
                Vehicle freeVehicle = freeVehicles.removeFirst();
                Ride topRide = unassignedRides.removeFirst();
                freeVehicle.assignRide(topRide);
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

    private static LinkedList<Ride> reorderRides(LinkedList<Ride> unassignedRides) {
        return Utils.sortRides(unassignedRides);
    }

    private static LinkedList<Vehicle> getFreeVehicles(List<Vehicle> vehicles, int curStep) {
        LinkedList<Vehicle> freeVehicles = new LinkedList<>();
        for (Vehicle vehicle : vehicles) {
            if (!vehicle.isBusy(curStep)) {
                freeVehicles.addLast(vehicle);
            }
        }

        return freeVehicles;
    }
}
