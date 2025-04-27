package org.example.restcontroller;

import org.example.services.FleetService;
import org.example.models.Vehicle;
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
    public String stats() {
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
}
