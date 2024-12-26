package org.example.automation_testdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {

    protected final WebDriver driver;
    protected final WebDriverWait webDriverWait;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isAt();
}
