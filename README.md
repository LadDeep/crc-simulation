## Cyclic Redundancy Check(CRC)

### Overview

This repository presents a comprehensive implementation of the **Cyclic Redundancy Check (CRC)** algorithm. The `CRC` class provides functionalities to generate CRC remainder for a given bit string and validate the integrity of transmitted messages. 

Additionally, the repository includes the `CRCChecker` class, extending CRC capabilities to conduct experiments on error detection. Users can study the CRC's effectiveness in identifying errors by introducing random burst errors of varying lengths.


### CRC Simulation

This contains a class `CRC` for simulating the sending and receiving parts of the Cyclic Redundancy Check (CRC) algorithm. The implementation allows users to compute CRC remainder for a given bit string and generator polynomial, and check if a message is error-free. The CRC class provides methods for generating the remainder, creating a transmission message, and validating the integrity of a message.

#### Usage:

```
// Create CRC instance with a generator polynomial
CRC crc = new CRC("1101");

// Generate CRC remainder for a given message
int[] remainder = crc.generateRemainder("101101");

// Get the transmitted message with appended remainder
String transmittedMessage = crc.getTransmissionMessage("101101");

// Check if a message is error-free
boolean isErrorFree = crc.isMessageErrorFree("101101");
```

### Study of Error Detection Capability of CRC

The `CRCChecker` class extends the CRC functionality to perform an experiment on error detection. Users can specify the frame size, generator polynomial, and run experiments introducing random burst errors of varying lengths. The results are tabulated, indicating the experiment number, error length, and whether the error was detected.

The program utilizes random binary numbers, introduces burst errors, and checks for error detection, providing insights into the CRC's error detection capability.

#### Usage:

```
// Create CRCChecker instance with frame size and generator polynomial
CRCChecker crcChecker = new CRCChecker(1520, "1101");

// Run error detection experiment with varying burst lengths
crcChecker.checkErrors(50, 10, 50);
```
