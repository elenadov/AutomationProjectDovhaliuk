package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Link;

public class DealsEditPage extends ParentPage {

    @FindBy(id = "deal_dealDate_date_day")
    private Link dateDD;

    @FindBy(id = "deal_dealDate_date_month")
    private Link monthDD;

    @FindBy(id = "deal_dealDate_date_year")
    private Link yearDD;

    @FindBy(id = "deal_dealDate_time_hour")
    private Link hoursDD;

    @FindBy(id = "deal_dealDate_time_minute")
    private Link minutesDD;

    @FindBy(xpath = "//select[@id='deal_dealDate_date_month']//option[")
    private Link valueOfMonthDD;

    @FindBy(id = "deal_dealType")
    private Link dealTypeDD;

    @FindBy(xpath = ".//*[@id='deal_dealType']//option[contains(text(),'BIG SALE')]")
    private Link valueOfDealTypeDD;

    @FindBy(id = "deal_customer")
    private Link customerDD;

    @FindBy(xpath = ".//select[@id='deal_customer']//option[4]")
    private Link valueOfCustomerDD;

    @FindBy(id = "deal_provider")
    private Link proviserDD;

    @FindBy(name = "add")
    private Link submitButton;

    @FindBy(xpath = ".//*[@class='btn btn-danger pull-right']")
    private Link buttonDelete;


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
