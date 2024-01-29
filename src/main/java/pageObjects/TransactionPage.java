package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class TransactionPage extends AbstractPage {
    @FindBy(xpath = "//*[contains(@class, 'ng-binding')][text()='Credit']")
    private WebElement credit;

    @FindBy(xpath = "//*[contains(@class, 'ng-binding')][text()='Debit']")
    private WebElement debit;

    @FindBy(xpath = "//*[@type='datetime-local' and @id='start']")
    private WebElement startTime;

    @FindBy(xpath = "//*[@type='datetime-local' and @id='end']")
    private WebElement endTime;
}
