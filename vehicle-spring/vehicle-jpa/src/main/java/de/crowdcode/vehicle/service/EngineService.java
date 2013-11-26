package de.crowdcode.vehicle.service;

import java.util.List;

import de.crowdcode.vehicle.domain.Engine;
import de.crowdcode.vehicle.service.EngineDoesNotExistException;

public interface EngineService {
	
	public List<Engine> getAllEngines();

	public List<Engine> findByManufacturer(String manufacturerName);

	public void delete(Long engineId) throws EngineDoesNotExistException;

	public void createEngine(Engine engine);
	
}
