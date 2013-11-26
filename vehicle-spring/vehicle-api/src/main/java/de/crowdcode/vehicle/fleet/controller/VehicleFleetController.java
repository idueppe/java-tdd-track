package de.crowdcode.vehicle.fleet.controller;

import java.util.List;

import de.crowdcode.vehicle.dto.FleetVehicleDto;

public interface VehicleFleetController {
	
	public List<FleetVehicleDto> getVehicleFleetByName(String companyName);

	public void addVehicles(String companyName, List<FleetVehicleDto> vehicleList);
	
	public List<String> allCompanyNames();

}
