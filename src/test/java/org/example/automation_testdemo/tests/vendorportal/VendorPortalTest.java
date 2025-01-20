package org.example.automation_testdemo.tests.vendorportal;

import org.example.automation_testdemo.tests.AbstractTest;
import org.example.automation_testdemo.tests.vendorportal.model.VendorPortalTestData;
import org.example.automation_testdemo.util.JsonUtil;
import org.example.automation_testdemo.vendorportal.DashboardPage;
import org.example.automation_testdemo.vendorportal.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class VendorPortalTest extends AbstractTest {

    private static final Logger log = LoggerFactory.getLogger(VendorPortalTest.class);
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private VendorPortalTestData testData;
    @BeforeTest
    @Parameters("testDataPath")
    public void setPage(String testDataPath) {
        this.loginPage = new LoginPage(driver);
        this.dashboardPage = new DashboardPage(driver);
        this.testData = JsonUtil.getTestdata(testDataPath, VendorPortalTestData.class);
    }
    @Test
    public void loginTest(){
        log.info("Login test started");
        loginPage.goToUrl("https://d1uh9e7cu07ukd.cloudfront.net/selenium-docker/vendor-app/index.html");
        Assert.assertTrue(loginPage.isAt());
        loginPage.login(testData.getUsername(), testData.getPassword());
    }

    @Test(dependsOnMethods={"loginTest"})
    public void dashboardTest() {
    	Assert.assertTrue(dashboardPage.isAt());
        Assert.assertEquals(dashboardPage.getMonthlyEarning(), testData.getMonthlyEarning());
        Assert.assertEquals(dashboardPage.getAnnualEarning(), testData.getAnnualEarning());
        Assert.assertEquals(dashboardPage.getProfitMargin(), testData.getProfitMargin());
        Assert.assertEquals(dashboardPage.getAvailableInventory(), testData.getAvailableInventory());
        dashboardPage.searchOrderHistory(testData.getSearchKey());
        Assert.assertEquals(dashboardPage.getSearchResultsCount(), testData.getSearchResultsInfo());
    }

    @Test(dependsOnMethods={"dashboardTest"})
    public void logoutTest(){
        dashboardPage.logout();
        Assert.assertTrue(loginPage.isAt());
    }



}
