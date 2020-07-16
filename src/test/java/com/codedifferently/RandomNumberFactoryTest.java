package com.codedifferently;

import org.junit.Assert;
import org.junit.Test;

import static com.codedifferently.tools.RandomNumberFactory.createFloat;
import static com.codedifferently.tools.RandomNumberFactory.createInteger;

public class RandomNumberFactoryTest {
    @Test
    public void createFloatTest(){
        boolean expected = true;
        boolean actual = false;
        Float test = createFloat(2, 9);
        if(test > 2 && test < 9){
            actual = true;
        }
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void creatIntegerTest(){
        boolean expected = true;
        boolean actual = false;
        Integer test = createInteger(20, 40);
        if(test > 20 && test < 40){
            actual = true;
        }
        Assert.assertEquals(expected, actual);
    }
}
