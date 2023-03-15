package com.example.service;

import com.example.model.Parking;
import com.example.model.ParkingSlot;
import com.example.model.Price;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class FeeService {

    public double calculateFees(ParkingSlot slot, Parking parking) {
        LocalDateTime parkedDateTime = slot.getParkedDate();
        long parkedTimeInMillis = parkedDateTime.toInstant(ZoneOffset.ofTotalSeconds(0)).toEpochMilli();
        long currentTimeinMillis = Instant.now().toEpochMilli();
        long parkedDuration = currentTimeinMillis - parkedTimeInMillis;
        List<Price> prices = parking.getPrices();
        int durationhours = (int) ((parkedDuration / (1000 * 60 * 60)) % 24);
        int spareMinutes = (int) ((parkedDuration / (1000 * 60 * 60)) / 24) * 60;
        if (spareMinutes > 0) durationhours += durationhours;
        double fees = 0;
        if (parking.getScheme() == Price.Scheme.ADDUP) {
            for (Price price : prices) {
                if (durationhours > price.getStartHour()) {
                    if (price.getScheme() == null) {
                        fees = fees + price.getFees();
                    } else {
                        //scheme within duration calculation
                    }
                }
            }
        }
        if (parking.getScheme() == Price.Scheme.FLAT) {
            for (Price price : prices) {
                if (durationhours > price.getStartHour() && durationhours < price.getEndHour()) {
                    if (price.getScheme() == null) {
                        fees = price.getFees();
                        break;
                    } else {

                    }
                }
            }

        }
        return fees;
    }
}
