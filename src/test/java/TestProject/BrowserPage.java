package TestProject;

import BaseElement.Button;
import BaseElement.ConditionalWait;
import BaseElement.Log;
import BaseForm.BasePage;
import BrowserFactory.Browser;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BrowserPage extends BasePage {

    private WebDriver driver = Browser.getDriver();
    private Button tabButton = new Button(By.id("tabButton"), "New Tab button");
    private Button elementsButton = new Button(By.xpath("*//div[@class='header-wrapper']//div[contains(text(), 'Elements')]"),"Elements button");
    private Button linksButton = new Button(By.xpath("//*[@class='menu-list']//li//span[contains(text(), 'Links')]"),"Web tables button");

    public BrowserPage() {
        super(By.id("browserWindows"), "Browser Windows page");
    }


    public void clickNewTabButton (){
        tabButton.click();
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

    public void clickElementsButton () {
        elementsButton.click();
    }
    public void clickLinksButton () {
        linksButton.click();
    }

}
