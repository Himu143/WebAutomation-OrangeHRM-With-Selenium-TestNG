package test_runner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;
import pages.PersonalDetailsPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

public class SecondUserTestRunner extends Setup {
    DashboardPage dashboardPage;
    LoginPage loginPage;
    PIMPage pimPage;
    PersonalDetailsPage personalDetailsPage;
    @BeforeTest
    public void doLoginWithSecondUser() throws IOException, ParseException, InterruptedException {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        pimPage=new PIMPage(driver);
        JSONObject userObject = Utils.loadJSONFileArray("./src/test/resources/NewUser.json", 1);
        String username = userObject.get("username").toString();
        String password = userObject.get("password").toString();
        loginPage.doLogin(username, password);
        Thread.sleep(3000);
        dashboardPage.menus.get(2).click();

    }
@Test(priority = 1,description = "user select gender")
public void gender() throws InterruptedException {
    personalDetailsPage = new PersonalDetailsPage(driver);

    personalDetailsPage.selectGender();
    Utils.doScorlling(driver, 400);
    Thread.sleep(9000);
}
@Test(priority = 2,description = "user update select blood group")
public void updateBlood() throws InterruptedException {
        personalDetailsPage.selectBloodGroup();
    personalDetailsPage.dropdownBlood.get(2).sendKeys(Keys.ARROW_DOWN);
    Thread.sleep(2000);
    personalDetailsPage.dropdownBlood.get(2).sendKeys(Keys.ARROW_DOWN);
    Thread.sleep(2000);
    personalDetailsPage.dropdownBlood.get(2).sendKeys(Keys.ARROW_DOWN);
    Thread.sleep(2000);
    personalDetailsPage.dropdownBlood.get(2).sendKeys(Keys.ARROW_DOWN);
    Thread.sleep(2000);
    personalDetailsPage.dropdownBlood.get(2).sendKeys(Keys.ARROW_DOWN);
    Thread.sleep(2000);
    personalDetailsPage.dropdownBlood.get(2).sendKeys(Keys.ENTER);
    Thread.sleep(4000);



    }
    @Test(priority = 3,description = "user update contact details")
    public void updateContactDetails() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(5000);
        personalDetailsPage.contactDetailsInput();
        Thread.sleep(2000);
        personalDetailsPage.txtInput.get(1).sendKeys("234 Soho Hill");
        Thread.sleep(2000);
        personalDetailsPage.txtInput.get(2).sendKeys("Indianapolis");
        Thread.sleep(2000);
        personalDetailsPage.txtInput.get(3).sendKeys("Birmingham");
        Thread.sleep(2000);
        personalDetailsPage.txtInput.get(4).sendKeys("West Midlands");
        Thread.sleep(2000);
        personalDetailsPage.txtInput.get(5).sendKeys("1893");
        Thread.sleep(2000);
        personalDetailsPage.selectCountry.click();
        personalDetailsPage.selectCountry.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        personalDetailsPage.selectCountry.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        personalDetailsPage.selectCountry.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        personalDetailsPage.selectCountry.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        personalDetailsPage.selectCountry.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        personalDetailsPage.txtInput.get(7).sendKeys("+18927363895");
        personalDetailsPage.txtInput.get(9).sendKeys("testuser"+Utils.generateRandomNumber(10,99)+"@gmail.com");
        Thread.sleep(3000);
        personalDetailsPage.saveBtn.click();





    }
    @AfterTest
    public void userlogOut() {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.doLogout();
    }



}
