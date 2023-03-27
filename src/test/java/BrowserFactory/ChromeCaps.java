package BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeCaps {
    public static ChromeOptions getChromeCaps() {
        {
            SettingsReader set = new SettingsReader();
            ChromeOptions options = new ChromeOptions();
            set.readFile("settings.json");
            options.addArguments(set.getValue("Chrome incognito"));
            options.addArguments(set.getValue("Chrome set english"));
//            options.addArguments("--headless");
            return options;
        }
    }
}

