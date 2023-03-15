package com.example.model;

import com.example.model.Price;
import com.example.model.Vehicle;

import java.util.List;

public class Parking {
    Vehicle.VehicleType type;
    int noOfSpots;
    List<Price> prices;
    Price.Scheme scheme;

    public Vehicle.VehicleType getType() {
        return type;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public int getNoOfSpots() {
        return noOfSpots;
    }

    public Price.Scheme getScheme() {
        return scheme;
    }
}
