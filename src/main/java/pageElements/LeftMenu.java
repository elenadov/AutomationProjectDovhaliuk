package pageElements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Link;

@FindBy(xpath = ".//*[@class='sidebar-menu']") //locator of the hole side bar
public class LeftMenu extends CommonActionWithElements {

    @FindBy(id = "dictionary")
    private Link menuDictionary;

    @FindBy(id = "spares")
    private Link submenuSpare;

    @FindBy(id = "deal")
    private Link submenuDeal;

    @FindBy(id = "prov_cus")
    private Link submenuProviders;

    public void clickOnMenuDictionary(){
        actionsWithWebElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubmenuSpare() {
        actionsWithWebElements.clickOnElement(submenuSpare);
    }

    public void clickOnSubmenuDeal(){
        actionsWithWebElements.clickOnElement(submenuDeal);
    }

    public void clickOnSubmenuProviders(){
        actionsWithWebElements.clickOnElement(submenuProviders);
    }
}
