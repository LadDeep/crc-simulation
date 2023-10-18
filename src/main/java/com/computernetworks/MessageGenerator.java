package com.computernetworks;

import java.util.Random;

public class MessageGenerator {
    public String generateRandom(int byteSize) {

        Random random = new Random();
        StringBuilder binaryString = new StringBuilder(byteSize * 8);

        for (int i = 0; i < byteSize; i++) {
            int randomByte = random.nextInt(256);
            String binaryByte = Integer.toBinaryString(randomByte);

            while (binaryByte.length() < 8) {
                binaryByte = "0" + binaryByte;
            }

            binaryString.append(binaryByte);
        }

        return binaryString.toString();
    }
}
