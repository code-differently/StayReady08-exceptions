package com.codedifferntly.phone;

import com.codedifferntly.exceptions.InvalidPhoneNumberFormatException;
import com.codedifferntly.tools.RandomNumberFactory;
import org.omg.CORBA.DynAnyPackage.Invalid;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.codedifferntly.tools.RandomNumberFactory.createInteger;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory
{
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount)
    {
        PhoneNumber[] phoneBook = new PhoneNumber[phoneNumberCount];
        for(int i = 0; i < phoneNumberCount; i++)
        {
            phoneBook[i] = createPhoneNumberSafely(createInteger(0, 9), createInteger(0, 9), createInteger(0, 9));
        }
        return phoneBook;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber()
    {
        int areaCode = createInteger(100,999);
        int centralOffice = createInteger(100,999);
        int phoneLine = createInteger(1000,9999);

        return createPhoneNumberSafely(areaCode, centralOffice, phoneLine);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode)
    {
        String stringNumber = "("+areaCode+")"+"-"+centralOfficeCode+"-"+phoneLineCode;

        try
        {
            return createPhoneNumber(stringNumber);

        } catch(InvalidPhoneNumberFormatException ex)
        {
            logger.log(Level.WARNING, stringNumber + " is not a valid numbah");

            ex.printStackTrace();
        }
        return null;
    }
    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException
    {
        PhoneNumber phone = new PhoneNumber(phoneNumberString);
        logger.log(Level.INFO,"Attempting to create tha phone number " + phoneNumberString);
        return phone;
    }
}
