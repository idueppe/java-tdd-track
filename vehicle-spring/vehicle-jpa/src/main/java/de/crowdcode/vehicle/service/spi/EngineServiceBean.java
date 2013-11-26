package de.crowdcode.vehicle.service.spi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.crowdcode.vehicle.dao.EngineDao;
import de.crowdcode.vehicle.domain.Engine;
import de.crowdcode.vehicle.service.EngineDoesNotExistException;
import de.crowdcode.vehicle.service.EngineService;

@Service("engineService")
public class EngineServiceBean implements EngineService {

	@Autowired
	private EngineDao engineDao;
	
	@Override
	public List<Engine> getAllEngines() {
		return engineDao.findAll();
	}

	@Override
	public List<Engine> findByManufacturer(String manufacturerName) {
		return engineDao.findByManufacturer(manufacturerName);
	}

	@Override
	@Transactional
	public void delete(Long engineId) throws EngineDoesNotExistException {
		Engine engine = engineDao.find(engineId);
		if (engine == null) {
			throw new EngineDoesNotExistException(engineId);
		}
		engineDao.delete(engine);
	}
	
	@Override
	public void createEngine(Engine engine) {
		engineDao.create(engine);
	}

}
