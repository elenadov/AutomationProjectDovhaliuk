package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class ActionsWithWebElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    public WebDriverWait webDriverWait_10;

    public ActionsWithWebElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait_10 = new WebDriverWait(webDriver, 10);
    }

    public void enterTextIntoTextField(WebElement webElement, String text) {
        try{
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was entered into text field successfully");
        }catch(Exception e){
            stopTestAndPrintMessage();
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Can't work with element");
        Assert.fail("Can't work with element");
    }

    public void clickOnElement(WebElement webElement) {
        try{
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked successfully" + getElementName(webElement));
        }catch(Exception e){
            stopTestAndPrintMessage();
        }
    }

    private String getElementName(WebElement webElement) {
        String elementName = "";
        if(webElement instanceof TypifiedElement){
            elementName = " '" + ((TypifiedElement)webElement).getName() + "' ";
        }
        return elementName;
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try{
            webDriverWait_10.until(ExpectedConditions.visibilityOf(webElement));
            boolean state = webElement.isDisplayed();
            logger.info("IsElementDisplay -> " + state);
            return state;
        }catch(Exception e){
            logger.info("IsElementDisplay -> false");
            return false;
        }
    }

    public void selectVisibleTextFromDDByJava(WebElement dropdown, String text) {
        try{
            webDriverWait_10.until(ExpectedConditions.textToBePresentInElement(dropdown, text));
            Select select = new Select(dropdown);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in dropdown");

        }catch(Exception e){
            stopTestAndPrintMessage();
        }
    }

    public boolean isElementDisplayed(String locator) {
        try{
            webDriverWait_10.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            return isElementDisplayed(webDriver.findElement(By.xpath(locator)));
        }catch(Exception e){
            return false;
        }
    }

    public void clickOnElement(String xpath) {
        try{
            clickOnElement(webDriver.findElement(By.xpath(xpath)));
        }catch(Exception e){
            stopTestAndPrintMessage();
        }

    }

    public void SetStateToCheckbox(WebElement checkbox, String state){
        boolean isStateCheck = state.toLowerCase().equals("check");
        boolean isStateUnCheck = state.toLowerCase().equals("uncheck");
        boolean isCheckBoxSelected = checkbox.isSelected();

        if(isStateCheck || isStateUnCheck){
            if((isStateCheck && isCheckBoxSelected)||(isStateUnCheck && !isCheckBoxSelected)){
                logger.info("Checkbox is already in needed state");
            }else if((isStateCheck && !isCheckBoxSelected)||(isStateUnCheck && isCheckBoxSelected)){
                clickOnElement(checkbox);
            }
        }else{
            logger.error("State should be only 'check' or 'uncheck'");
            stopTestAndPrintMessage();
        }
    }

    public void selectionInDropDownByClicks(WebElement closedDropDown, String dropDownValue){
        clickOnElement(closedDropDown);
        clickOnElement(dropDownValue);
    }
}
