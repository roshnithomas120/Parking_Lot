package com.example.model;

public class Vehicle {
    public enum VehicleType{BIKE("bike"),CAR("car"), BUS("bus");
        private String description;
        VehicleType(String description) {
            this.description = description;
        }
        public String getDescription(){
            return description;
        }
    };

    String vehicleModel;
    VehicleType vehicleType = VehicleType.CAR;
    String vehicleNumber;
    public Vehicle(String vehicleModel,VehicleType vehicleType, String vehicleNumber) {
        this.vehicleModel = vehicleModel;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }


    public String getVehicleModel(){
        return this.vehicleModel;
    }
    public VehicleType getVehicleType(){
        return this.vehicleType;
    }
    public String getVehicleNumber(){
        return this.vehicleNumber;
    }

}



