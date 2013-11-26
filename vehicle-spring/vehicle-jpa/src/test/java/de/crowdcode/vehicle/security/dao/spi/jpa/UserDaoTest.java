package de.crowdcode.vehicle.security.dao.spi.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import de.crowdcode.vehicle.controller.spi.DBFixture;
import de.crowdcode.vehicle.fleet.dao.spi.jpa.DBFixtureFleets;
import de.crowdcode.vehicle.security.dao.spi.DBFixtureUser;
import de.crowdcode.vehicle.security.dao.spi.UserDaoBean;
import de.crowdcode.vehicle.security.domain.Role;
import de.crowdcode.vehicle.security.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext.xml"})
@Transactional
public class UserDaoTest {

    @Autowired
    private UserDaoBean dao;
    
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
    public void testCreateUnitUser() {
        User user = new User();
        user.setFirstname("J");
        user.setSurename("Unit");
        user.setUsername("junit");
        user.setEmail("j@unit");
        user.setRole(Role.AGENT);
        dao.create(user);
        assertNotNull(user.getId());
    }
    
    @Test
    @Transactional
    public void testFindDummyUsers() {
        User admin = dao.findByUsername("admin");
        assertEquals(Role.ADMIN, admin.getRole());
        
        User agent = dao.findByUsername("agent");
        assertEquals(Role.AGENT, agent.getRole());
        
        User customer = dao.findByUsername("customer");
        assertEquals(Role.CUSTOMER, customer.getRole());
    }
    
    @Test
    public void testFindByRole() {
        List<User> customers = dao.findAllOfRole(Role.CUSTOMER);
        for (User user : customers) {
            assertEquals(Role.CUSTOMER, user.getRole());
        }
    }
    
    @Test
    @Transactional
    public void testFindNotMembers() {
        User user = buildUser(Role.CUSTOMER);
        dao.create(user);
        
        System.out.println("-----------------------------------------------------------------");
        
        List<User> users = dao.findAllCustomersNotMemberOfCompany(DBFixtureUser.COMPANY_NAME);
        System.out.println("-----------------------------------------------------------------");

        assertNotNull(users);
        assertFalse(users.isEmpty());
        
        assertEquals(user, users.get(0));
    }

    @Test
    public void testFindNotMembersForNotExistingCompany() {
        List<User> users = dao.findAllCustomersNotMemberOfCompany("DOES-NOT-EXISTS-"+UUID.randomUUID());
        assertNotNull(users);
        assertTrue(users.isEmpty());
    }
    
    private User buildUser(Role role) {
        User user = new User();
        user.setFirstname("J");
        user.setSurename("Unit");
        user.setUsername("junit");
        user.setEmail("j@unit");
        user.setRole(role);
        return user;
    }         
       
    
}
