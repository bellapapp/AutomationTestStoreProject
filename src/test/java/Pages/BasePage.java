package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;
public class BasePage {

    WebDriver driver;

    public void baseFluentWaitForElementToBeVisible(int timeOut, int polling, WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(timeOut));
        wait.pollingEvery(Duration.ofSeconds(polling));
        wait.ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void baseFluentWaitForElementToBeClickable(int timeOut, int polling, WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(timeOut));
        wait.pollingEvery(Duration.ofSeconds(polling));

        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public int getIntFromPrice(String priceNonFormatted) {
        return Integer.parseInt(priceNonFormatted
                .replace(",", "")
                .replace(".", "")
                .replace("$", "")
                .replace("£", "")
                .replace("€", ""));
    }
}
