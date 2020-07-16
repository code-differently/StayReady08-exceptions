package com.codedifferently;

import org.junit.Test;

import static com.codedifferently.tools.RandomNumberFactory.*;

public class RandomNumberFactoryTest {
    @Test
    public void createIntegerTest(){
        // Given
        int max=100;
        int min=53;

        // When
        int rand=createInteger(min,max);

        // Then
        if(rand>=min && rand<=max)
            assert (true);
        else
            assert (false);

    }

    @Test
    public void createFloatTest(){
        // Given
        float max=32.13f;
        float min=22.32f;

        // When
        float rand=createFloat(min,max);

        // Then
        if(rand>=min && rand<=max)
            assert (true);
        else
            assert (false);
    }
}
