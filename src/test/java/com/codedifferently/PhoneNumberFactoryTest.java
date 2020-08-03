package com.codedifferently;

import com.codedifferently.exceptions.InvalidPhoneNumberFormatException;
import com.codedifferently.phone.PhoneNumber;
import com.codedifferently.phone.PhoneNumberFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by leon on 5/9/17.
 */
public class PhoneNumberFactoryTest {

    @Test(expected = InvalidPhoneNumberFormatException.class)
    public void testInvalidPhoneNumberFormatException() throws InvalidPhoneNumberFormatException {
        PhoneNumberFactory.createPhoneNumber("-1");
    }

    @Test
    public void testCreatePhoneNumberSafely() {
       
        int areaCode = 0;
        int centralOfficeCode = 0;
        int phoneLineCode = 0;

        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);
        
        Assert.assertEquals(null, phoneNumber);
    }

    @Test
    public void testGetAreaCode() {
        
        Integer areaCode = 302;
        int centralOfficeCode = 312;
        int phoneLineCode = 5555;
        
        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

        Assert.assertEquals(phoneNumber.getAreaCode(), areaCode.toString());
    }

    @Test
    public void testGetCentralOfficeCode() {

        int areaCode = 302;
        Integer centralOfficeCode = 312;
        int phoneLineCode = 5555;

        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);
        
        Assert.assertEquals(phoneNumber.getCentralOfficeCode(), centralOfficeCode.toString());
    }


    @Test
    public void testPhoneLineCode() {
  
        int areaCode = 302;
        int centralOfficeCode = 312;
        Integer phoneLineCode = 5555;

        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

        Assert.assertEquals(phoneNumber.getPhoneLineCode(), phoneLineCode.toString());
    }

    @Test
    public void testCreateRandomPhoneNumber() {
        for (int i = 0; i < 999; i++) {

            PhoneNumber phoneNumber = PhoneNumberFactory.createRandomPhoneNumber();

            Assert.assertTrue(phoneNumber != null);
        }
    }
}
