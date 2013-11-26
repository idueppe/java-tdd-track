package de.crowdcode.vehicle.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.crowdcode.vehicle.controller.ManufacturerController;
import de.crowdcode.vehicle.dto.ManufacturerDto;
import de.crowdcode.vehicle.service.ManufacturerAlreadyExistsException;

@Service
@WebService
public class ManufacturerWS {

    @Autowired
    private ManufacturerController controller;
    
    @WebMethod
    public List<ManufacturerDto> allManufactures()
    {
        return controller.allManufactures();
    }
    
    @WebMethod
    public void addManufacturer(String manufacturerName) throws ManufacturerAlreadyExistsException
    {
        controller.addManufacturer(manufacturerName);
    }
    
}
