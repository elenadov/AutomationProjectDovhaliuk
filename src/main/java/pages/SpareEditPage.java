package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Link;

public class SpareEditPage extends ParentPage {

    @FindBy(id = "spares_spareName")
    private Link spareNameInput;

    @FindBy(id = "spares_spareType")
    private Link spareTypeDD;

    @FindBy(xpath = ".//option[4]")
    private Link valueOfDropdown;

    @FindBy(name = "add")
    private Link buttonCreate;

    @FindBy(name = "add")
    private Link submitButton;

    @FindBy(name = "delete")
    private Link buttonDelete;

    public SpareEditPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void enterSpareNameIntoTextField(String spareName){
        actionsWithWebElements.enterTextIntoTextField(spareNameInput, spareName);
    }

    public void selectSpareTypeFromDropdown(String spareType) {
        actionsWithWebElements.selectVisibleTextFromDDByJava(spareTypeDD, spareType);
    }

    public void clickOnSubmitButton(){
        actionsWithWebElements.clickOnElement(submitButton);
    }

    public void clickOnDeleteButton(){
        actionsWithWebElements.clickOnElement(buttonDelete);
    }
}
