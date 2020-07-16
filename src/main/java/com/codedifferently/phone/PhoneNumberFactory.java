package com.codedifferently.phone;

import com.codedifferently.exceptions.InvalidPhoneNumberFormatException;

import java.util.logging.Logger;
import com.codedifferently.tools.RandomNumberFactory;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory extends RandomNumberFactory{
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ 
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber[] randomPhoneNumberArray = new PhoneNumber[phoneNumberCount];

        for (int i = 0; i < randomPhoneNumberArray.length; i++){
            randomPhoneNumberArray[i] = createRandomPhoneNumber();
        }
        return randomPhoneNumberArray;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ 
    public static PhoneNumber createRandomPhoneNumber() {
        int areaCode = RandomNumberFactory.createInteger(100,999);
        int centralOfficeCode = RandomNumberFactory.createInteger(100,999);
        int phoneLineCode = RandomNumberFactory.createInteger(1000, 9999);
        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ 
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        // if (areaCode.toString.length()==3&&centralOfficeCode.toString.length()==3&&phoneLineCode.toString.length()==4) {
        //     return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);
        // }
        String phoneNumber ="("+areaCode+")-"+centralOfficeCode+"-"+ phoneLineCode;
        try{
            return createPhoneNumber(phoneNumber);
        } catch(InvalidPhoneNumberFormatException e){
            logger.info(phoneNumber + "is not a valid phoneNumber");
            return null;

            }
        }
        


    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ 
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
       /*
        if (!phoneNumberString.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
            throw new InvalidPhoneNumberFormatException();
        }
        return phoneNumberString;
    }
    */
    try {
        return new PhoneNumber(phoneNumberString);
    } catch (InvalidPhoneNumberFormatException e){
        System.out.println("Invalid phone number passed:" + phoneNumberString);
        throw e;
    }
}
}
