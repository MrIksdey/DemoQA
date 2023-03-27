package BaseElement;

import BrowserFactory.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract class BaseElement {
    private By uniqueLocator;
    private String elementName;
    private ConditionalWait waits =new ConditionalWait();
    private WebDriver driver = Browser.getDriver();

    public BaseElement(By locator,String name){
        uniqueLocator = locator;
        elementName = name;
    }

    protected WebElement getElement() {
        return driver.findElement(uniqueLocator);
    }

    public void click() {
        Log.info("Waiting for element " +elementName+ " to be visible");
        waits.waitForElementToBeVisible(uniqueLocator);
        Log.info("Waiting for element " +elementName+ " to be clickable");
        waits.waitForElementToBeClickable(uniqueLocator);
        Log.info("Clicking " +elementName);
        getElement().click();
    }

    public String getText() {
        Log.info("Waiting for element " +elementName+ " to be visible");
        waits.waitForElementToBeVisible(uniqueLocator);
        Log.info("Getting element text");
        return getElement().getText();
    }

    public boolean isDisplayed() {
        Log.info("Is element " +elementName+ " displayed?");
        waits.waitForElementToBeVisible(uniqueLocator);
        return getElement().isDisplayed();
    }

    public boolean isInvisible() {
        Log.info("Is element " +elementName+ " invisible?");
        waits.waitForElementToBeInvisible(uniqueLocator);
        return true;
    }

    public String getAttribute(String name) {
        Log.info("Is element visible?");
        waits.waitForElementToBeVisible(uniqueLocator);
        Log.info("Getting element attribute");
        String attribute = getElement().getAttribute(name);
        return attribute;
    }

}
