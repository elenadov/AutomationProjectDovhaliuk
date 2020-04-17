package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//*[@class='pull-left image']")
    private WebElement avatar;

    @FindBy(id = "dictionary")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement submenuSpares;

    @FindBy(xpath = ".//*[@href='/deal']")
    private WebElement submenuDeal;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public boolean isAvatarDisplayed() {
        return actionsWithWebElements.isElementDisplayed(avatar);
    }

    public void checkIsAvatarPresent() {
        Assert.assertTrue("Avatar is not displayed", isAvatarDisplayed());
    }

    public void clickOnDictionaryMenu(){
        actionsWithWebElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubmenuSpares(){
        actionsWithWebElements.clickOnElement(submenuSpares);
    }

    public void clickOnDealMenu(){
        actionsWithWebElements.clickOnElement(submenuDeal);
    }
}
