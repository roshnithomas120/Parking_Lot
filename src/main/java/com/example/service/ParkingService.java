package com.example.service;

import com.example.exception.ParkingException;
import com.example.model.*;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingService {

    ParkingLot parkingLot;
    List<Parking> parkings;
    FeeService feeService = new FeeService();

    public ParkingService(List<Parking> parkings) {
        this.parkings = parkings;
        createParkingLot(parkings);
    }

    private ParkingLot createParkingLot(List<Parking> parkings){
        parkingLot =  new ParkingLot(parkings);
        return parkingLot;
    }

    public void parkVehicle(Vehicle vehicle){
        if(parkingLot.canParkVehicle(vehicle)){
            List<ParkingSlot> vacantSlots= parkingLot.getVacantSlots(vehicle.getVehicleType());
            if(vacantSlots.size()==0){
                throw new ParkingException("No vacant parking lot present for  "+ vehicle.getVehicleType());
            }
            ParkingSlot slot = vacantSlots.get(0);
            slot.setVehicle(vehicle);
            slot.setOccupied(true);
            slot.setParkedDate(LocalDateTime.now());
        }
        else{
            throw new ParkingException("Cannot park vehicle of type "+ vehicle.getVehicleType());
        }
    }

    public double unparkVehicle(Vehicle vehicle){
       Parking parking = parkings.stream().filter(p->p.getType()==vehicle.getVehicleType()).collect(Collectors.toList()).get(0);
       List<ParkingSlot> slots = parkingLot.getAvailableSlots(vehicle.getVehicleType()).stream().filter(s->s.getVehicle().getVehicleNumber()==vehicle.getVehicleNumber()).collect(Collectors.toList());
       if(slots.size()==0){
           throw new ParkingException("Vehicle with number "+vehicle.getVehicleNumber()+" is not parked");
       }
       return feeService.calculateFees(slots.get(0), parking);
    }
}


