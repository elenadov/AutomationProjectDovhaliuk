package providersTest;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Test;

public class OurFirmProviderCreationTest extends AbstractParentTest {

    private final String providerCustomerName = "Silvia De Fald"+ Utils.getDateAndTimeFormated();
    private final String providerCustomerAddress = "Rockfeller Street, "+ Utils.getDateAndTimeFormated();
    private final String providerCustomerPhone = "+3807832240032342355";

    @Test
    public void providerCreation(){
        loginPage.fillingLoginFormWithSubmit("Student", "909090");

        homePage.checkCurrentURL();
        homePage.leftMenu.clickOnMenuDictionary();
        homePage.leftMenu.clickOnSubmenuProviders();

        providersPage.checkCurrentURL();
        providersPage.clickOnAddButton();

        providersEditPage.checkCurrentURL();
        providersEditPage.enterProviderCustomerNameIntoInput(providerCustomerName);
        providersEditPage.enterProviderCustomerAddressIntoInput(providerCustomerAddress);
        providersEditPage.enterProviderCustomerPhoneInput(providerCustomerPhone);
        providersEditPage.checkPrivatePersonCheckBox("uncheck");
        providersEditPage.checkIsOurFirmCheckBox("check");
        providersEditPage.clickSubmitButton();

        providersPage.checkCurrentURL();

        checkExpectedResult("Cannot find provider/ customer in list",
                providersPage.isProviderOfOurFirm(providerCustomerName));
    }

    @After
    public void deleteProvider(){
        providersPage.deleteProviderTillNotPresent(providerCustomerName);
    }
}
