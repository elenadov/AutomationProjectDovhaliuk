package abstractParentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import libs.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparePage sparePage;
    protected SpareEditPage spareEditPage;
    protected DealsPage dealsPage;
    protected DealsEditPage dealsEditPage;
    private String pathToScreenShot;
    protected Utils utils;


    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp() throws Exception{

        pathToScreenShot = "..\\dovhaliuk\\target\\screenshot\\" + this.getClass().getPackage().getName() + "\\" + this.getClass().getSimpleName()
                + this.testName.getMethodName() + ".jpg";

        webDriver = driverInit();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparePage = new SparePage(webDriver);
        spareEditPage = new SpareEditPage(webDriver);
        dealsPage = new DealsPage(webDriver);
        dealsEditPage = new DealsEditPage(webDriver);
        utils = new Utils();

    }

    private WebDriver driverInit() throws Exception{
        String browser = System.getProperty("browser");
        if((browser == null) || ("chrome".equalsIgnoreCase(browser))){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if("firefox".equalsIgnoreCase(browser)){
            WebDriverManager.firefoxdriver();
            return new FirefoxDriver();
        } else if("ie".equalsIgnoreCase(browser)){
            WebDriverManager.iedriver().arch32().setup();
            return new InternetExplorerDriver();
        } else {
            throw new Exception("Check browser setup variants");
        }
    }

    @After
    public void closeWindow(){
        webDriver.quit();
    }

    protected void checkExpectedResult(String message, boolean actualResult){
        if(!actualResult == true){
            utils.screenShot(pathToScreenShot, webDriver);
        }

        Assert.assertEquals(message, true, actualResult);
    }

}
