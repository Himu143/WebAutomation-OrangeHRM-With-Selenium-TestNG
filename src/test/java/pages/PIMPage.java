package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMPage {
    @FindBy(className = "oxd-button")
    List<WebElement> addBtn;
    @FindBy(css = "[name= firstName]")
    WebElement txtFirstName;
    @FindBy(css = "[name= lastName]")
    WebElement txtLastName;
    @FindBy(className = "oxd-switch-input--active")
    public
    WebElement toggleBtn;
    @FindBy(tagName = "input")
    public
    List<WebElement> txtInput;
    @FindBy(className = "bi-pencil-fill")
    public
    WebElement editUser;
    @FindBy(tagName = "input")
    public
    List<WebElement> txtEmployeeId;

    @FindBy(tagName = "button")
    List<WebElement> saveBtn;
    @FindBy(css = "[type=submit]")
    public WebElement searchBtn;


    WebDriver driver;

    public PIMPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    public void createEmployee(String firstname, String lastname, String username, String password, String employeeId) {
        addBtn.get(2).click();
        txtFirstName.sendKeys(firstname);        //FirstName
        txtLastName.sendKeys(lastname);//LastName
        txtEmployeeId.get(5).sendKeys(Keys.CONTROL + "a");
        txtEmployeeId.get(5).sendKeys(employeeId);
        toggleBtn.click();                      //click on toggle button
        txtInput.get(7).sendKeys(username);     //username
        txtInput.get(10).sendKeys(password);    //password
        txtInput.get(11).sendKeys(password);    //confirmPassword
        saveBtn.get(3).click();                 //save button


    }

    public void SearchEmployeeByNewId(String userEmpId) throws InterruptedException {
        txtEmployeeId.get(2).sendKeys(userEmpId);
        Thread.sleep(1500);
        searchBtn.click();
    }
    public void SearchEmployeeByValidName(String employeeName) throws InterruptedException {
        txtInput.get(1).sendKeys(employeeName);
        Thread.sleep(1500);
        searchBtn.click();
    }








}