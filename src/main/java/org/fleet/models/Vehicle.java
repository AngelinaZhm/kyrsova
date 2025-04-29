package org.fleet.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicles")
public abstract class Vehicle {
    @Id
    private String id;
    private final String plate;
    private int seats;
    private boolean available;
    private String model;
    private int year;

    public Vehicle(String plate, int seats, String model, int year) {
        this.id = plate;
        this.plate = plate;
        this.seats = seats;
        this.available = true;
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPlate() {
        return plate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable() {
        this.available = true;
    }

    public void setUnavailable() {
        this.available = false;
    }

    public int getSeats() {
        return seats;
    }

    public abstract void displayInfo();
}
