package io.github.mfaisalkhatri;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName ("Demo Test class")
public class BasicTest {

    @AfterAll
    public static void afterAllMethod () {
        System.out.println ("After All method called!!");
    }

    @BeforeAll
    public static void beforeAllTest () {

        System.out.println ("Before All method called!!");
    }

    @AfterEach
    public void afterEachMethod () {
        System.out.println ("After Each method called!!");
    }

    @BeforeEach
    public void beforeEachTest () {
        System.out.println ("Before Each method called!!");
    }

    @Test
    @Disabled ("This test is disabled to demo disable annotation")
    public void disabledTest () {
        System.out.println ("This is a disabled test!!");
    }

    @DisplayName ("This is a demo test")
    @Test
    public void testMethodOne () {
        System.out.println ("Test Method One Called!!");
    }

    @Test
    public void testMethodTwo () {
        System.out.println ("Test Method Two Called!!");

    }
}