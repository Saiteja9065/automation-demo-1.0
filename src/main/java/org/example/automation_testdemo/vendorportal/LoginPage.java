package org.example.automation_testdemo.vendorportal;

import org.example.automation_testdemo.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {


    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement userpassword;

    @FindBy(id = "login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isAt() {
        this.webDriverWait.until(ExpectedConditions.visibilityOf(loginButton));
        return loginButton.isDisplayed();
    }

    public void goToUrl(String url){
        this.driver.get(url);
    }

    public void login(String username, String password){
        this.userName.sendKeys(username);
        this.userpassword.sendKeys(password);
        this.loginButton.click();
    }
}
