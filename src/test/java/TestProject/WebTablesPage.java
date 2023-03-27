package TestProject;

import BaseElement.Button;
import BaseElement.Label;
import BaseElement.TextBox;
import BaseForm.BasePage;
import BrowserFactory.SettingsReader;
import UtilPackage.DataReader;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class WebTablesPage extends BasePage {

    private DataReader dataReader = new DataReader();
    private Button addButton = new Button(By.id("addNewRecordButton"),"Add button");
    private TextBox registrationForm = new TextBox(By.id("registration-form-modal"),"Registration Form");
    private TextBox firstNameField = new TextBox(By.id("firstName"),"First name field");
    private TextBox lastNameField = new TextBox(By.id("lastName"),"Last name field");
    private TextBox userEmailField = new TextBox(By.id("userEmail"),"Email field");
    private TextBox ageField = new TextBox(By.id("age"),"Age field");
    private TextBox salaryField = new TextBox(By.id("salary"),"Salary field");
    private TextBox departmentField = new TextBox(By.id("department"),"Department field");
    private Button submitButton = new Button(By.id("submit"),"Submit button");
    private Label registrationData= new Label(By.xpath("*//div[@class='rt-tbody']"),"Registration data");
    private Button deleteButton=new Button(By.id("delete-record-4"),"Delete button");


    public WebTablesPage() {
        super(By.xpath("*//div[@class='web-tables-wrapper']"), "Web tables page");
    }

    public void clickAddButton (){
        addButton.click();
    }

    public boolean isRegistrationFormOpen () {
       return registrationForm.isDisplayed();
    }

    public void sendKeysToRegistrationForm (int id) {
        dataReader.readFile("testdata.json");
        firstNameField.sendKeys(dataReader.getValueString("first_name",id));
        lastNameField.sendKeys(dataReader.getValueString("last_name",id));
        userEmailField.sendKeys(dataReader.getValueString("email",id));
        ageField.sendKeys(dataReader.getValueLong("age",id));
        salaryField.sendKeys(dataReader.getValueLong("salary",id));
        departmentField.sendKeys(dataReader.getValueString("department",id));
    }

    public void clickSubmitButton () {
        submitButton.click();
    }

    public boolean isRegistrationFormClosed() {
        return registrationForm.isInvisible();
    }

    public String allDataRegistered(){
        return registrationData.getText();
    }
    public ArrayList<String> getAllTestData(int id) {
        ArrayList<String> testData = new ArrayList<String>();
         testData.add(dataReader.getValueString("first_name",id));
         testData.add(dataReader.getValueString("last_name",id));
         testData.add(dataReader.getValueString("email",id));
         testData.add(dataReader.getValueLong("age",id));
         testData.add(dataReader.getValueLong("salary",id));
         testData.add(dataReader.getValueString("department",id));
         return testData;
    }

    public int getAmountOfRegistrationElements(){
        int amountOfRegistrationElements = allDataRegistered().length();
        return amountOfRegistrationElements;
    }

    public void clickDeleteButton(){
        deleteButton.click();
    }
}
