package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AuthPage extends AbstractPage {
    @FindBy(xpath = "//*[contains(@ng-click, 'customer()')]")
    private WebElement customerLoginButton;

    @FindBy(xpath = "//*[contains(@ng-click, 'manager()')]")
    private WebElement bankManagerLoginButton;
}
