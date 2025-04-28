package org.fleet.services;

import org.fleet.dtos.VehicleStats;
import org.fleet.models.Car;
import org.fleet.models.Vehicle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FleetService {
    private List<Vehicle> vehicles = new ArrayList<>();

    public FleetService() {
        vehicles.add(new Car("ВС2272КН",5));
        vehicles.add(new Car("АІ5634МС",8));
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    public void rentVehicle(String plate) {
        vehicles.stream()
                .filter(vehicle -> vehicle.getLicensePlate().equals(plate) && vehicle.isAvailable())
                .findFirst()
                .ifPresent(vehicle -> vehicle.setAvailable(false));
    }
    public void returnVehicle(String plate) {
        vehicles.stream()
                .filter(vehicle -> vehicle.getLicensePlate().equals(plate) && !vehicle.isAvailable())
                .findFirst()
                .ifPresent(vehicle -> vehicle.setAvailable(true));
    }
   public List<Vehicle> getAvailableVehicles() {
        return vehicles.stream()
                .filter(Vehicle::isAvailable)
                .collect(Collectors.toList());
   }

    public VehicleStats getStats() {
        long total = vehicles.size();
        long available = vehicles.stream().filter(Vehicle::isAvailable).count();
        long rented = total - available;

        return new VehicleStats(total, available, rented);
    }

    public List<Vehicle> searchByPlate(String query) {
        String q = query.toLowerCase();
        return vehicles.stream()
                .filter(v -> v.getLicensePlate().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
    public void addVehicle(String plate, int seats) {
        boolean exists = vehicles.stream()
                .anyMatch(v -> v.getLicensePlate().equalsIgnoreCase(plate));
        if (exists) {
            throw new IllegalArgumentException("Авто з цим номерним знаком : " + plate + " вже зареєстровано.");
        }
        vehicles.add(new Car(plate, seats));
    }
    public void deleteVehicle(String plate) {
        boolean removed = vehicles.removeIf(vehicle -> vehicle.getLicensePlate().equalsIgnoreCase(plate));
        if (!removed) {
            throw new IllegalArgumentException("Авто з цим номерним знаком : " + plate + " не знайдено.");
        }
    }

}
