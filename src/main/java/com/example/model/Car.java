package com.example.model;

public class Car extends Vehicle{
    public Car(String vehicleModel, String vehicleNumber) {
        super(vehicleModel, VehicleType.CAR, vehicleNumber);
    }
}
