package TestProject;

import BaseElement.Log;
import BaseForm.BasePage;
import BrowserFactory.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SamplePage extends BasePage {

    private WebDriver driver = Browser.getDriver();
    private String name;

    public SamplePage() {
        super(By.id("sampleHeading"), "Sample page");
        this.name = name;
    }

    public void closeCurrentTab () {
        Log.info("Closing " +name);
        driver.close();
    }
}
