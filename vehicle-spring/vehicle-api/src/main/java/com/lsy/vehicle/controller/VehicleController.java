package com.lsy.vehicle.controller;

import java.util.List;

import com.lsy.vehicle.dto.VehicleDto;

public interface VehicleController {

    public List<VehicleDto> findVehicleByManufacturer(String manufacturerName);
    
    public void saveOrUpdateVehicle(VehicleDto vehicle);
    
    public void deleteVehicle(VehicleDto vehicle);

    public VehicleDto getVehicle(Long id);
    
}
