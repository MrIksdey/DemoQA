package TestProject;

import BaseElement.Button;
import BaseElement.Log;
import BaseForm.BasePage;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    Button alertsFrameWindowsButton = new Button(By.xpath("//*[contains(text(), 'Alerts')]"), "Alerts, Frame & Windows");
    Button elementsButton = new Button(By.xpath("//div[@id='app']//*[contains(text(), 'Elements')]"), "Elements");

    public MainPage() {
        super(By.className("home-banner"), "Main page");
    }

    public void clickAlertsFrameWindowsButton() {
        alertsFrameWindowsButton.click();
    }

    public void clickElementsButton() {
        elementsButton.click();
    }

}
