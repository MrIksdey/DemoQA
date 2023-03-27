package BaseElement;

import BrowserFactory.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Frame extends BaseElement {
    private WebDriver driver = Browser.getDriver();
    private String locatorTagName;
    private By locator;
    private String locator1;

    public Frame(By locator, String locatorTagName, String name, String locator1) {
        super(locator, name);
        this.locatorTagName = locatorTagName;
        this.locator = locator;
        this.locator1 = locator1;
    }

    public WebElement getElementInFrameByTagName() {
        Log.info("Getting WebElement by tagname: "+locatorTagName);
        WebElement frameElement = driver.findElement(By.tagName(locatorTagName));
        return frameElement;
    }

    public void switchToDefaultFrame(){
        Log.info("Switching to default frame");
        driver.switchTo().defaultContent();
    }

    public void switchFrameByLocator() {
        switchToDefaultFrame();
        Log.info("Switching to frame by locator: " + locator);
        driver.switchTo().frame(locator1);
    }

    public void switchToChildFrame() {
        switchFrameByLocator();
        Log.info("Switching to child frame");
        driver.switchTo().frame(0);
    }
}


