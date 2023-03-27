package BrowserFactory;

import org.openqa.selenium.WebDriver;

public class Browser {
    static DriverFactory driverFactory = new DriverFactory();
    static WebDriver driver;

    public static WebDriver createInstance(){
        driver = driverFactory.createInstance();
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void goToUrl(String url){
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void quitBrowser() {
        driver.quit();
    }


}
