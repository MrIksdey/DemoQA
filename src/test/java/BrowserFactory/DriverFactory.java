package BrowserFactory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private SettingsReader settingsReader = new SettingsReader();
    private WebDriver driver;

    public WebDriver createInstance() {
        settingsReader.readFile("settings.json");
        driver = BrowserFactory.valueOf(settingsReader.getValue("Browser").toUpperCase()).createDriver();
        return driver;
    }

}
