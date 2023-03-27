package BaseForm;

import BaseElement.ConditionalWait;
import BaseElement.Log;
import org.openqa.selenium.By;



public abstract class BasePage {
    private By uniqueFormLocator;
    private String formName;
    private ConditionalWait wait = new ConditionalWait();

    public BasePage(By locator, String name){
        uniqueFormLocator = locator;
        formName = name;
    }

    public boolean isPageOpen(){
        Log.info("Is "+formName+" open?");
        wait.waitForElementToBeVisible(uniqueFormLocator);
        Log.info(formName + " is opened");
        return true;
    }

    public String getPageLabel() {
        Log.info("Getting page label");
        String label = uniqueFormLocator.toString()+" " + formName + " unique locator";
        return label;
    }
}
