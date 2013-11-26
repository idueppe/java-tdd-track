package de.crowdcode.vehicle.fleet.doa.jpa;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import de.crowdcode.vehicle.controller.spi.DBFixture;
import de.crowdcode.vehicle.domain.EngineType;
import de.crowdcode.vehicle.fleet.dao.spi.jpa.DBFixtureFleets;
import de.crowdcode.vehicle.fleet.dao.spi.jpa.FleetJpaDao;
import de.crowdcode.vehicle.fleet.domain.EngineInfo;
import de.crowdcode.vehicle.fleet.domain.Fleet;
import de.crowdcode.vehicle.security.dao.spi.DBFixtureUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional
public class FleetDaoTest {

    @Autowired
    private FleetJpaDao dao;
    
    @Autowired
    private DBFixture dbFixture;
    
    @Autowired
    private DBFixtureFleets dbFixtureFleets;
    
    @Autowired
    private DBFixtureUser dbFixtureUser;
    
    @BeforeTransaction
    public void setUp() {
        dbFixture.createDefaultDataInDatabase();
        dbFixtureFleets.createDefaultDataInDatabase();
        dbFixtureUser.createDefaultDataInDatabase();
    }
    
    @AfterTransaction
    public void tearDown() {
        dbFixtureUser.removeAll();
        dbFixtureFleets.removeAll();
        dbFixture.removeAll();
    }
    
    @Test
    public void testPersitFleet() throws Exception {
        Fleet fleet = new Fleet();
        dao.create(fleet);
        assertNotNull(fleet.getId());
    }
    
    @Test
    public void testGetAllCompanyNames() throws Exception {
        List<String> names = dao.findAllCompanyNames();
        assertNotNull(names);
        assertFalse(names.isEmpty());
        assertEquals("crowdcode", names.get(0));
    }
    
    @Test
    public void testEngineReport() throws Exception {
        List<EngineInfo> report = dao.getEngineReport(DBFixtureFleets.COMPANY_NAME);
        assertNotNull(report);
        assertFalse(report.isEmpty());
        
        System.out.println(Arrays.toString(report.toArray()));
        
        Map<EngineType, Long> map = toMap(report);
        
        assertTrue(map.containsKey(EngineType.PETROL));
        assertEquals(Long.valueOf(1L), map.get(EngineType.PETROL));
        assertTrue(map.containsKey(EngineType.DIESEL));
        assertEquals(Long.valueOf(2L), map.get(EngineType.DIESEL));
    }
    
    private Map<EngineType, Long> toMap(List<EngineInfo> infos)
    {
    	Map<EngineType, Long> map = new HashMap<>();
    	for (EngineInfo info : infos)
    		map.put(info.getEngineType(), info.getQuantity());
    	return map;
    }
}
