package org.example.models;

public abstract class Vehicle {
    private String licensePlate;
    private boolean available;

    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
        this.available = true;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    public abstract void displayInfo();
}
