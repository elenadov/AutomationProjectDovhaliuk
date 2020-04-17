package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SparePage extends ParentPage {

    @FindBy(xpath = ".//*[@class='fa fa-plus']") //here we have 2 classes, so we can't use className instead of xpath
    private WebElement buttonAdd;

    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickAddButton(){
        actionsWithWebElements.clickOnElement(buttonAdd);
    }

    public boolean isSpareInList(String spareName){
        return actionsWithWebElements.isElementDisplayed(".//*[text()='" + spareName + "']");
    }

    public void deleteSpareTillNotPresent(String spareName){
        int counter = 0;
        SpareEditPage spareEditPage = new SpareEditPage(webDriver);
        while(isSpareInList(spareName)){
            clickOnSpare(spareName);
            spareEditPage.clickOnDeleteButton();
            logger.info((counter + 1) + " spare was deleted");
            if(counter > 100){
                Assert.fail("There are more than 100 spares.");
            }
        }
    }

    public void clickOnSpare(String spareName){
        actionsWithWebElements.clickOnElement(".//*[text()='" + spareName + "']");
    }
}
