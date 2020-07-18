package com.codedifferently.phone;

import com.codedifferently.exceptions.InvalidPhoneNumberFormatException;

import java.util.logging.Logger;

public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {

        PhoneNumber[] array = new PhoneNumber[phoneNumberCount];
        for(int i=0; < phoneNumberCount; i++){
            array[i] = createRandomPhoneNumber();
        }
        return array;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        int areaCode= RandomNumberFactory.createInt(100,999);
        int officeCode= RandomNumberFactory.createInt(100,999);
        int lineCode= RandomNumberFactory.createInt(999,9999);

        return createPhoneNumberSafely(-1, -1, -1);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String ph = "(" + areaCode + ")";
        ph += "-" + centralOfficeCode;
        ph += "-" + phoneLineCode;

        try {
            return createPhoneNumber(ph);
        } catch (InvalidPhoneNumberFormatException e) {
            logger.info(ph + "is not a valid phone number");
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) {
        PhoneNumber ph = new PhoneNumber(phoneNumberString);

        if (!phoneNumberString.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
            throw new InvalidPhoneNumberFormatException();
        }
        return ph;
        }
    }
}
