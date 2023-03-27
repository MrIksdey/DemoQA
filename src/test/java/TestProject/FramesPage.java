package TestProject;

import BaseElement.Frame;
import BaseForm.BasePage;
import org.openqa.selenium.By;

public class FramesPage extends BasePage {

    Frame frame1 = new Frame(By.id("frame1"),"h1","Bigger frame","frame1");
    Frame frame2 = new Frame(By.id("frame2"),"h1","Smaller frame","frame2");


    public FramesPage() {
        super(By.xpath("*//div[@id='framesWrapper']//div[contains(text(), 'Iframe page')]"), "2 Iframes page" );
    }

    public String getBiggerFrameText () {
        frame1.switchFrameByLocator();
        String biggerFrameText = frame1.getElementInFrameByTagName().getText();
        return biggerFrameText;
    }

    public String getSmallerFrameText () {
        frame2.switchFrameByLocator();
        String smallerFrameText = frame1.getElementInFrameByTagName().getText();
        return smallerFrameText;
    }

    public void switchToDefaultFrame() {
        frame2.switchToDefaultFrame();
    }


}
