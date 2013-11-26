package de.crowdcode.vehicle.controller;

import java.util.List;

import de.crowdcode.vehicle.dto.ManufacturerDto;
import de.crowdcode.vehicle.service.ManufacturerAlreadyExistsException;

public interface ManufacturerController {

    public ManufacturerDto byName(String manufacturerName);
    
    public List<ManufacturerDto> allManufactures();
    
    public void addManufacturer(String manufacturerName) throws ManufacturerAlreadyExistsException;
    
    public void deleteManufacturer(String manufacturerName);

    public void updateManufacturerName(ManufacturerDto selectedManufacturer);
    
}
