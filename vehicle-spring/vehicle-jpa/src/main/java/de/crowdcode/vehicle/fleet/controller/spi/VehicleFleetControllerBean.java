package de.crowdcode.vehicle.fleet.controller.spi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.crowdcode.vehicle.domain.Vehicle;
import de.crowdcode.vehicle.dto.FleetVehicleDto;
import de.crowdcode.vehicle.fleet.controller.VehicleFleetController;
import de.crowdcode.vehicle.fleet.converter.FleetVehicleDtoConverter;
import de.crowdcode.vehicle.fleet.domain.Fleet;
import de.crowdcode.vehicle.fleet.service.FleetService;
import de.crowdcode.vehicle.service.VehicleService;

@Service()
@Transactional
public class VehicleFleetControllerBean implements VehicleFleetController {
	
	@Autowired
	private FleetService fleetService;

	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private FleetVehicleDtoConverter fleetVehicleDtoConverter;

	@Override
	public List<FleetVehicleDto> getVehicleFleetByName(String companyName) {
		Fleet fleet = fleetService.findFleetByName(companyName);
		if (fleet != null)
		{
		    return fleetVehicleDtoConverter.convert(fleet.getVehicles());
		} else {
		    return new LinkedList<>(); 
		}
	}

	@Override
	public void addVehicles(String companyName, List<FleetVehicleDto> vehicleList) {

		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		for (FleetVehicleDto dto : vehicleList) {
			Vehicle vehicle = vehicleService.getVehicleById(dto.getVehicleId());
			vehicles.add(vehicle);
		}
		
		fleetService.addVehicles(companyName, vehicles);
	}

    @Override
    public List<String> allCompanyNames() {
        return fleetService.allCompanyNames();
    }

}
