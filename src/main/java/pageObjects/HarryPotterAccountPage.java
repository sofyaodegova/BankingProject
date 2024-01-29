package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.testTask.FibonacciCalculation;

@Getter
public class HarryPotterAccountPage extends AbstractPage {
    FibonacciCalculation fibonacciCalculation;

    @FindBy(xpath = "//*[contains(@ng-click, 'transactions()')]")
    private WebElement transactionsButton;

    @FindBy(xpath = "//*[contains(@ng-click, 'deposit()')]")
    private WebElement depositButton;

    @FindBy(xpath = "//*[contains(@ng-click, 'withdrawl()')]")
    private WebElement withdrawlButton;

    @FindBy(xpath = "//*[contains(@placeholder, 'amount')]")
    private WebElement amountField;

    @FindBy(xpath = "//*[label//text()='Amount to be Withdrawn :']")
    private WebElement amountToBeWithdrawnText;

    @FindBy(xpath = "//*[label//text()='Amount to be Deposited :']")
    private WebElement amountToBeDepositedText;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//*[contains(text(), 'uccessful')]")
    private WebElement successText;

    @FindBy(xpath = "//*[contains(text(), 'Failed')]")
    private WebElement failText;

    @FindBy(xpath = "//*[contains(@class, 'ng-binding')][2]")
    private WebElement balance;

}