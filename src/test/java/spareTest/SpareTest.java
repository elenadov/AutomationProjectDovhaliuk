package spareTest;

import abstractParentTest.AbstractParentTest;
import libs.Utils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpareTest extends AbstractParentTest {

    private final String spareName = "TestSpareName_"+ Utils.getDateAndTimeFormated();

    @Before
    public void deleteSpareFirstly(){
        sparePage.deleteSpareTillNotPresent(spareName);
    }

    @Test
    public void createNewSpare(){
        loginPage.fillingLoginFormWithSubmit("Student", "909090");

        homePage.checkCurrentURL();
        homePage.checkIsAvatarPresent();
        homePage.clickOnDictionaryMenu();
        homePage.clickOnSubmenuSpares();

        sparePage.checkCurrentURL();
        sparePage.clickAddButton();

        spareEditPage.checkCurrentURL();
        spareEditPage.enterSpareNameIntoTextField(spareName);
        spareEditPage.selectSpareTypeFromDropdown("Датчики");
        spareEditPage.clickOnSubmitButton();

        sparePage.checkCurrentURL();
        checkExpectedResult("Can not find spare in list", sparePage.isSpareInList(spareName));
    }

    @After
    public void deleteSpare(){
        sparePage.deleteSpareTillNotPresent(spareName);
    }
}

