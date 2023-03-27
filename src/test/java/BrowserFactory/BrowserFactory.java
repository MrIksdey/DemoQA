package BrowserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.bouncycastle.asn1.x509.Target;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

    public enum BrowserFactory {

        CHROME {
            public WebDriver createDriver() {
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

                return new ChromeDriver(ChromeCaps.getChromeCaps());
            }
        }, FIREFOX {
            public WebDriver createDriver() {
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();

                return new FirefoxDriver(FirefoxCaps.getFirefoxCaps());
            }

        };

        public abstract WebDriver createDriver();

    }

