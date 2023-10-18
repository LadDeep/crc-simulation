package com.computernetworks;

public class CRC {
    private String generator;

    CRC() {
    }

    CRC(String generator) {
        this.generator = generator;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public int[] generateRemainder(String message) {
        return this.generateRemainder(this.generator, message);
    }

    public int[] generateRemainder(String generator, String message) {
        int remainderLength = generator.length() - 1;
        int[] remainder = initializeRemainderArray(remainderLength);
        int xorBit;

        String appendedMessage = getAppendedMessage(message, remainder);
        for (int i = 0; i < appendedMessage.length(); i++) {
            xorBit = remainder[0];
            for (int j = 0; j < remainder.length - 1; j++) {

                remainder[j] = remainder[j + 1]
                        ^ (xorBit == 0 ? xorBit : Integer.valueOf(generator.charAt(j + 1) - 48));
            }
            remainder[remainder.length - 1] = (appendedMessage.charAt(i) - 48) ^ xorBit;
        }
        return remainder;
    }

    public String getTransmissionMessage(String generator, String message) {
        if (this.generator == null)
            this.generator = generator;
        return this.getTransmissionMessage(message);
    }

    public String getTransmissionMessage(String message) {
        int[] remainder = generateRemainder(message);
        String transmissionMessage = getAppendedMessage(message, remainder);
        return transmissionMessage.toString();
    }

    private String getAppendedMessage(String message, int[] secondMessage) {
        StringBuilder appendedString = new StringBuilder(message);
        for (int i : secondMessage) {
            appendedString.append(i);
        }
        return appendedString.toString();
    }

    private int[] initializeRemainderArray(int arrayLength) {
        int[] remainder = new int[arrayLength];

        for (int i = 0; i < remainder.length; i++) {
            remainder[i] = 0;
        }

        return remainder;
    }

    public String getActualMessage(String generator, String message) {
        boolean hasError = !isMessageErrorFree(generator, message);

        return hasError ? null : message.substring(0, message.length() - generator.length());
    }

    public boolean isMessageErrorFree(String message) {
        return isMessageErrorFree(generator, message);
    }

    public boolean isMessageErrorFree(String generator, String message) {
        int[] remainder = generateRemainder(generator, message);
        boolean isErrorDetacted = false;
        for (int bit : remainder) {
            if (bit != 0)
                return isErrorDetacted;
        }
        return !isErrorDetacted;
    }
}
