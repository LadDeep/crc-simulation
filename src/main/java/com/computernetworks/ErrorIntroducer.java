package com.computernetworks;

import java.util.Random;

public class ErrorIntroducer {
    private String generateBurstError(int errorLength) {
        StringBuilder error = new StringBuilder(errorLength);

        Random random = new Random();
        for (int i = 0; i < errorLength; i++) {
            error.append(random.nextInt(2));
        }

        return error.toString();
    }

    public String introduceError(String frame, int errorLength) {
        if (frame == null || frame.isEmpty()) {
            throw new IllegalArgumentException("Frame cannot be null or empty.");
        }

        if (errorLength <= 0) {
            throw new IllegalArgumentException("Error length must be a positive integer.");
        }

        if (errorLength > frame.length()) {
            throw new IllegalArgumentException("Error length cannot be greater than frame size.");
        }

        String error = generateBurstError(errorLength);
        int errorPosition = new Random().nextInt(frame.length() - errorLength + 1);

        String frameWithErrors = frame.substring(0, errorPosition)
                + error
                + frame.substring(errorPosition + errorLength);

        return frameWithErrors;
    }
}
