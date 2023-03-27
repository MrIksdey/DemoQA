package TestProject;

import BaseElement.Button;
import BaseForm.BasePage;
import org.openqa.selenium.By;

public class ElementsPage extends BasePage {

    private Button webTablesButton = new Button(By.xpath("//*[@class='menu-list']//li//span[contains(text(), 'Web Tables')]"),"Web tables button");

    public ElementsPage() {
        super(By.xpath("//*[contains(text(), 'Please select')]"), "Elements page");
    }

    public void clickWebTablesButton () {
        webTablesButton.click();
    }

}
