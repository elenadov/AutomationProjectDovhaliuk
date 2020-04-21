package pageElements;

import libs.ActionsWithWebElements;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class CommonActionWithElements extends HtmlElement implements WebDriverAware {
    protected WebDriver webDriver;
    protected ActionsWithWebElements actionsWithWebElements;
    @Override
    public void setWebDriver(WebDriver driver) {
        this.webDriver = driver;
        actionsWithWebElements = new ActionsWithWebElements(driver);

    }
}
