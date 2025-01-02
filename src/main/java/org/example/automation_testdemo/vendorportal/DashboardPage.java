package org.example.automation_testdemo.vendorportal;

import org.example.automation_testdemo.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPage extends AbstractPage {


    public static Logger LOG = LoggerFactory.getLogger(DashboardPage.class);
    @FindBy(id="monthly-earning")
    private WebElement monthlyEarning;

    @FindBy(id="annual-earning")
    private WebElement annualEarning;

    @FindBy(id="profit-margin")
    private WebElement profitMargin;

    @FindBy(id="available-inventory")
    private WebElement availableInventory;

    @FindBy(css= "#dataTable_filter input")
    private WebElement searchBox;

    @FindBy(css="#dataTable_info")
    private WebElement searchResultsInfo;

    @FindBy(css= "img.img-profile")
    private WebElement profileImage;

    @FindBy(css= ".dropdown-menu .dropdown-item .fa-sign-out-alt")
    private WebElement logoutPage;

    @FindBy(css= "#logoutModal a")
    private WebElement logoutBtn;

    @Override
    public boolean isAt() {
        this.webDriverWait.until(ExpectedConditions.visibilityOf(this.monthlyEarning));
        return this.monthlyEarning.isDisplayed();
    }

    public DashboardPage(WebDriver driver){
        super(driver);
    }

    public String getMonthlyEarning(){
        return this.monthlyEarning.getText();
    }

    public String getAnnualEarning(){
        return this.annualEarning.getText();
    }

    public String getProfitMargin(){
        return this.profitMargin.getText();
    }

    public String getAvailableInventory(){
        return this.availableInventory.getText();
    }

    public void searchOrderHistory(String searchKey){
        this.searchBox.sendKeys(searchKey);
    }

    public int getSearchResultsCount(){
        String searchResults = this.searchResultsInfo.getText();
        String[] searchResultsArray = searchResults.split(" ");
        int count = Integer.parseInt(searchResultsArray[5]);
        LOG.info("Search results count: {}", count);
        return Integer.parseInt(searchResultsArray[5]);
    }

    public void logout(){
        this.profileImage.click();
        this.logoutPage.click();
        this.logoutBtn.click();}
}
