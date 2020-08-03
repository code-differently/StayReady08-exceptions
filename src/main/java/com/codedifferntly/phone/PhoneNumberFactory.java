package com.codedifferntly.phone;

import com.codedifferently.exceptions.InvalidPhoneNumberFormatException;
import com.codedifferently.tools.RandomNumberFactory;
import java.security.InvalidParameterException;
import java.util.Random;
import java.util.logging.Logger;



/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    public PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber[] randomPhoneNumbers = new PhoneNumber[phoneNumberCount];
        for(int i=0; i < phoneNumberCount; i++){
            randomPhoneNumbers[i] = createRandomPhoneNumber();
        }
        return randomPhoneNumbers;
    }


    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        int areaCode = RandomNumberFactory.createInteger(100,999);
        int centralOfficeCode = RandomNumberFactory.createInteger(100,999);
        int phoneLineCode = RandomNumberFactory.createInteger(1000,9999);
        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String pNum = "(" + areaCode + ")" + "-" + centralOfficeCode + "-" + phoneLineCode;
        PhoneNumber p;
        try{
            p = createPhoneNumber(pNum);
        } catch(InvalidPhoneNumberFormatException e){
            logger.info(pNum + "is not a valid phone number");
            return null;
        }
        return  p;
        //return createPhoneNumber(null);
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException{
        PhoneNumber phoneNum = new PhoneNumber(phoneNumberString);
        logger.info("Attempting to create a new PhoneNumber object with a value of " + phoneNumberString);
        if (!phoneNumberString.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
            throw new InvalidPhoneNumberFormatException();
        }
        return phoneNum;
    }
}
