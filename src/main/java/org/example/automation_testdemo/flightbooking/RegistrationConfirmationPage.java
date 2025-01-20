package org.example.automation_testdemo.flightbooking;

import org.example.automation_testdemo.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationConfirmationPage extends AbstractPage {

    @FindBy(id = "go-to-flights-search")
    private WebElement flightSearch;

    @FindBy(css = "#registration-confirmation-section p b")
    private WebElement firstnamevalue;
    public RegistrationConfirmationPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt(){
        this.webDriverWait.until(ExpectedConditions.visibilityOf(this.flightSearch));
        return this.flightSearch.isDisplayed();
    }

    public String getFirstName(){
        return this.firstnamevalue.getText();
    }

    public void registerConfirm(){
        this.flightSearch.click();
    }

}
