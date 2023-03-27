package TestProject;

import BaseElement.Button;
import BaseElement.Frame;
import BaseForm.BasePage;
import org.openqa.selenium.By;

public class NestedFramesPage extends BasePage {

    private Frame frame = new Frame(By.id("frame1"),"body","Frames" , "frame1");
    private Button framesButton = new Button(By.xpath("//*[@class='menu-list']//li//span[contains(text(), 'Frames')]"),"Frames button");

    public NestedFramesPage() {
        super(By.xpath("*//div[@id='framesWrapper']//div[contains(text(), 'Nested')]"), "Nested frames page" );
    }

    public String getParentText(){
        frame.switchFrameByLocator();
        String parentText = frame.getElementInFrameByTagName().getText();
        return parentText;
    }

    public String getChildText(){
        frame.switchToChildFrame();
        String childText = frame.getElementInFrameByTagName().getText();
        return childText;
    }

    public void clickFramesButton(){
        frame.switchToDefaultFrame();
        framesButton.click();
    }

}
