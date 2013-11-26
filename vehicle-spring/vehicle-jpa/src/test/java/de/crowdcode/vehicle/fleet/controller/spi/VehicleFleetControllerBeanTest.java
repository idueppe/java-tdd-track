package de.crowdcode.vehicle.fleet.controller.spi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import de.crowdcode.vehicle.domain.Vehicle;
import de.crowdcode.vehicle.dto.FleetVehicleDto;
import de.crowdcode.vehicle.fleet.controller.spi.VehicleFleetControllerBean;
import de.crowdcode.vehicle.fleet.converter.FleetVehicleDtoConverter;
import de.crowdcode.vehicle.fleet.domain.Fleet;
import de.crowdcode.vehicle.fleet.service.FleetService;
import de.crowdcode.vehicle.service.VehicleService;

@RunWith(MockitoJUnitRunner.class)
public class VehicleFleetControllerBeanTest {

    @InjectMocks
    private VehicleFleetControllerBean fleetController;
    
    @Mock
    private VehicleService vehicleService;
    
    @Mock
    private FleetService fleetService;
    
    @Mock
    private FleetVehicleDtoConverter converter;
    
    @Test
    public void testGetVehicleFleetByUnknownName() throws Exception {
        // given
        // when
        List<FleetVehicleDto> result = 
                        fleetController.getVehicleFleetByName("companyName");
        // then
        assertNotNull(result);
        verify(converter, never()).convert(anyListOf(Vehicle.class));
    }
    
    
    
    @Test
    public void testGetVehicleFleetByKnownName() throws Exception {
        // given
        Fleet fleet = new Fleet();
        fleet.getVehicles().add(new Vehicle());

        when(fleetService.findFleetByName("companyName")).thenReturn(fleet);

        // when
        fleetController.getVehicleFleetByName("companyName");
        
        // then  
        verify(fleetService, times(1)).findFleetByName(eq("companyName"));
        verify(converter, times(1)).convert(eq(fleet.getVehicles()));
    }
    
    @Test
    public void testConvertingOfGetVehicleFleetByName() throws Exception {
        // given
        FleetVehicleDto fleetVehicleDto = new FleetVehicleDto();
        
        when(fleetService.findFleetByName("companyName")).thenReturn(new Fleet());
        when(converter.convert(anyListOf(Vehicle.class)))
            .thenReturn(Arrays.asList(fleetVehicleDto)); 
        // when
        List<FleetVehicleDto> result = 
                        fleetController.getVehicleFleetByName("companyName");
        // then  
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(fleetVehicleDto, result.get(0));
    }
    
    
    
    
    
    
    
    
    
    
    
}
