package org.example.automation_testdemo.flightbooking;

import org.example.automation_testdemo.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearch extends AbstractPage {

    public FlightSearch(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.webDriverWait.until(ExpectedConditions.visibilityOf(passengerCount));
        return this.passengerCount.isDisplayed();
    }

    @FindBy(id="passengers")
    private WebElement passengerCount;

    @FindBy(id="search-flights")
    private WebElement searchFlights;

    public void selectPassengers(String noOfPassengers){
        Select passengers = new Select(passengerCount);
        passengers.selectByValue(noOfPassengers);
    }

    public void searchFlight(){
        this.searchFlights.click();
    }
}
