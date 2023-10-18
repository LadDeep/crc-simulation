package com.computernetworks;

import java.util.Random;

public class CRCChecker extends CRC {
    private int byteSize;

    CRCChecker(int byteSize, String generator) {
        if (byteSize <= 0) {
            throw new IllegalArgumentException("Byte size must be a positive integer.");
        }
        this.setGenerator(generator);
        this.byteSize = byteSize;
    }

    /**
     * @param sampleSize used to set frames to check in bulk
     * @param minBurstLength is used to set minimum burst error to be introduced in the generated frame
     * @param maxBurstLength is used to set maximum burst error to be introduced in the generated frame
     */
    public void checkErrors(int sampleSize, int minBurstLength, int maxBurstLength) {
        if (minBurstLength > maxBurstLength) {
            throw new IllegalArgumentException("minBurstLength must be less than or equal to maxBurstLength.");
        }
        MessageGenerator generator = new MessageGenerator();
        String randomMessage = generator.generateRandom(byteSize);
        ErrorIntroducer errorIntroducer = new ErrorIntroducer();
        String corruptString;
        Random random = new Random();
        int burstErrorLength;
        boolean hasError;
        System.out.println("Experiment No.\t| " + "Error Length\t| " + "Error Detected?");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < sampleSize; i++) {
            burstErrorLength = random.nextInt(maxBurstLength - minBurstLength + 1) + minBurstLength;
            corruptString = errorIntroducer.introduceError(randomMessage, burstErrorLength);
            hasError = !isMessageErrorFree(corruptString);

            System.out.println("\t"+(i + 1) + "\t|\t" + burstErrorLength + "\t|\t" + (hasError?"Yes":"No"));
        }
    }

}
