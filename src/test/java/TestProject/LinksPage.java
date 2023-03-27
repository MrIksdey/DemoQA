package TestProject;

import BaseElement.Button;
import BaseElement.Log;
import BaseForm.BasePage;
import BrowserFactory.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class LinksPage extends BasePage {

    private WebDriver driver = Browser.getDriver();
    private Button homeButton = new Button(By.id("simpleLink"),"Home button");

    public LinksPage() {
        super(By.id("linkWrapper"), "Links page");
    }

    public void clickHomeButton () {
        homeButton.click();
    }

    public void switchToNewTab()
    {
        Log.info("Getting window handles");
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        Log.info("Handles: "+tabs2.size());
        Log.info("Switching to new tab");
        driver.switchTo().window(tabs2.get(1));
    }
    public void switchToMainTab() {
        Log.info("Getting window handles");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        Log.info("Handles: " + tabs.size());
        Log.info("Switching to main tab");
        driver.switchTo().window(tabs.get(0));
    }
}
