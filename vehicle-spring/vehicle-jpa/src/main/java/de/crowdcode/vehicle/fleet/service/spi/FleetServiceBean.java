package de.crowdcode.vehicle.fleet.service.spi;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.crowdcode.vehicle.domain.Vehicle;
import de.crowdcode.vehicle.fleet.dao.FleetDao;
import de.crowdcode.vehicle.fleet.domain.Fleet;
import de.crowdcode.vehicle.fleet.service.FleetService;
import de.crowdcode.vehicle.service.VehicleObserver;
import de.crowdcode.vehicle.service.VehicleService;

@Service
public class FleetServiceBean implements FleetService, VehicleObserver {
	
	@Autowired
	private FleetDao fleetDao;
	
	@Autowired
	private VehicleService vehicleService;
	
	@PostConstruct
	private void initialize() {
//	    vehicleService.	
	}

	@Override
	public void addVehicles(String companyName, List<Vehicle> vehicleList) {
		Fleet fleet = fleetDao.findByCompanyName(companyName);
		if (fleet == null) {
			fleet = new Fleet();
			fleet.setCompanyName(companyName);
			fleetDao.create(fleet);
		}
		fleet.getVehicles().addAll(vehicleList);
	}

	@Override
	public Fleet findFleetByName(String companyName) {
		return fleetDao.findByCompanyName(companyName);
	}

    @Override
    public List<String> allCompanyNames() {
        return fleetDao.findAllCompanyNames();
    }

    @Override
    public void onVehicleDelete(Vehicle vehicle) {
        // TODO Auto-generated method stub
        
    }

}
