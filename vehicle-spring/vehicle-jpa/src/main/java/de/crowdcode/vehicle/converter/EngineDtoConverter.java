package de.crowdcode.vehicle.converter;

import org.springframework.stereotype.Service;

import de.crowdcode.vehicle.domain.Engine;
import de.crowdcode.vehicle.dto.EngineDto;

@Service("engineDtoConverter")
public class EngineDtoConverter extends AbstractDefaultConverter<EngineDto, Engine>{

	@Override
	protected Engine newTargetInstance() {
		return new Engine();
	}

	@Override
	protected void copyProperties(EngineDto source, Engine target) {
		target.setId(source.getEngineId());
		target.setModel(source.getModel());
		target.setType(source.getEngineType());
	}
	 
}
