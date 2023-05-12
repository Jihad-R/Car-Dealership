package org.yearup.model;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public ArrayList<Vehicle> getVehicleByPrice(double min,double max)
    {
        return null;
    }

    public ArrayList<Vehicle> getVehicleByMakeModel(String make,String model)
    {
        return null;
    }
    public ArrayList<Vehicle> getVehicleByYear(int min,int max)
    {
        return null;
    }
    public ArrayList<Vehicle> getVehicleByMakeModel(String color)
    {}
    public ArrayList<Vehicle> getVehicleByMileage(int min,int max)
    {
        return null;
    }
    public ArrayList<Vehicle> getVehicleByType(String vehicleType)
    {
        return null;
    }
    public ArrayList<Vehicle> getAllVehicle()
    {

        return inventory;
    }

    public void addVehicle(Vehicle vehicle)
    {
        inventory.add(vehicle);
    }

    public void removeVehicle()
    {}

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
