package BrowserFactory;

import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxCaps  {
        public static FirefoxOptions getFirefoxCaps()
        {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("-private");
                options.addPreference("intl.accept_languages","en-gb");
//                options.setHeadless(true);
                return options;
        }
}
