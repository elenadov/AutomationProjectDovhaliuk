package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Link;

public class ProvidersEditPage extends ParentPage {

    @FindBy(id = "prov_cus_proCustName")
    private Link providerCustomerNameInput;

    @FindBy(id = "prov_cus_proCustAddress")
    private Link providerCustomerAddressInput;

    @FindBy(id = "prov_cus_proCustPhone")
    private Link providerCustomerPhoneInput;

    @FindBy(id = "prov_cus_proCustIsFl")
    private Link privatePersonCheckBox;

    @FindBy(id = "prov_cus_isOurFirm")
    private Link isOurFirmCheckBox;

    @FindBy(name = "add")
    private Link buttonSubmit;

    @FindBy(name = "delete")
    private Link buttonDelete;

    public ProvidersEditPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers/edit");
    }

    public void enterProviderCustomerNameIntoInput(String text){
        actionsWithWebElements.enterTextIntoTextField(providerCustomerNameInput, text);
    }

    public void enterProviderCustomerAddressIntoInput(String text){
        actionsWithWebElements.enterTextIntoTextField(providerCustomerAddressInput, text);
    }

    public void enterProviderCustomerPhoneInput(String text){
        actionsWithWebElements.enterTextIntoTextField(providerCustomerPhoneInput, text);
    }

    public void checkPrivatePersonCheckBox(String state){
        actionsWithWebElements.SetStateToCheckbox(privatePersonCheckBox,state);
    }

    public void checkIsOurFirmCheckBox(String state){
        actionsWithWebElements.SetStateToCheckbox(isOurFirmCheckBox, state);
    }

    public void clickSubmitButton(){
        actionsWithWebElements.clickOnElement(buttonSubmit);
    }

    public void clickOnDeleteButton(){
        actionsWithWebElements.clickOnElement(buttonDelete);
    }
}
