package steps;

import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.testTask.FibonacciCalculation;
import utils.ContextUtils;
import utils.WebDriverUtils;

@Slf4j
public class CommonSteps {
    FibonacciCalculation fibonacciCalculation = new FibonacciCalculation();

    @When("^Нажимаю на кнопку - '(.*)'$")
    public void clickOnButton(String text) {
        WebElement button = getElementByText(text);
        if (button.isDisplayed()) {
            button.click();
            log.info("Нажал на кнопку - {}", text);
        } else throw new RuntimeException(String.format("Кнопки {} не существует", text));

    }

    @When("^Выбираю пользователя под именем - '(.*)'$")
    public void selectUser(String text) {
        WebElement user = getElementByText(text);
        user.click();
        String userName = user.getText();
        log.info("Перешёл на сайт - {}", userName);
    }

    @When("^Вычисляю сумму и сохраняю как '(.*)'$")
    public void calculateSum(String sum) {
        String depositSum = fibonacciCalculation.calculateFibonacciNumberByCurrentDay().toString();
        ContextUtils.put(sum, depositSum);
        log.info("Сумма для пополнения - {}", depositSum);
    }

    @When("^Проверяю наличие операции '(.*)'$")
    public void checkOperationExists(String text) {
        WebElement operationName = getElementByText(text);
        if (operationName.isDisplayed()) {
            log.info("Операция {} существует", operationName);
        } else
            throw new RuntimeException(String.format("Операции {} не существует", operationName));
    }

    public WebElement getElementByText(String text) {
        return WebDriverUtils.getDriver().findElement(By.xpath(String.format("//*[(text()='%s')]", text)));
//        return WebDriverUtils.getDriver().findElement(By.linkText(text));
    }
}
