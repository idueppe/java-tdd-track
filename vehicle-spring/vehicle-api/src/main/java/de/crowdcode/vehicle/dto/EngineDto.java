package de.crowdcode.vehicle.dto;

import java.io.Serializable;

import de.crowdcode.vehicle.domain.EngineType;

public class EngineDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long engineId;
    private EngineType engineType;
    private String model;

    public Long getEngineId() {
        return engineId;
    }

    public void setEngineId(Long engineId) {
        this.engineId = engineId;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
