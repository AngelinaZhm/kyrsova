package org.fleet.models;

public class Car extends Vehicle {
    private int seatCount;

    public Car(String licensePlate, int seatCount) {
        super(licensePlate);
        this.seatCount = seatCount;
    }

    @Override
    public void displayInfo() {
        System.out.println("Авітомобіль : " + getLicensePlate() + ", кількість місць : " + seatCount);
    }

}
