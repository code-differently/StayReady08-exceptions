package com.codedifferently.phone;

import com.codedifferently.exceptions.InvalidPhoneNumberFormatException;
import com.codedifferently.phone.PhoneNumber;
import org.junit.Assert;
import org.junit.Test;

public class PhoneNumberTest {
    @Test
    public void phoneNumberConstructorTest(){
        boolean bool;
        try {
            PhoneNumber number = new PhoneNumber("(678)-345-7766");
            bool = true;
        }catch(InvalidPhoneNumberFormatException ex){
            bool = false;
        }
        Assert.assertEquals(true, bool);
    }
    @Test
    public void getAreaCodeTest(){
        String expected = "678";
        String actual = "";
        try {
            PhoneNumber number = new PhoneNumber("(678)-345-7766");
            actual = number.getAreaCode();
        }catch(InvalidPhoneNumberFormatException ex){
            expected = "0";
        }
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getCentralOfficeCodeTest(){
        String expected = "345";
        String actual = "";
        try {
            PhoneNumber number = new PhoneNumber("(678)-345-7766");
            actual = number.getCentralOfficeCode();
        }catch(InvalidPhoneNumberFormatException ex){
            expected = "0";
        }
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getPhoneLineCodeTest(){
        String expected = "7766";
        String actual = "";
        try {
            PhoneNumber number = new PhoneNumber("(678)-345-7766");
            actual = number.getPhoneLineCode();
        }catch(InvalidPhoneNumberFormatException ex){
            expected = "0";
        }
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getToStringTest(){
        String expected = "(678)-345-7766";
        String actual = "";
        try {
            PhoneNumber number = new PhoneNumber("(678)-345-7766");
            actual = number.toString();
        }catch(InvalidPhoneNumberFormatException ex){
            expected = "0";
        }
        Assert.assertEquals(expected, actual);
    }
}
