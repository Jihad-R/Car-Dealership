package org.yearup.model;

import java.io.*;
import java.util.Scanner;

public class DealershipFileManager {

    private String[] dealershipDetails;
    public Dealership getDealership() {

        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream("inventory.csv");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }
        Scanner scanFile = new Scanner(fileInputStream);

        dealershipDetails = scanFile.nextLine().split("\\|");
        String name = dealershipDetails[0];
        String address = dealershipDetails[1];
        String phone = dealershipDetails[2];

        Dealership dealership = new Dealership(name, address, phone);

        while (scanFile.hasNextLine()) {

            String[] vehicleData = scanFile.nextLine().split("\\|");

            int vin = Integer.parseInt(vehicleData[0]);
            int year = Integer.parseInt(vehicleData[1]);
            String make = vehicleData[2];
            String model = vehicleData[3];
            String type = vehicleData[4];
            String color = vehicleData[5];
            int odometer = Integer.parseInt(vehicleData[6]);
            double price = Double.parseDouble(vehicleData[7]);


            dealership.inventory.add(new Vehicle(vin, year, make, model, type, color, odometer, price));
        }

        scanFile.close();


        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("inventory.csv", false); // Overwrite the existing file
            fileWriter.write(String.format("%s|%s|%s\n",dealershipDetails[0],dealershipDetails[1],dealershipDetails[2]));
            for (Vehicle vehicle : dealership.getAllVehicle()) {
                String s = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n", vehicle.getVin(), vehicle.getYear(),
                        vehicle.getModel(), vehicle.getMake(), vehicle.getVehicleType(), vehicle.getColor(),
                        vehicle.getOdometer(), vehicle.getPrice());
                fileWriter.write(s);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while writing to the file!");
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error occurred while closing the file!");
                }
            }
        }

    }
}
