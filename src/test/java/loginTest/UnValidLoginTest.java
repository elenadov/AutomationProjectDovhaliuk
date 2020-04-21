package loginTest;

import abstractParentTest.AbstractParentTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class UnValidLoginTest extends AbstractParentTest {

    String login, password;

    public UnValidLoginTest(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][] {
                    {"S", "906090"},
                    {"122334", "909090"},
                    {"student123", "909090"},
                    {"login", "909090"}
                }
        );
    }

    @Test
    public void negativeCaseUnValidLogin(){
        loginPage.openPage();
        loginPage.enterLoginIntoInputFieldLogin(login);
        loginPage.enterPasswordIntoInputFieldPassword(password);
        loginPage.clickButtonVhod();

        checkExpectedResult("Avatar is not present", !homePage.isAvatarDisplayed());
        checkExpectedResult("Input login is not present", loginPage.isInputLoginPresent());
        checkExpectedResult("Input password is not present", loginPage.isInputPasswordPresent());
    }
}