package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class SpareEditPage extends ParentPage {

    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;

    @FindBy(id = "spares_spareType")
    private WebElement spareTypeDD;

    @FindBy(xpath = ".//option[4]")
    private WebElement valueOfDropdown;

    @FindBy(name = "add")
    private WebElement buttonCreate;

    @FindBy(name = "add")
    private WebElement submitButton;

    @FindBy(name = "delete")
    private WebElement buttonDelete;

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
