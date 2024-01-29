package pageObjects;

import org.openqa.selenium.support.PageFactory;
import utils.WebDriverUtils;

public abstract class AbstractPage {
    public AbstractPage() {
        PageFactory.initElements(WebDriverUtils.getDriver(), this);
    }
}