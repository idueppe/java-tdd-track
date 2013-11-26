package de.crowdcode.vehicle.security.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.crowdcode.vehicle.converter.AbstractDefaultConverter;
import de.crowdcode.vehicle.security.domain.FleetGroup;
import de.crowdcode.vehicle.security.dto.FleetGroupDto;

@Component
public class FleetGroupConverter extends AbstractDefaultConverter<FleetGroup, FleetGroupDto>{
    
    @Autowired
    private UserConverter userConverter;

    @Override
    protected FleetGroupDto newTargetInstance() {
        return new FleetGroupDto();
    }

    @Override
    protected void copyProperties(FleetGroup source, FleetGroupDto target) {
        target.setCompanyName(source.getFleet().getCompanyName());
        target.setUsers(userConverter.convert(source.getUsers()));
    }
    
}
