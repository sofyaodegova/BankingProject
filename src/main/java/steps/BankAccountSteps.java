package steps;

import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import pageObjects.CustomerAuthPage;
import pageObjects.HarryPotterAccountPage;
import pageObjects.TransactionPage;
import ru.testTask.ConfigurationProperties;
import utils.ContextUtils;
import utils.WebDriverUtils;


@Slf4j
public class BankAccountSteps {

    CustomerAuthPage customerAuthPage = new CustomerAuthPage();
    HarryPotterAccountPage harryPotterAccountPage = new HarryPotterAccountPage();

    TransactionPage transactionPage = new TransactionPage();
    CommonSteps commonSteps = new CommonSteps();

    @When("^Перехожу на сайт банка XYZ$")
    public void openSite() {
        String loginPage = ConfigurationProperties.getProperty("loginPage");
        WebDriverUtils.getDriver().get(loginPage);
        log.info("Перешёл на сайт - {}", loginPage);
    }

    @When("^Выбираю селектор \"Your Name\"$")
    public void selectYourName() {
        customerAuthPage.getYourNameSelector().click();
        log.info("Выбрал селектор Your Name");
    }

    @When("^Ввожу сумму '(.*)', в поле ввода суммы$")
    public void inputToField(String sum) {
        String inputSum = ContextUtils.get(sum).toString();
        harryPotterAccountPage.getAmountField().sendKeys(inputSum);
        log.info("Введена сумма - {}", inputSum);
    }

    @When("^Проверяю, что поле ввода суммы для пополнения счёта существует$")
    public void checkDepositAmountFieldExists() {
        if (harryPotterAccountPage.getAmountToBeDepositedText().isDisplayed()) {
            log.info("Поле ввода суммы для пополнения счёта существует");
        } else throw new RuntimeException(String.format("Ошибка! Такого поля не существует"));
    }

    @When("^Проверяю, что поле ввода для снятия суммы со счёта существует$")
    public void checkWithdrawnAmountFieldExists() {
        if (harryPotterAccountPage.getAmountToBeWithdrawnText().isDisplayed()) {
            log.info("Поле ввода для снятия суммы со счёта существует");
        } else throw new RuntimeException(String.format("Ошибка! Такого поля не существует"));
    }

    @When("^Проверяю, что баланс равен '(.*)'$")
    public void checkBalance(String balance) {
        String currentBalance = harryPotterAccountPage.getBalance().toString();
        if (currentBalance.matches(balance)) {
            log.info("Текущий баланс " + currentBalance + " равен запрашиваемому " + balance);
        } else
            throw new RuntimeException(String.format("Текущий баланс не равен " + balance + ". Текущий баланс: "
                    + currentBalance));
    }

    @When("^Проверяю, что вход в аккаунт '(.*)' выполнен успешно")
    public void checkSuccessAuth(String accountName) {
        WebElement name = commonSteps.getElementByText(accountName);
        if (name.isDisplayed()) {
            log.info("Вход в аккаунт {} выполнен успешно", accountName);
        } else
            throw new RuntimeException(String.format("Ошибка! Вход в аккаунт не выполнен. Попробуйте ещё раз"));
    }

    @When("^Проверяю статус банковской операции$")
    public void checkOperationSuccess() {
        if (harryPotterAccountPage.getSuccessText().isDisplayed()) {
            log.info("Операция выполнена успешно");
        } else if (harryPotterAccountPage.getFailText().isDisplayed()) {
            log.info("Операция не выполнена, попробуйте ещё раз");
        } else throw new
                RuntimeException(String.format("Неизвестная ошибка, попробуйте ещё раз"));
    }

    @When("^Выбираю операцию Deposit$")
    public void doDepositOperation() {
        harryPotterAccountPage.getDepositButton().click();
    }

    @When("^Выбираю операцию Withdrawl$")
    public void doWithdrawlOperation() {
        harryPotterAccountPage.getWithdrawlButton().click();
    }

    @When("^Проверяю операции по счету$")
    public void checkTransactions() throws InterruptedException {
        harryPotterAccountPage.getTransactionsButton().click();
        Thread.sleep(1000);
    }

    @When("^Выставляю начальное время операций по счету$")
    public void setStartTime() throws InterruptedException {
        WebDriverUtils.getDriver().navigate().refresh();
        Thread.sleep(1000);
        transactionPage.getStartTime().sendKeys("000");
    }
}
