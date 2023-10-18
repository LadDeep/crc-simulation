package com.computernetworks;

import java.util.Scanner;

public class CRCDemo {

    public static void main(String args[]) {
        CRC sender = new CRC();

        // Task to simulate CRC
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter Generator G(x): ");
        String generator = inputScanner.nextLine();
        System.out.print("Enter Message M(x): ");
        String message = inputScanner.nextLine();
        System.out.println("Transmission Message: "+sender.getTransmissionMessage(generator, message));
        inputScanner.close();

        // Task to study CRC Error checking
        CRCChecker checker = new CRCChecker(1520,"1000000000011011111011011111111");
        checker.checkErrors(50, 33, 40);
    }
}
