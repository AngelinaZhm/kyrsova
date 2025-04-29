package org.fleet.services;

import org.fleet.dtos.VehicleStats;
import org.fleet.models.Car;
import org.fleet.models.Vehicle;
import org.fleet.repositories.FleetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FleetService {
    @Autowired
    private FleetRepository fleetRepository;

    private List<Vehicle> vehicles = new ArrayList<>();

    public FleetService() {
    }

    public List<Vehicle> getVehicles() {
        return fleetRepository.findAll();
    }

    public void rentVehicle(String plate) {
        Vehicle vehicle = fleetRepository.getByPlate(plate).stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));
        vehicle.setUnavailable();
        fleetRepository.save(vehicle);
    }

    public void returnVehicle(String plate) {
        Vehicle vehicle = fleetRepository.getByPlate(plate).stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));
        vehicle.setAvailable();
        fleetRepository.save(vehicle);
    }

    public List<Vehicle> getAvailableVehicles() {
        return fleetRepository.findAll().stream()
                .filter(Vehicle::isAvailable)
                .collect(Collectors.toList());
   }

    public VehicleStats getStats() {
        vehicles = fleetRepository.findAll();
        if (vehicles.isEmpty()) {
            return new VehicleStats(0, 0, 0);
        }

        int total = vehicles.size();
        int available = (int) vehicles.stream().filter(Vehicle::isAvailable).count();
        int rented = total - available;

        return new VehicleStats(total, available, rented);
    }

    public List<Vehicle> searchByPlate(String query) {
        String q = query.toLowerCase();

        return fleetRepository.findAll().stream()
                .filter(vehicle -> vehicle.getPlate().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }

    public void addVehicle(String plate, int seats, String model, int year) {
        fleetRepository.save(new Car(plate, seats, model, year));
    }

    public void deleteVehicle(String plate) {
        Vehicle vehicle = fleetRepository.getByPlate(plate).get(0);
        if (vehicle == null) {
            throw new IllegalArgumentException("Авто з цим номерним знаком : " + plate + " не знайдено.");
        }

        fleetRepository.deleteById(plate);
    }

}
