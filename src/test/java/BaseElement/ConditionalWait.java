package BaseElement;

import BrowserFactory.Browser;
import BrowserFactory.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ConditionalWait {
    WebDriver driver = Browser.getDriver();
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void waitForElementToBeVisible (By element) {
         wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public void waitForElementToBeClickable(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeInvisible(By element) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void alertIsPresent() {
        Log.info("Is alert present?");
        wait.until(ExpectedConditions.alertIsPresent());
        Log.info("Alert is present");
    }

}
