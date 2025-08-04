package io.github.mfaisalkhatri;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginTest {

    private static RemoteWebDriver driver;

    public static ChromeOptions getChromeOptions () {
        final ChromeOptions browserOptions = new ChromeOptions ();
        browserOptions.setPlatformName ("Windows 10");
        browserOptions.setBrowserVersion ("130.0");
        final HashMap<String, Object> ltOptions = new HashMap<String, Object> ();
        ltOptions.put ("project", "LambdaTest E-Commerce Playground");
        ltOptions.put ("build", "LambdaTest E-Commerce Login page");
        ltOptions.put ("name", "Unit Test for Login Page");
        ltOptions.put ("selenium_version", "4.0.0");
        ltOptions.put ("w3c", true);
        ltOptions.put ("plugin", "java-junit");

        browserOptions.setCapability ("LT:Options", ltOptions);

        return browserOptions;
    }

    @BeforeAll
    public static void setup () {
        final String userName = System.getenv ("LT_USERNAME") == null ? "LT_USERNAME" : System.getenv ("LT_USERNAME");
        final String accessKey = System.getenv ("LT_ACCESS_KEY") == null
                                 ? "LT_ACCESS_KEY"
                                 : System.getenv ("LT_ACCESS_KEY");
        final String gridUrl = "@hub.lambdatest.com/wd/hub";
        try {
            driver = new RemoteWebDriver (new URL ("http://" + userName + ":" + accessKey + gridUrl),
                getChromeOptions ());
        } catch (final MalformedURLException e) {
            System.out.println ("Could not start the remote session on LambdaTest cloud grid");
        }
        driver.manage ()
            .timeouts ()
            .pageLoadTimeout (Duration.ofSeconds (10));
    }

    @AfterAll
    public static void tearDown () {
        driver.quit ();
    }

    @Test
    public void testLoginFunction () {
        driver.get ("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

        final WebElement emailAddressField = driver.findElement (By.id ("input-email"));
        emailAddressField.sendKeys ("davidjacob@demo.com");

        final WebElement passwordField = driver.findElement (By.id ("input-password"));
        passwordField.sendKeys ("Password123");

        final WebElement loginBtn = driver.findElement (By.cssSelector ("input.btn"));
        loginBtn.click ();

        final String myAccountHeader = driver.findElement (By.cssSelector ("#content h2"))
            .getText ();
        assertEquals (myAccountHeader, "My Account");

    }
}