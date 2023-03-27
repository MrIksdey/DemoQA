package TestProject;

import BaseElement.AlertsUtil;
import BaseElement.Button;
import BaseElement.Label;
import BaseElement.Log;
import BaseForm.BasePage;
import BrowserFactory.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePage {

    private Button alertButton = new Button(By.id("alertButton"), "Alert button");
    private Button confirmButton = new Button(By.id("confirmButton"), "Confirm button");
    private Label confirmResult = new Label(By.id("confirmResult"), "Confirm result");
    private Label promptResult = new Label(By.id("promptResult"), "Prompt result");
    private Button promptButton = new Button(By.id("promtButton"), "Prompt button");

    public AlertsPage() {
        super(By.id("javascriptAlertsWrapper"), "Alerts page");
    }

    public void clickAlertButton () {
        alertButton.click();
    }

    public void clickConfirmButton () {
        confirmButton.click();
    }

    public String getConfirmResultText () {
        return confirmResult.getText();
    }

    public void clickPromptButton () {
        promptButton.click();
    }

    public String getPromptResultText () {
        return promptResult.getText();
    }

}
