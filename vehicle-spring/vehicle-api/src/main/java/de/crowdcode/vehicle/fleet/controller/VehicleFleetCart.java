package de.crowdcode.vehicle.fleet.controller;

import java.util.List;

import de.crowdcode.vehicle.dto.FleetVehicleDto;

public interface VehicleFleetCart {

    List<FleetVehicleDto> listCart();

    void remove(FleetVehicleDto vehicle);

    void close();

    void add(FleetVehicleDto fleetVehicle);

    void order(String companyName);

}
