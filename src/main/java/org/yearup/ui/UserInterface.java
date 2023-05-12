package org.yearup.ui;

import org.yearup.JavaHelpers.ColorCodes;
import org.yearup.model.Dealership;
import org.yearup.model.DealershipFileManager;
import org.yearup.model.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private DealershipFileManager dealershipFileManager = new DealershipFileManager();


    public UserInterface() {
    }

    private void init() {
        this.dealership = dealershipFileManager.getDealership();

    }

    public void display() {
        init();

        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        while (!userInput.equals("99"))
        {
            System.out.println("-".repeat(27));
            System.out.printf(ColorCodes.BLACK_BACKGROUND+"WELCOME TO %s"+ColorCodes.RESET+
                    "\n",dealership.getName());
            System.out.println("-".repeat(27));

            displayMenu();
            userInput = scanner.nextLine();
            processRequests(userInput);
        }


    }

    private void displayMenu() {
        System.out.println("1 - Find vehicle within price range");
        System.out.println("2 - Find vehicle by make / model");
        System.out.println("3 - Find vehicle by year");
        System.out.println("4 - Find vehicle by color");
        System.out.println("5 - Find vehicle by mileage range");
        System.out.println("6 - Find vehicle by type (car,truck,SUV,van)");
        System.out.println("7 - List All vehicle");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
        System.out.print("Select a Command: ");
    }

    private void processRequests(String userInput) {

        switch (userInput) {
            case "1": {
                processGetByPriceRequest();
                return;
            }
            case "2": {
                processGetByMakeModelRequest();
                return;
            }
            case "3": {
                processGetByYearRequest();
                return;
            }
            case "4": {
                processGetByColorRequest();
                return;
            }
            case "5": {
                processGetByMileageRequest();
                return;
            }
            case "6": {
                processGetByVehicleTypeRequest();
                return;
            }
            case "7": {
                processAllVehiclesRequest();
                return;
            }
            case "8": {
                processAddVehicleRequest();
                return;
            }
            case "9": {
                processRemoveVehicleRequest();
                return;
            }
            case "99": {
                System.out.println("Thanking you for using our service");
                return;
            }
            default:{
                System.out.println(ColorCodes.YELLOW +"Unrecognized Input!"+ColorCodes.RESET);
            }
        }
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scan = new Scanner(System.in);

        System.out.println("-".repeat(71));
        System.out.printf(ColorCodes.BLACK_BACKGROUND+"%-7s %-7s %-10s %-8s %-8s %-7s %-10s %-7s"+ColorCodes.RESET+"\n",
                "VIN","YEAR","MODEL","MAKE","TYPE","COLOR","MILEAGE","PRICE");
        System.out.println("-".repeat(71));

        for (Vehicle vehicle : vehicles) {
            stringBuilder.append(String.format("%-7d %-7d %-10s %-8s %-8s %-7s %-10d %-7.2f\n"+
                            "-".repeat(71)+"\n", vehicle.getVin(), vehicle.getYear() ,vehicle.getModel(),
                    vehicle.getMake(), vehicle.getVehicleType(), vehicle.getColor(),
                    vehicle.getOdometer(), vehicle.getPrice()));
        }

        System.out.println(stringBuilder.toString());
        System.out.print(ColorCodes.CYAN+"Press any key to continue: "+ColorCodes.RESET);
        scan.nextLine();
        System.out.println();
    }

    private void processAllVehiclesRequest() {

        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        displayVehicles(vehicles);

    }

    public void processGetByPriceRequest() {

        double min, max;

        Scanner scanNum = new Scanner(System.in);

        System.out.print("Enter the min (price range): ");
        min = scanNum.nextDouble();
        System.out.print("Enter the max (price range): ");
        max = scanNum.nextDouble();
        scanNum.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehicleByPrice(min, max);
        displayVehicles(vehicles);

    }

    public void processGetByMakeModelRequest() {
        String make, model;
        Scanner scanMakeModel = new Scanner(System.in);

        System.out.print("Enter the make of the vehicle: ");
        make = scanMakeModel.nextLine();
        System.out.print("Enter the model of the vehicle: ");
        model = scanMakeModel.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehicleByMakeModel(make, model);
        displayVehicles(vehicles);

    }

    public void processGetByYearRequest() {

        int min, max;

        Scanner scanNum = new Scanner(System.in);

        System.out.print("Enter the min (year range): ");
        min = scanNum.nextInt();
        System.out.print("Enter the max (year range): ");
        max = scanNum.nextInt();

        ArrayList<Vehicle> vehicles = dealership.getVehicleByYear(min,max);
        displayVehicles(vehicles);

    }

    public void processGetByColorRequest() {
        String color;

        Scanner scanNum = new Scanner(System.in);

        System.out.print("Enter the color of the vehicle: ");
        color = scanNum.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehicleByColor(color);
        displayVehicles(vehicles);

    }

    public void processGetByMileageRequest() {

        int min, max;

        Scanner scanNum = new Scanner(System.in);

        System.out.print("Enter the min (Mileage range): ");
        min = scanNum.nextInt();
        System.out.print("Enter the max (Mileage range): ");
        max = scanNum.nextInt();

        ArrayList<Vehicle> vehicles = dealership.getVehicleByMileage(min,max);
        displayVehicles(vehicles);

    }

    public void processGetByVehicleTypeRequest() {

        String vehicleType;
        Scanner scanNum = new Scanner(System.in);

        System.out.print("Enter the vehicle type: ");
        vehicleType = scanNum.nextLine();

        ArrayList<Vehicle> vehicles = dealership.getVehicleByType(vehicleType);
        displayVehicles(vehicles);

    }

    public void processAddVehicleRequest() {

        int vin;
        int year;
        String make;
        String model;
        String type;
        String color;
        int odometer;
        double price;
        Scanner scanCarDetails = new Scanner(System.in);

        System.out.printf("Enter the vehicle vin: ");
        vin = scanCarDetails.nextInt();
        System.out.printf("Enter the vehicle year: ");
        year = scanCarDetails.nextInt();
        scanCarDetails.nextLine();
        System.out.printf("Enter the vehicle make: ");
        make = scanCarDetails.nextLine();
        System.out.printf("Enter the vehicle model: ");
        model = scanCarDetails.nextLine();
        System.out.printf("Enter the vehicle type: ");
        type = scanCarDetails.nextLine();
        System.out.printf("Enter the vehicle color: ");
        color = scanCarDetails.nextLine();
        System.out.printf("Enter the vehicle odometer: ");
        odometer = scanCarDetails.nextInt();
        System.out.printf("Enter the vehicle price: ");
        price = scanCarDetails.nextDouble();

        dealership.addVehicle(new Vehicle(vin,year,make,model,type,color,odometer,price));
        dealershipFileManager.saveDealership(dealership);

    }

    public void processRemoveVehicleRequest() {

        int vin;
        Scanner scanVin = new Scanner(System.in);

        System.out.print("Enter the vehicles vin: ");
        vin = scanVin.nextInt();

        dealership.removeVehicle(vin);
        dealershipFileManager.saveDealership(dealership);

    }

}
