package de.crowdcode.vehicle.controller.spi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.crowdcode.vehicle.controller.EngineController;
import de.crowdcode.vehicle.converter.EngineConverter;
import de.crowdcode.vehicle.converter.EngineDtoConverter;
import de.crowdcode.vehicle.domain.Engine;
import de.crowdcode.vehicle.dto.EngineDto;
import de.crowdcode.vehicle.service.EngineDoesNotExistException;
import de.crowdcode.vehicle.service.EngineService;

@Service
public class EngineControllerBean implements EngineController {

	@Autowired
	private EngineService engineService;
	
	@Autowired
	private EngineConverter engineConverter;
	
	@Autowired
	private EngineDtoConverter engineDtoConverter;
	
	
	@Override
	public List<EngineDto> byManufacturerName(String manufacturerName) {
		List<Engine> engines = engineService.findByManufacturer(manufacturerName);
		return engineConverter.convert(engines);
	}
	
	@Override
	public void addEngine(EngineDto engine) {
		engineService.createEngine(engineDtoConverter.convert(engine));
	}

	@Override
	public void deleteEngine(EngineDto engine) throws EngineDoesNotExistException {
		engineService.delete(engine.getEngineId());
	}

}
