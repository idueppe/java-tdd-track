package de.crowdcode.vehicle.fleet.converter;

import org.springframework.stereotype.Service;

import de.crowdcode.vehicle.converter.AbstractDefaultConverter;
import de.crowdcode.vehicle.domain.Vehicle;
import de.crowdcode.vehicle.dto.FleetVehicleDto;

@Service
public class FleetVehicleDtoConverter extends AbstractDefaultConverter<Vehicle, FleetVehicleDto> {

	@Override
	protected FleetVehicleDto newTargetInstance() {
		return new FleetVehicleDto();
	}

	@Override
	protected void copyProperties(Vehicle source, FleetVehicleDto target) {
		target.setConstructionDate(source.getConstructionDate());
		target.setManufacturerName(source.getManufacturer().getName());
		// TODO OrderDate
		target.setVehicleModel(source.getModel());
	}

}
