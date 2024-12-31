package org.example.automation_testdemo.flightbooking;

import org.example.automation_testdemo.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends AbstractPage {


    @FindBy(id="firstName")
    private WebElement fName;

    @FindBy(id="lastName")
    private WebElement lName;

    @FindBy(id="email")
    private WebElement emailInput;

    @FindBy(id="password")
    private WebElement pwd;

    @FindBy(name="street")
    private WebElement streetName;

    @FindBy(name="city")
    private WebElement cityName;

    @FindBy(id="inputState")
    private WebElement choose;

    @FindBy(name="zip")
    private WebElement zipCode;

    @FindBy(id="register-btn")
    private WebElement registerBtn;

    //this method will be moved to abstract class, since it'll be common across all classes
    //        PageFactory.initElements(driver, this);
    //the above statement will create a proxy object for all the above values/elements, and at runtime it needs to
    //be able to interact, the elements are identified and initialized in this class.
    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.webDriverWait.until(ExpectedConditions.visibilityOf(fName));
        return this.fName.isDisplayed();
    }

    public void goToUrl(String url){
        this.driver.get(url);
    }

    public void enterUserDetails(String firstname, String lastname){
        this.fName.sendKeys(firstname);
        this.lName.sendKeys(lastname);
    }

    public void enterUserCredentials(String username, String password){
        this.emailInput.sendKeys(username);
        this.pwd.sendKeys(password);
    }

    public void enterAddress(String street, String city, String zip){
        this.streetName.sendKeys(street);
        this.cityName.sendKeys(city);
        this.zipCode.sendKeys(zip);
    }

    public void register(){
        this.registerBtn.click();
    }
}
