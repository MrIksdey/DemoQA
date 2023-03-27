package TestProject;

import BaseElement.Button;
import BaseForm.BasePage;
import org.openqa.selenium.By;

public class AlertsFrameWindowsPage extends BasePage {

    Button alertsButton = new Button(By.xpath("//*[@class='menu-list']//li//span[contains(text(), 'Alerts')]"),"Alerts button");
    Button nestedFramesButton = new Button(By.xpath("//*[@class='menu-list']//li//span[contains(text(), 'Nested')]"),"Nested Frames button");
    Button browserWindowsButton = new Button(By.xpath("//*[@class='menu-list']//li//span[contains(text(), 'Browser')]"),"Browser Windows button");


    public AlertsFrameWindowsPage() {
        super(By.xpath("//*[contains(text(), 'Please select')]"), "Alerts, Frame & Windows page");
    }


    void clickAlertsButton(){
        alertsButton.click();
    }

    void clickNestedFramesButton(){
        nestedFramesButton.click();
    }
    void clickBrowserWindowsButton(){
        browserWindowsButton.click();
    }


}
