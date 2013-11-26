package de.crowdcode.vehicle.controller;

import java.util.List;

import de.crowdcode.vehicle.dto.EngineDto;
import de.crowdcode.vehicle.service.EngineDoesNotExistException;

public interface EngineController {

    public List<EngineDto> byManufacturerName(String manufacturerName);
    
    public void addEngine(EngineDto engine);
    
    public void deleteEngine(EngineDto engine) throws EngineDoesNotExistException;
    
}
