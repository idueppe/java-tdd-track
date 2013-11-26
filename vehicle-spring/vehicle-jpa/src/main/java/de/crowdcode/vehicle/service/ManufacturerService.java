package de.crowdcode.vehicle.service;

import java.util.List;

import de.crowdcode.vehicle.domain.Manufacturer;
import de.crowdcode.vehicle.service.ManufacturerAlreadyExistsException;

public interface ManufacturerService {
    
    public List<Manufacturer> findAll();
    
    public void addManufacturer(String manufacturerName) throws ManufacturerAlreadyExistsException;
    
    public Manufacturer byName(String manufacturerName);

    public boolean isExisting(String manufacturerName);
    
    public void delete(Manufacturer manufacturer);

    public void updateName(Long manufacturerId, String newManufacturerName);
    
}
