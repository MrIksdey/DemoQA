package BaseElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextBox extends BaseElement{
    private ConditionalWait waits =new ConditionalWait();
    private String name;
    private By locator;
    public TextBox(By locator, String name) {
        super(locator, name);
        this.name = name;
        this.locator=locator;
    }

    public void sendKeys (String text){
        WebElement field = getElement();
        field.sendKeys(text);
    }

    public void clearField () {
        WebElement field = getElement();
        field.clear();
    }

    public boolean isTextBoxClosed() {
        Log.info("Is element " +name+ "invisible?");
        waits.waitForElementToBeInvisible(locator);
        return true;
    }
}
