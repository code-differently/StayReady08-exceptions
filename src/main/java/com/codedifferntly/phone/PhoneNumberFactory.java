package com.codedifferntly.phone;

import com.codedifferently.exceptions.InvalidPhoneNumberFormatException;

import java.util.logging.Logger;
import java.util.Random;
/**
 * Created by leon on 5/1/17.
 */
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
        return null;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        //will convert these string into integers
        int area = putRandomNumbersIntoSlot(3);
        int centralOfficeCode = putRandomNumbersIntoSlot(3);
        int phoneLineCode = putRandomNumbersIntoSlot(4);

        return createPhoneNumberSafely(area, centralOfficeCode, phoneLineCode);
    }

    private static int putRandomNumbersIntoSlot(int totalNumDigits) {
        Random random = new Random();
        String value = "";
        int rangeOfValues = 9;
        int offset = 1;

        for(int whichDigit = 0; whichDigit < totalNumDigits; whichDigit++) {
            value += random.nextInt(rangeOfValues) + offset;
        }

        return Integer.parseInt(value);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String phoneNumber = "(" + areaCode + ")-" + centralOfficeCode + "-" + phoneLineCode;
        try {
            return createPhoneNumber(phoneNumber);
        }
        catch(InvalidPhoneNumberFormatException invalidPhoneNumber) {
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        PhoneNumber phoneNumber = null;
        try {
           phoneNumber = new PhoneNumber(phoneNumberString);
       }
       catch (InvalidPhoneNumberFormatException invalidPhoneNumber){
           throw new InvalidPhoneNumberFormatException();
        }
        return phoneNumber;
    }
}
