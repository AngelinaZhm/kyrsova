package org.example;

public class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String licensePlate, double loadCapacity) {
        super(licensePlate);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Вантажівка : " + getLicensePlate() + ", місткість : " + loadCapacity);
    }
}
