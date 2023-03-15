package com.example.manage;

import com.example.model.Manager;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Class to source parking configuration. Can be a database as well
 */

public class ParkingManager {
    static ParkingManager parkingmanager = new ParkingManager();


    public Manager initiateParking(String jsonFileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Manager manager = objectMapper.readValue(new File(jsonFileName), Manager.class);
        return manager;
    }
    public static ParkingManager getInstance(){
        return parkingmanager;
    }

    public static void main(String args[]){
        try {
            ParkingManager.getInstance().initiateParking("parking_data_1.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

