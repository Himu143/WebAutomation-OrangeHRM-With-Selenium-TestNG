package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

import java.util.List;

public class PersonalDetailsPage {

    @FindBy(className = "oxd-radio-input")
    public List<WebElement> radioBtn;

    @FindBy(tagName = "button")
    public List<WebElement> saveBtn1;

    @FindBy(tagName = "button")
    public List<WebElement> saveBtn2;

   @FindBy(className = "oxd-select-text-input")
   public  List<WebElement>dropdownBlood;
   @FindBy(className = "orangehrm-tabs-item")
   public List<WebElement> contactDetails;
    @FindBy(tagName = "input")
    public List<WebElement> txtInput;
    @FindBy(className = "oxd-select-text-input")
    public WebElement selectCountry;
    @FindBy(css ="[type=submit]" )
    public WebElement saveBtn;
 WebDriver driver;
    public PersonalDetailsPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }


    public void selectGender() throws InterruptedException {
        radioBtn.get(0).click();
        Thread.sleep(3000);
        saveBtn1.get(1).click();
    }
    public void selectBloodGroup() throws InterruptedException {

        dropdownBlood.get(2).click();
        Thread.sleep(3000);
        saveBtn2.get(2).click();


    }

    public void contactDetailsInput() throws InterruptedException {

        contactDetails.get(1).click();
    }
}
