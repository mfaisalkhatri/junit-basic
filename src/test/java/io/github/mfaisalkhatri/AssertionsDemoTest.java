package io.github.mfaisalkhatri;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertionsDemoTest {

    @Test
    public void testBooleanAssertion () {

        final boolean isValid = false;
        //Assertions.assertTrue(isValid);
        Assertions.assertFalse (isValid);
    }

    @Test
    public void testStringAssertions () {
        final String expectedString = "lambdatest";

        Assertions.assertEquals (expectedString, "LambdaTest");
    }
}