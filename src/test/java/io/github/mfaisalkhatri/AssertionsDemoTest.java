package io.github.mfaisalkhatri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertionsDemoTest {


    @Test
    public void testStringAssertions() {
        String expectedString = "lambdatest";

        Assertions.assertEquals(expectedString, "LambdaTest");
    }

    @Test
    public void testBooleanAssertion() {

        boolean isValid = false;
        //Assertions.assertTrue(isValid);
        Assertions.assertFalse(isValid);
    }

}
