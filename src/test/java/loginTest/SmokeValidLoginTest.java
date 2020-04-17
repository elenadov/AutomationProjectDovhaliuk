package loginTest;

import abstractParentTest.AbstractParentTest;
import libs.ConfigClass;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class SmokeValidLoginTest extends AbstractParentTest{

    @Test
    public void positiveCaseValidLogin() {

        loginPage.openPage();
        loginPage.enterLoginIntoInputFieldLogin("Student");
        loginPage.enterPasswordIntoInputFieldPassword("909090");
        loginPage.clickButtonVhod();

        homePage.checkCurrentURL();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }
}
