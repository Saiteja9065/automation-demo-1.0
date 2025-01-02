package org.example.automation_testdemo.flightbooking;

import org.example.automation_testdemo.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class FlightConfirmation extends AbstractPage {

    public static Logger LOG = LoggerFactory.getLogger(FlightConfirmation.class);
    public FlightConfirmation(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "#flights-confirmation-section .card-body .row:nth-child(1) .col:nth-child(2)")
    private WebElement flightConfirmationId;

    @FindBy(css = "#flights-confirmation-section .card-body .row:nth-child(3) .col:nth-child(2)")
    private WebElement price;

    @Override
    public boolean isAt() {
        this.webDriverWait.until(ExpectedConditions.visibilityOf(this.flightConfirmationId));
        return this.flightConfirmationId.isDisplayed();
    }

    public String getTicketPrice(){
        String confirmation = this.flightConfirmationId.getText();
        String price = this.price.getText();
        LOG.info("Flight confirmation: {}",confirmation);
        LOG.info("Total price : {}", price);
        return this.price.getText();
    }



}
