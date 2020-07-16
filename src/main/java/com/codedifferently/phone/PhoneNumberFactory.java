package com.codedifferently.phone;

import com.codedifferently.exceptions.InvalidPhoneNumberFormatException;
import com.codedifferently.tools.RandomNumberFactory;

import java.util.logging.Logger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory extends RandomNumberFactory {
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
        PhoneNumber[] randomPhoneNumberArray = new PhoneNumber[phoneNumberCount];

        for (int i = 0; i < randomPhoneNumberArray.length; i++){
            randomPhoneNumberArray[i] = createRandomPhoneNumber();
        }
        return randomPhoneNumberArray;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        return createPhoneNumberSafely(createInteger(100, 999),createInteger(100, 999), createInteger(1000, 9999));
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException
     */ // TODO - if input is valid, return respective PhoneNumber object, else return
        // null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String phoneNumber="("+areaCode+")-"+centralOfficeCode+"-"+ phoneLineCode;
        try{
            return createPhoneNumber(phoneNumber);
        }catch(InvalidPhoneNumberFormatException e){
            logger.info(phoneNumber + " is not a valid phoneNumber");
            return null;
        }
       
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
    try{
        return new PhoneNumber(phoneNumberString);
     } catch (InvalidPhoneNumberFormatException e){
        logger.info("Attempting to create a new PhoneNumber object with a value of"+ phoneNumberString);
         throw e;
         }
    }
}
