package com.codedifferntly.phone;

import com.codedifferently.exceptions.InvalidPhoneNumberFormatException;
import com.codedifferntly.tools.RandomNumberFactory;

import java.util.logging.Logger;

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

        PhoneNumber [] arr = new PhoneNumber[phoneNumberCount];
        for(int i = 0; i < phoneNumberCount; i++){

            arr[i] = createRandomPhoneNumber();

        }

        return arr;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {

        int areaCode = RandomNumberFactory.createInteger(100,999);
        int officeCode = RandomNumberFactory.createInteger(100,999);
        int lineCode = RandomNumberFactory.createInteger(999,9999);
        return createPhoneNumberSafely(areaCode, officeCode, lineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode){

        String ph = "(" + areaCode + ")";
        ph += "-" + centralOfficeCode;
        ph += "-" + phoneLineCode;

        try{

           return createPhoneNumber(ph);
        } catch (InvalidPhoneNumberFormatException e){
            logger.info(ph + "is not a valid phone number");
            return null;
        }

    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {

        logger.info("Attempting to create a new PhoneNumber object with a value of " + phoneNumberString);
        PhoneNumber ph = new PhoneNumber(phoneNumberString);
        //validate phone number with format `(###)-###-####`
        if (!phoneNumberString.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {

            throw new InvalidPhoneNumberFormatException();

        }

        return ph;
    }
}
