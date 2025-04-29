package org.fleet.models;

public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String plate, double loadCapacity, int seats, String model, int year) {
        super(plate, seats, model, year);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Вантажівка : " + getPlate() + ", місткість : " + loadCapacity);
    }
}
