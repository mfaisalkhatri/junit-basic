package io.github.mfaisalkhatri;

import org.junit.jupiter.api.*;

@DisplayName("Demo Test class")
public class BasicTest {

    @BeforeAll
    public static void beforeAllTest() {

        System.out.println("Before All method called!!");
    }

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("Before Each method called!!");
    }

    @DisplayName("This is a demo test")
    @Test
    public void testMethodOne() {
        System.out.println("Test Method One Called!!");
    }

    @Test
    @Disabled("This test is disabled to demo disable annotation")
    public void disabledTest() {
        System.out.println("This is a disabled test!!");
    }

    @Test
    public void testMethodTwo() {
        System.out.println("Test Method Two Called!!");

    }

    @AfterEach
    public void afterEachMethod() {
        System.out.println("After Each method called!!");
    }

    @AfterAll
    public static void afterAllMethod() {
        System.out.println("After All method called!!");
    }

}
