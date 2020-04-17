package loginTest;

import abstractParentTest.AbstractParentTest;
import libs.ConfigClass;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(Parameterized.class)

public class ValidLoginTest extends AbstractParentTest {

    private String login, pass;

    public ValidLoginTest (String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        InputStream spreadsheet
                = new FileInputStream(ConfigClass.getCfgValue("DATA_FILE_PATH")
                +"testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }

    @Test
    public void positiveCaseValidLogin() {

        loginPage.openPage();
        loginPage.enterLoginIntoInputFieldLogin(login);
        loginPage.enterPasswordIntoInputFieldPassword(pass);
        loginPage.clickButtonVhod();

        homePage.checkCurrentURL();

        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }
}
