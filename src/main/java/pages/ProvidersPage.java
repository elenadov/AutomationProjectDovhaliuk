package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Link;

public class ProvidersPage extends ParentPage {

    @FindBy(xpath = ".//*[@class='box-tools']")
    private Link buttonAdd;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
    }

    public void clickOnAddButton(){
        actionsWithWebElements.clickOnElement(buttonAdd);
    }

    private boolean isProviderInList(String providerName){
        return actionsWithWebElements.isElementDisplayed(".//*[text()='" + providerName + "']");
    }

    public boolean isProviderPrivatePerson(String providerName) {
        if (isProviderInList(providerName) == true) {
            return actionsWithWebElements.isElementDisplayed(".//*[contains(text(), '" + providerName + "')]//..//td[4][span='1']");
        }
        return false;
    }

    public boolean isProviderOfOurFirm(String providerName) {
        if (isProviderInList(providerName) == true) {
            return actionsWithWebElements.isElementDisplayed(".//*[contains(text(), '" + providerName + "')]//..//td[4][span='']");
        }
        return false;
    }

    public void deleteProviderTillNotPresent(String providerName){
        int counter = 0;
        ProvidersEditPage providersEditPage = new ProvidersEditPage(webDriver);
        while(isProviderInList(providerName)){
            clickOnProvider(providerName);
            providersEditPage.clickOnDeleteButton();
            logger.info((counter + 1) + " provider was deleted");
            if(counter > 100){
                Assert.fail("There are more than 100 providers.");
            }
        }
    }

    public void clickOnProvider(String providerName){
        actionsWithWebElements.clickOnElement(".//*[text()='" + providerName + "']");
    }
}
