package org.fleet.models;

public class Car extends Vehicle {
    public Car(String plate, int seats, String model, int year) {
        super(plate, seats, model, year);
    }

    @Override
    public void displayInfo() {
        System.out.println("Авітомобіль : " + getPlate() + ", кількість місць : " + this.getSeats());
    }

}
