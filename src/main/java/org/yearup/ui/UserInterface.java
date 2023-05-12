package org.yearup.ui;

import org.yearup.model.Dealership;
import org.yearup.model.DealershipFileManager;
import org.yearup.model.Vehicle;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface
{
    private Dealership dealership;

    UserInterface(){}

    private void init()
    {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();

    }
    public void display()
    {
        init();
        String userInput = null;
        Scanner scanner = new Scanner(System.in);

        while (!userInput.equals("99"))
        {
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
            userInput = scanner.nextLine().toUpperCase();

            processRequest(userInput);
        }

    }

    private void processRequest(String userInput)
    {
        switch (userInput)
        {
            case "1":
            {
                processGetByPriceRequest();
                return;
            }
            case "2":
            {
                processGetByMakeModelRequest();
                return;
            }
            case "3":
            {
                processGetByYearRequest();
                return;
            }
            case "4": {
                processGetByColorRequest();
                return;
            }
            case "5":
            {
                processGetByMileageRequest();
                return;
            }
            case "6":
            {
                processGetByVehicleTypeRequest();
                return;
            }
            case "7":
            {
                processGetByAllVehicleRequest();
                return;
            }
            case "8":
            {
                processAddVehicleRequest();
                return;
            }
            case "9":
            {
                processRemoveVehicleRequest();
                return;
            }
            case "99":
            {
                System.out.println("Thanking you for using our service");
                return;
            }
        }
    }
    private void displayVehicles(ArrayList<Vehicle> vehicles){

        for (Vehicle vehicle: vehicles)
        {
            System.out.printf("%d %s %s %s %s %d %.2f",vehicle.getVin(),vehicle.getModel(),
                    vehicle.getMake(),vehicle.getVehicleType(),vehicle.getColor(),
                    vehicle.getOdometer(),vehicle.getPrice());
        }
    }
    private void processAllVehiclesRequests(){
        ArrayList<Vehicle> vehicles = dealership.getAllVehicle();
        displayVehicles(vehicles);
    }

    public void processGetByPriceRequest(){}
    public void processGetByMakeModelRequest(){}
    public void processGetByYearRequest(){}
    public void processGetByColorRequest(){}
    public void processGetByMileageRequest(){}
    public void processGetByVehicleTypeRequest(){}
    public void processGetByAllVehicleRequest(){}
    public void processAddVehicleRequest(){}

    public void processRemoveVehicleRequest(){}

}
