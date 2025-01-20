package org.example.automation_testdemo.tests.flightreservation;

import org.example.automation_testdemo.flightbooking.*;
import org.example.automation_testdemo.tests.AbstractTest;
import org.example.automation_testdemo.tests.flightreservation.model.FlightReservationTestData;
import org.example.automation_testdemo.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightReservationTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(FlightReservationTest.class);

    private FlightReservationTestData testData;


    @BeforeTest
    @Parameters("testDataPath")
    public void setPageEnvironment(String testDataPath){
        this.testData = JsonUtil.getTestdata(testDataPath, FlightReservationTestData.class);
        log.info("Test data set successfully");

    }

    @Test
    public void userRegistrationTest(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goToUrl("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/reservation-app/index.html");
        Assert.assertTrue(registrationPage.isAt());

        registrationPage.enterUserDetails(testData.getFirstName(), testData.getLastName());
        registrationPage.enterUserCredentials(testData.getEmail(), testData.getPassword());
        registrationPage.enterAddress(testData.getStreet(), testData.getCity(), testData.getZip());
        registrationPage.register();
        log.info("User registered successfully");
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
        search.selectPassengers(testData.getPassengerCount());
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
        Assert.assertEquals(confirmation.getTicketPrice(),testData.getExpectedPrice());
    }

}
