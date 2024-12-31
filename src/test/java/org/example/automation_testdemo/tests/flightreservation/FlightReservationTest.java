package org.example.automation_testdemo.tests.flightreservation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.automation_testdemo.flightbooking.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlightReservationTest {

    private WebDriver driver;

    @BeforeTest
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @Test
    public void userRegistrationTest(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goToUrl("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        Assert.assertTrue(registrationPage.isAt());

        registrationPage.enterUserDetails("selenium","docker-mama");
        registrationPage.enterUserCredentials("selenium.docker@gmail.com","sdocker@123");
        registrationPage.enterAddress("timesNewStreet","New York city","500032");
        registrationPage.register();
    }

    @Test(dependsOnMethods = "userRegistrationTest")
    public void registrationConfirmationTest(){
        RegistrationConfirmationPage confirmationPage = new RegistrationConfirmationPage(driver);
        Assert.assertTrue(confirmationPage.isAt());
        confirmationPage.registerConfirm();
    }

    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightSearchTest(){
        FlightSearch search = new FlightSearch(driver);
        Assert.assertTrue(search.isAt());
        search.selectPassengers("2");
        search.searchFlight();
    }

    @Test(dependsOnMethods = "flightSearchTest")
    public void flightSelectionTest(){
        FlightSelection selection = new FlightSelection(driver);
        Assert.assertTrue(selection.isAt());
        selection.selectDepartureFlight();
        selection.flightConfirm();
    }

    @Test(dependsOnMethods = "flightSelectionTest")
    public void flightConfirmationTest(){
        FlightConfirmation confirmation = new FlightConfirmation(driver);
        Assert.assertTrue(confirmation.isAt());
        Assert.assertEquals(confirmation.getTicketPrice(),"$1169 USD");
    }

    @AfterTest
    public void quitTest(){
        this.driver.quit();
    }
}
