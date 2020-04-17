package parentPage;

import libs.ActionsWithWebElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {

    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionsWithWebElements actionsWithWebElements;

    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    String baseURL;
    String expectedURL;

    public ParentPage(WebDriver webDriver, String particialURL) {
        this.webDriver = webDriver;
        baseURL = configProperties.base_url();
        PageFactory.initElements(webDriver,this);
        actionsWithWebElements = new ActionsWithWebElements(webDriver);
        expectedURL = baseURL + particialURL;
    }

    public void checkCurrentURL(){
        try{
            Assert.assertEquals("Expected URL doesn't match actual one",expectedURL, webDriver.getCurrentUrl());
            logger.info("URL " + webDriver.getCurrentUrl() + " is correct");
        }catch(Exception e){
            e.printStackTrace();
            logger.error("URL " + webDriver.getCurrentUrl() + " is incorrect" + e);
            Assert.fail("URL " + webDriver.getCurrentUrl() + " is incorrect" + e);
        }
    }
}
