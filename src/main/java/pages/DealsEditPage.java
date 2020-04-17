package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

import java.util.ArrayList;

public class DealsEditPage extends ParentPage {

    @FindBy(id = "deal_dealDate_date_day")
    private WebElement dateDD;

    @FindBy(id = "deal_dealDate_date_month")
    private WebElement monthDD;

    @FindBy(id = "deal_dealDate_date_year")
    private WebElement yearDD;

    @FindBy(id = "deal_dealDate_time_hour")
    private WebElement hoursDD;

    @FindBy(id = "deal_dealDate_time_minute")
    private WebElement minutesDD;

    @FindBy(xpath = "//select[@id='deal_dealDate_date_month']//option[")
    private WebElement valueOfMonthDD;

    @FindBy(id = "deal_dealType")
    private WebElement dealTypeDD;

    @FindBy(xpath = ".//*[@id='deal_dealType']//option[contains(text(),'BIG SALE')]")
    private WebElement valueOfDealTypeDD;

    @FindBy(id = "deal_customer")
    private WebElement customerDD;

    @FindBy(xpath = ".//select[@id='deal_customer']//option[4]")
    private WebElement valueOfCustomerDD;

    @FindBy(id = "deal_provider")
    private WebElement proviserDD;

    @FindBy(name = "add")
    private WebElement submitButton;

    @FindBy(xpath = ".//*[@class='btn btn-danger pull-right']")
    private WebElement buttonDelete;


    public DealsEditPage(WebDriver webDriver) {
        super(webDriver, "/deal/edit");
    }

    public void selectDateFromDropDown(String date) {
        actionsWithWebElements.selectVisibleTextFromDDByJava(dateDD, date);
    }

    public void selectionOfMonthInDropDown(String month){
        String valueOfMonthDD = ".//*[@id='deal_dealDate_date_month']//option[" + month + "]";
        actionsWithWebElements.selectionInDropDownByClicks(monthDD, valueOfMonthDD);
    }

    public void selectYearFromDropDown(String year) {
        actionsWithWebElements.selectVisibleTextFromDDByJava(yearDD, year);
    }

    public void selectHoursFromDropDown(String hours) {
        actionsWithWebElements.selectVisibleTextFromDDByJava(hoursDD, hours);
    }

    public void selectMinutesFromDropDown(String minutes) {
        actionsWithWebElements.selectVisibleTextFromDDByJava(minutesDD, minutes);
    }

    public void selectDealTypeFromDropDown(String dealType) {
        actionsWithWebElements.selectVisibleTextFromDDByJava(dealTypeDD, dealType);
    }

    public void selectCustomerFromDropDown(String customerName) {
        actionsWithWebElements.selectVisibleTextFromDDByJava(customerDD, customerName);
    }

    public void selectProviderFromDropDown(String providerName) {
        actionsWithWebElements.selectVisibleTextFromDDByJava(proviserDD, providerName);
    }

    public void clickOnSubmitButton() {
        actionsWithWebElements.clickOnElement(submitButton);
    }

    public void clickOnDeleteButton() {
        actionsWithWebElements.clickOnElement(buttonDelete);
    }
}
