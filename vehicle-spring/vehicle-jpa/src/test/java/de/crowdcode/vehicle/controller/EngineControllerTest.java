package de.crowdcode.vehicle.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.crowdcode.vehicle.controller.EngineController;
import de.crowdcode.vehicle.controller.spi.DBFixture;
import de.crowdcode.vehicle.converter.EngineConverter;
import de.crowdcode.vehicle.dto.EngineDto;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class EngineControllerTest {
     
    @Autowired
    private EngineController engineController;
    
    @Autowired
    private DBFixture dbFixture;
    
    @Autowired
    private EngineConverter engineConverter;
    
    @Before
    public void setUp() {
        dbFixture.createDefaultDataInDatabase();
    }
    
    @After
    public void tearDown() {
        dbFixture.removeAll();
    }
    
    @Test
    public void testFindByManufacturer() {
    	List<EngineDto> found = engineController.byManufacturerName(DBFixture.MANUFACTURER_BUGGATI);
    	assertNotNull("EngineController must not return null.", found);
    	assertEquals("EngineController returns the wrong number of engines", 2, found.size());
    }
    
}
