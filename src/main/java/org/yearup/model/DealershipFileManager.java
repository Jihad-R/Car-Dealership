package org.yearup.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DealershipFileManager {

    public Dealership getDealership(){

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("inventory.csv");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }
        Scanner scanFile = new Scanner(fileInputStream);

        String[] dealershipDetails = scanFile.nextLine().split("\\|");
        String name = dealershipDetails[0];
        String address = dealershipDetails[1];
        String phone = dealershipDetails[2];

        Dealership dealership = new Dealership(name,address,phone);

        scanFile.close();

        return  dealership;
    }

    public void saveDealership(Dealership dealership){

    }

}
