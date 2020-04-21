package pages;

import libs.ConfigClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import parentPage.ParentPage;
import ru.yandex.qatools.htmlelements.element.Link;

public class LoginPage extends ParentPage {

    @FindBy(name = "_username")
    private Link inputLogin;

    @FindBy(id = "password")
    private Link inputPassword;

    @FindBy(tagName = "button")
    private Link buttonVhod;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    public void openPage() {
        try{
            webDriver.get(ConfigClass.getCfgValue("base_url") + "/login");
            webDriverWait_10.until(ExpectedConditions.urlToBe(ConfigClass.getCfgValue("base_url") + "/login"));
        }catch(Exception e){
            e.printStackTrace();
            Assert.fail("Can't work with browser");
        }
    }

    public void enterLoginIntoInputFieldLogin(String login) {
        actionsWithWebElements.enterTextIntoTextField(inputLogin, login);
    }

    public void enterPasswordIntoInputFieldPassword(String password) {
        actionsWithWebElements.enterTextIntoTextField(inputPassword, password);
    }

    public void clickButtonVhod() {
        actionsWithWebElements.clickOnElement(buttonVhod);
    }

    public boolean isInputLoginPresent(){
        try{
            return actionsWithWebElements.isElementDisplayed(inputLogin);
        }catch(Exception e){
            return false;
        }
    }

    public boolean isInputPasswordPresent(){
        try{
            return actionsWithWebElements.isElementDisplayed(inputPassword);
        }catch(Exception e){
            return false;
        }
    }

    public void fillingLoginFormWithSubmit(String login, String password){
        openPage();
        enterLoginIntoInputFieldLogin(login);
        enterPasswordIntoInputFieldPassword(password);
        clickButtonVhod();
    }
}
