package com.codedifferently;

import com.codedifferently.exceptions.InvalidPhoneNumberFormatException;
import com.codedifferently.phone.PhoneNumber;
import com.codedifferently.phone.PhoneNumberFactory;
import org.junit.Assert;
import org.junit.Test;

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
        // : Given
        int areaCode = 0;
        int centralOfficeCode = 0;
        int phoneLineCode = 0;

        // : When
        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

        // : Then
        Assert.assertNull(phoneNumber);
    }

    @Test
    public void testCreatePhoneNumberSafely2() {
        // : Given
        int areaCode = 202;
        int centralOfficeCode = 891;
        int phoneLineCode = 3825;

        // : When
        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

        // : Then
        Assert.assertEquals("(202)-891-3825", phoneNumber.toString());
    }

    @Test
    public void testGetAreaCode() {
        // : Given
        Integer areaCode = 302;
        int centralOfficeCode = 312;
        int phoneLineCode = 5555;

        // : When
        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

        // : Then
        Assert.assertEquals(phoneNumber.getAreaCode(), areaCode.toString());
    }

    @Test
    public void testGetCentralOfficeCode() {
        // : Given
        int areaCode = 302;
        Integer centralOfficeCode = 312;
        int phoneLineCode = 5555;

        // : When
        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

        // : Then
        Assert.assertEquals(phoneNumber.getCentralOfficeCode(), centralOfficeCode.toString());
    }


    @Test
    public void testPhoneLineCode() {
        // : Given
        int areaCode = 302;
        int centralOfficeCode = 312;
        Integer phoneLineCode = 5555;

        // : When
        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

        // : Then
        Assert.assertEquals(phoneNumber.getPhoneLineCode(), phoneLineCode.toString());
    }

    @Test
    public void testCreateRandomPhoneNumber() {
        for (int i = 0; i < 999; i++) {
            // : Given
            // : When
            PhoneNumber phoneNumber = PhoneNumberFactory.createRandomPhoneNumber();

            // : Then
            Assert.assertNotNull(phoneNumber);
        }
    }

    @Test
    public void testCreateRandomPhoneNumberArray() {
            // : Given
            int expected = 5;

            // : When
            PhoneNumber[] phoneNumbers = PhoneNumberFactory.createRandomPhoneNumberArray(expected);
            int actual = phoneNumbers.length;

            // : Then
            Assert.assertEquals(expected, actual);
    }
}