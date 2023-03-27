package BaseElement;

import BrowserFactory.Browser;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertsUtil {
    private WebDriver driver = Browser.getDriver();
    private ConditionalWait wait = new ConditionalWait();

    public String getAlertText() {
        wait.alertIsPresent();
        Log.info("Getting alert text");
        String alertText = driver.switchTo().alert().getText();
        Log.info("Alert text is: " +alertText);
        return alertText;
    }

    public void clickOkInAlert() {
        wait.alertIsPresent();
        Log.info("Clicking OK in alert");
        driver.switchTo().alert().accept();
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            Log.info("Alert is present");
            return true;
        } catch (NoAlertPresentException Ex) {
            Log.info("Alert is not present");
            return false;
        }
    }

    public void sendKeysToAlert(String keys) {
        wait.alertIsPresent();
        Log.info("Entering randomly generated text: " + keys);
        driver.switchTo().alert().sendKeys(keys);
    }
}
