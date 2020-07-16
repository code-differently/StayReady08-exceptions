package com.codedifferently.phone;

import com.codedifferently.exceptions.InvalidPhoneNumberFormatException;
import com.codedifferently.phone.PhoneNumber;
import org.junit.Assert;
import org.junit.Test;

public class PhoneNumberTest {
    @Test(expected = InvalidPhoneNumberFormatException .class)
    public void invalidTest() throws InvalidPhoneNumberFormatException{
        PhoneNumber phone=new PhoneNumber("1");
    }

    @Test
    public void validTest() throws InvalidPhoneNumberFormatException {
        // Given
        String expected="(222)-121-0493";

        // When
        PhoneNumber test=new PhoneNumber(expected);
        String actual=test.toString();

        //
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void getAreaCodeTest() throws InvalidPhoneNumberFormatException {
        // Given
        String expected="(222)-121-0493";
        String area="222";

        // When
        PhoneNumber test=new PhoneNumber(expected);
        String actual=test.getAreaCode();

        //
        Assert.assertEquals(area,actual);

    }

    @Test
    public void getCentralOfficeCodeTest() throws InvalidPhoneNumberFormatException {
        // Given
        String expected="(222)-121-0493";
        String central="121";

        // When
        PhoneNumber test=new PhoneNumber(expected);
        String actual=test.getCentralOfficeCode();

        //
        Assert.assertEquals(central,actual);

    }

    @Test
    public void getPhoneLineCodeTest() throws InvalidPhoneNumberFormatException {
        // Given
        String expected="(222)-121-0493";
        String phoneL="0493";

        // When
        PhoneNumber test=new PhoneNumber(expected);
        String actual=test.getPhoneLineCode();

        //
        Assert.assertEquals(phoneL,actual);

    }
}
