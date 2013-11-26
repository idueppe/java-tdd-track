package de.crowdcode.vehicle.dao;

import java.util.List;

import de.crowdcode.vehicle.domain.Engine;

public interface EngineDao extends EntityDao<Engine>{

	List<Engine> findByManufacturer(String manufacturerName);

}
