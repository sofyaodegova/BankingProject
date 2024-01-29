package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CustomerAuthPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@id, 'userSelect')]")
    private WebElement yourNameSelector;

    @FindBy(xpath = "//*[contains(@text, 'Harry Potter')]")
    private WebElement harryPotterName;

    @FindBy(xpath = "//*[contains(@type, 'submit')]")
    private WebElement loginButton;

}
