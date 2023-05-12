package org.yearup.model;

import java.util.ArrayList;
import java.util.Scanner;

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

    public ArrayList<Vehicle> getVehicleByPrice(double min, double max) {
        ArrayList<Vehicle> vehiclesInRange = new ArrayList<>();
        for (Vehicle vehicle : inventory) {

            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                vehiclesInRange.add(vehicle);
            }

        }

        return vehiclesInRange;
    }

    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model) {

        ArrayList<Vehicle> vehiclesByMakeModel = new ArrayList<>();

        for (Vehicle vehicle : inventory) {

            if (vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) {
                vehiclesByMakeModel.add(vehicle);
            }

        }

        return vehiclesByMakeModel;
    }

    public ArrayList<Vehicle> getVehicleByYear(int min, int max) {
        ArrayList<Vehicle> vehiclesInRange = new ArrayList<>();
        for (Vehicle vehicle : inventory) {

            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                vehiclesInRange.add(vehicle);
            }
        }

        return vehiclesInRange;
    }
        public ArrayList<Vehicle> getVehicleByColor(String color){

            ArrayList<Vehicle> vehicles = new ArrayList<>();
            for (Vehicle vehicle: inventory) {

                if (vehicle.getColor().equalsIgnoreCase(color)) {
                    vehicles.add(vehicle);
                }
            }

                return vehicles;

        }
        public ArrayList<Vehicle> getVehicleByMileage ( int min, int max)
        {
            ArrayList<Vehicle> vehiclesInRange = new ArrayList<>();
            for (Vehicle vehicle : inventory) {

                if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                    vehiclesInRange.add(vehicle);
                }

            }

            return vehiclesInRange;

        }
        public ArrayList<Vehicle> getVehicleByType (String vehicleType)
        {
            ArrayList<Vehicle> vehicles = new ArrayList<>();
            for (Vehicle vehicle: inventory) {

                if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                    vehicles.add(vehicle);
                }
            }

            return vehicles;
        }
        public ArrayList<Vehicle> getAllVehicle ()
        {

            return inventory;
        }

        public void addVehicle (Vehicle vehicle)
        {
            inventory.add(vehicle);
        }

        public void removeVehicle (int vin)
        {
            for (int i=0; i< inventory.size();i++){
                if(inventory.get(i).getVin() == vin){
                    inventory.remove(i);
                }
            }
        }

        public String getName () {
            return name;
        }

        public String getAddress () {
            return address;
        }

        public String getPhone () {
            return phone;
        }
    }
