package com.lsy.vehicle.security.dao;

import java.util.List;

import com.lsy.vehicle.security.domain.Role;
import com.lsy.vehicle.security.domain.User;
import com.lsy.vehicle.security.filter.UserFilterParameters;

public interface UserDao {
    
    public User find(Long id);

    public void create(User user);
    
    public void update(User user);

    public void delete(User user);

    public User findByUsername(String username);

    public List<User> findAll();

    public List<User> findAllOfRole(Role customer);
    
    public List<User> findAllCustomersNotMemberOfCompany(String companyName);
    
    public List<User> findByFilter(String username, String email, String firstName, String surename, Role role);
    
    public List<User> findByFilter(UserFilterParameters userFilter);

}
