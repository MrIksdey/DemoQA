package TestProject;

import BaseElement.AlertsUtil;
import BaseElement.Log;
import BrowserFactory.SettingsReader;
import UtilPackage.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoQATest extends BaseTest {
    SettingsReader settingsReader = new SettingsReader();

    @Test
    public void alerts() {
        Log.info("**************************** Test scenario: \"Alerts\" is starting ****************************");

        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page is not opened");
        mainPage.clickAlertsFrameWindowsButton();

        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.isPageOpen();
        alertsFrameWindowsPage.clickAlertsButton();

        AlertsPage alertsPage = new AlertsPage();
        Assert.assertTrue(alertsPage.isPageOpen(), "Page is not opened");
        alertsPage.clickAlertButton();
        AlertsUtil alertsUtil = new AlertsUtil();
        Assert.assertEquals(alertsUtil.getAlertText(), "You clicked a button", "Message is not the same");
        alertsUtil.clickOkInAlert();
        Assert.assertFalse(alertsUtil.isAlertPresent(), "Alert is not closed");
        alertsPage.clickConfirmButton();
        Assert.assertEquals(alertsUtil.getAlertText(), "Do you confirm action?", "Message is not the same");
        alertsUtil.clickOkInAlert();
        Assert.assertFalse(alertsUtil.isAlertPresent(), "Alert is not closed");
        Assert.assertEquals(alertsPage.getConfirmResultText(),"You selected Ok", "Message is not the same");
        alertsPage.clickPromptButton();
        Assert.assertEquals(alertsUtil.getAlertText(), "Please enter your name", "Message is not the same");

        RandomUtils randomUtils = new RandomUtils();
        String randomText = randomUtils.randGeneratedStr(10);

        alertsUtil.sendKeysToAlert(randomText);
        alertsUtil.clickOkInAlert();
        Assert.assertFalse(alertsUtil.isAlertPresent(), "Alert is not closed");
        Assert.assertEquals(alertsPage.getPromptResultText(),"You entered " +randomText, "Message is not the same");

        Log.info("**************************** Test scenario: \"Alerts\" is done ****************************");
    }

    @Test
    public void iframe() {
        Log.info("**************************** Test scenario: \"Iframe\" is starting ****************************");

        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page is not opened");
        mainPage.clickAlertsFrameWindowsButton();

        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.clickNestedFramesButton();

        NestedFramesPage nestedFramesPage = new NestedFramesPage();
        Assert.assertTrue(nestedFramesPage.isPageOpen(), "Page is not opened");
        Assert.assertEquals(nestedFramesPage.getParentText(),"Parent frame", "There is no parent frame message or is not equal");
        Assert.assertEquals(nestedFramesPage.getChildText(),"Child Iframe", "There is no child iframe message or is not equal");
        nestedFramesPage.clickFramesButton();

        FramesPage framesPage = new FramesPage();
        Assert.assertTrue(framesPage.isPageOpen(), "Page is not opened");
        Assert.assertEquals(framesPage.getBiggerFrameText(),"This is a sample page", "There is no parent frame message or is not equal");
        Assert.assertEquals(framesPage.getSmallerFrameText(),"This is a sample page", "There is no parent frame message or is not equal");
        framesPage.switchToDefaultFrame();

        Log.info("**************************** Test scenario: \"Iframe\" is done ****************************");
    }

    @Test
    public void tables() {
        Log.info("**************************** Test scenario: \"Tables\" is starting ****************************");

        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page is not opened");
        mainPage.clickElementsButton();

        ElementsPage elementsPage = new ElementsPage();
        elementsPage.clickWebTablesButton();

        WebTablesPage webTablesPage = new WebTablesPage();
        Assert.assertTrue(webTablesPage.isPageOpen(), "Page is not opened");
        webTablesPage.clickAddButton();
        Assert.assertTrue(webTablesPage.isRegistrationFormOpen(), "Registration form is not open");

        settingsReader.readFile("settings.json");
        String idPlusNumber = "ID1";
        webTablesPage.sendKeysToRegistrationForm(Integer.parseInt(settingsReader.getValueLong(idPlusNumber)));
        webTablesPage.clickSubmitButton();
        Assert.assertTrue(webTablesPage.isRegistrationFormClosed(), "Registration form is still open");

        for (int i = 0;i<webTablesPage.getAllTestData(Integer.parseInt(settingsReader.getValueLong(idPlusNumber))).size();i++){
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(webTablesPage.allDataRegistered().contains(webTablesPage.getAllTestData(Integer.parseInt(settingsReader.getValueLong(idPlusNumber))).get(i)),"Data are not the same");
        }

        int beforeDeleteLength = webTablesPage.getAmountOfRegistrationElements();
        webTablesPage.clickDeleteButton();
        int afterDeleteLength = webTablesPage.getAmountOfRegistrationElements();

        Assert.assertTrue(beforeDeleteLength>afterDeleteLength,"Number of record in table has not decreased");

        for (int i = 0;i<webTablesPage.getAllTestData(Integer.parseInt(settingsReader.getValueLong(idPlusNumber))).size();i++){
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertFalse(webTablesPage.allDataRegistered().contains(webTablesPage.getAllTestData(Integer.parseInt(settingsReader.getValueLong(idPlusNumber))).get(i)),"Data are not the same");
        }

        Log.info("**************************** Test scenario: \"Tables\" is done ****************************");
    }

    @Test
    public void handles() {
        Log.info("**************************** Test scenario: \"Handles\" is starting ****************************");

        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(), "Main page is not opened");
        mainPage.clickAlertsFrameWindowsButton();

        AlertsFrameWindowsPage alertsFrameWindowsPage = new AlertsFrameWindowsPage();
        alertsFrameWindowsPage.clickBrowserWindowsButton();

        BrowserPage browserPage = new BrowserPage();
        Assert.assertTrue(browserPage.isPageOpen(),"Browser page is not opened");
        browserPage.clickNewTabButton();
        browserPage.switchToNewTab();

        SamplePage samplePage = new SamplePage();
        Assert.assertTrue(samplePage.isPageOpen(),"Sample page is not opened");
        samplePage.closeCurrentTab();

        browserPage.switchToMainTab();
        Assert.assertTrue(browserPage.isPageOpen(),"Browser page is not opened");
        browserPage.clickElementsButton();
        browserPage.clickLinksButton();

        LinksPage linksPage = new LinksPage();
        Assert.assertTrue(linksPage.isPageOpen(),"Links page is not opened");
        linksPage.clickHomeButton();
        linksPage.switchToNewTab();

        mainPage = new MainPage();
        Assert.assertTrue(mainPage.isPageOpen(),"Main page is not opened");

        linksPage.switchToMainTab();
        Assert.assertTrue(linksPage.isPageOpen(),"Links page is not opened");

        Log.info("**************************** Test scenario: \"Handles\" is done ****************************");
    }
}
