package org.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
   public String getStats() {
        long total = vehicles.size();
        long available = vehicles.stream().filter(Vehicle::isAvailable).count();
        long rented = total - available;
        return String.format("Всього: %, Доступні: %, В оренді: %",
                total,available,rented);
   }
    public List<Vehicle> searchByPlate(String query) {
        String q = query.toLowerCase();
        return vehicles.stream()
                .filter(v -> v.getLicensePlate().toLowerCase().contains(q))
                .collect(Collectors.toList());
    }
}
