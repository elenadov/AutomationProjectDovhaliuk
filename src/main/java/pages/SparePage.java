package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Link;

public class SparePage extends ParentPage {

    @FindBy(xpath = ".//*[@class='fa fa-plus']")
    private Link buttonAdd;

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
