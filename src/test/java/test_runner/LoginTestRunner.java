package test_runner;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

public class LoginTestRunner extends Setup {
    LoginPage loginPage;

@Test(priority = 1,description = "User doLogin with invalid credential")
    public void doLoginWithInvalidCreds(){
        loginPage=new LoginPage(driver);
        //driver.get(" https://opensource-demo.orangehrmlive.com/");
        String message_actual= loginPage.doLogInWithInvalidCreds("admin","123");
        String message_expected="Invalid credentials";
        Assert.assertTrue(message_actual.contains(message_expected));
    }
    @Test(priority =2,description = "User login with valid credential")
    public void doLogin() throws IOException, ParseException {
        LoginPage loginPage=new LoginPage(driver);
        JSONObject userObject= Utils.loadJSONFile("./src/test/resources/User.json");
        String username= (String) userObject.get("username");
        String password= (String) userObject.get("password");
        //driver.get(" https://opensource-demo.orangehrmlive.com/");
        loginPage.doLogin(username,password);
        WebElement headerText= driver.findElement(By.tagName("h6"));
        SoftAssert softAssert=new SoftAssert();
        String header_actual=headerText.getText();
        String header_expected= "Dashboard";
        softAssert.assertEquals(header_actual,header_expected);
    }

}
