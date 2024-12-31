package org.example.automation_testdemo.flightbooking;

import org.example.automation_testdemo.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FlightSelection extends AbstractPage {


    @Override
    public boolean isAt() {
        this.webDriverWait.until(ExpectedConditions.visibilityOf(confirmFlight));
        return this.confirmFlight.isDisplayed();
    }

    public FlightSelection(WebDriver driver){
        super(driver);
    }

    @FindBy(name="departure-flight")
    private List<WebElement> departureFlight;

    @FindBy(name="arrival-flight")
    private List<WebElement> arrivalFlight;

    @FindBy(id="confirm-flights")
    private WebElement confirmFlight;

    public void selectDepartureFlight(){
        int random = ThreadLocalRandom.current().nextInt(0, departureFlight.size());
        this.departureFlight.get(random).click();
        this.arrivalFlight.get(random).click();
    }

    public void flightConfirm(){
        this.confirmFlight.click();
    }

}
