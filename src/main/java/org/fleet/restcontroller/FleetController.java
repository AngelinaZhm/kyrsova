package org.fleet.restcontroller;

import org.fleet.dtos.VehicleStats;
import org.fleet.services.FleetService;
import org.fleet.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class FleetController {
    @Autowired
    private FleetService fleetService;
//    Список усіх авто
    @GetMapping("/all")
    public List<Vehicle> all() {
        return fleetService.getVehicles();
    }
//    Доступні авто
    @GetMapping("/available")
    public List<Vehicle> available() {
        return fleetService.getAvailableVehicles();
    }
//    Статистика автопарку
    @GetMapping("/stats")
    public VehicleStats stats() {
        return fleetService.getStats();
    }
//    Пошук за частиною номера
    @GetMapping("/search")
    public List<Vehicle> search(@RequestParam String q) {
        return fleetService.searchByPlate(q);
    }
//    Оренда авто
    @PostMapping("/rent")
    public void rent(@RequestParam String plate) {
        fleetService.rentVehicle(plate);
    }
//    Повернення авто
    @PostMapping("/return")
    public void returnBack(@RequestParam String plate) {
        fleetService.returnVehicle(plate);
    }
    @PostMapping("/addVehicle")
    public void addVehicle(@RequestParam String plate, @RequestParam int seats) {
        fleetService.addVehicle(plate, seats);
    }
    @DeleteMapping("/deleteVehicle")
    public void deleteVehicle(@RequestParam String plate) {
        fleetService.deleteVehicle(plate);
    }
}
