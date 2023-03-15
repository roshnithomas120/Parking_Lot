package com.example.model;

import com.example.exception.ImproperConfigurationException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLot {
/*    enum ParkingLotType{MALL("mall"),STADIUM ("stadium"),AIRPORT("airport");
        private String description;
        ParkingLotType(String description) {
            this.description = description;
        }
        public String getDescription(){
            return description;
        }
    };*/
    int latestParkingSlot = 0;
    List<Parking> parkings ;
    Map<Vehicle.VehicleType,List<ParkingSlot>> availableSlots = new HashMap<>();

    public ParkingLot(List<Parking> parkings) {
        this.parkings = parkings;
        createParkingSlots();
    }

    private void createParkingSlots() {
        for(Parking parking:parkings){
            if(availableSlots.containsKey(parking.type))
            {
                throw new ImproperConfigurationException("Duplicate definition for"+ parking.type);
            }
            latestParkingSlot++;
            List<ParkingSlot> parkingslots = availableSlots.get(parking.type);
            if(parkingslots==null) {
                parkingslots = new ArrayList<>();
                availableSlots.put(parking.type,parkingslots );
            }
            for(int i = 0;i<parking.getNoOfSpots();i++) {
                ParkingSlot parkingSlot = new ParkingSlot(latestParkingSlot, false, null);
                parkingslots.add(parkingSlot);
            }
        }
    }


    public List<ParkingSlot> getVacantSlots(Vehicle.VehicleType type){
        return availableSlots.get(type).stream().filter(s->!s.getIsOccupied()).collect(Collectors.toList());

    }

    public boolean canParkVehicle(Vehicle vehicle){
        return availableSlots.containsKey(vehicle.getVehicleType());
    }

    public List<ParkingSlot> getAvailableSlots(Vehicle.VehicleType type) {
        return availableSlots.get(type);
    }
}
