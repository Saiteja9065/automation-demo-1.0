package org.example.automation_testdemo.tests.flightreservation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.automation_testdemo.vendorportal.DashboardPage;
import org.example.automation_testdemo.vendorportal.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VendorPortalTest {

    private WebDriver driver;
    @BeforeTest
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }
    @Test
    public void loginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToUrl("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
        Assert.assertTrue(loginPage.isAt());
        loginPage.login("sam","sam");
    }

    @Test(dependsOnMethods={"loginTest"})
    public void dashboardTest() {
        DashboardPage dashboardPage = new DashboardPage(driver);
    	Assert.assertTrue(dashboardPage.isAt());
        Assert.assertEquals(dashboardPage.getMonthlyEarning(), "$40,000");
        dashboardPage.searchOrderHistory("adams");
        Assert.assertEquals(dashboardPage.getSearchResultsCount(), 8);
        dashboardPage.logout();
    }

    @AfterTest
    public void quitTest(){
        this.driver.quit();
    }

}
