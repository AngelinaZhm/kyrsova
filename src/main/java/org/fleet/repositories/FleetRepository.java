package org.fleet.repositories;

import org.fleet.models.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FleetRepository extends MongoRepository<Vehicle, String> {
    List<Vehicle> getByPlate(String plate);
    List<Vehicle> findAll();
    void deleteById(String id);
}
