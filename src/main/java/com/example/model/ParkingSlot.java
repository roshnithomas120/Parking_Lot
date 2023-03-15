package com.example.model;

import java.time.LocalDateTime;
import java.util.Date;

public class ParkingSlot {
    private int id;
    private boolean isOccupied;
    private Vehicle vehicle;
    private LocalDateTime parkedDate;

    public ParkingSlot(int id, boolean isOccupied, Vehicle vehicle) {
        this.id = id;
        this.isOccupied = isOccupied;
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public boolean getIsOccupied() {
        return isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getParkedDate() {
        return parkedDate;
    }

    public void setParkedDate(LocalDateTime parkedDate) {
        this.parkedDate = parkedDate;
    }
}
