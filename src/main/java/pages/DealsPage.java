package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class DealsPage extends ParentPage {

    @FindBy(xpath = ".//*[@class='btn btn-info btn-sm']")
    private WebElement buttonAdd;

    public DealsPage(WebDriver webDriver) {
        super(webDriver, "/deal");
    }

    public void clickOnAddButton() {
        actionsWithWebElements.clickOnElement(buttonAdd);
    }

    public boolean isDealInList(String date, String month, String year, String hours, String minutes){
        return actionsWithWebElements.isElementDisplayed(".//*[text()='" + date + "." + month + "."
                + year + " " + hours + ":" + minutes + "']");
    }

    public void deleteDealTillNotPresent(String date, String month, String year, String hours, String minutes){
        int counter = 0;
        DealsEditPage dealsEditPage = new DealsEditPage(webDriver);
        while(isDealInList(date, month, year, hours, minutes)){
            clickOnSpare(date, month, year, hours, minutes);
            dealsEditPage.clickOnDeleteButton();
            logger.info((counter + 1) + " deal was deleted");
            if(counter > 100){
                Assert.fail("There are more than 100 deals.");
            }
        }
    }

    public void clickOnSpare(String date, String month, String year, String hours, String minutes){
        actionsWithWebElements.clickOnElement(".//*[text()='" + date + "." + month + "."
                + year + " " + hours + ":" + minutes + "']");
    }
}
