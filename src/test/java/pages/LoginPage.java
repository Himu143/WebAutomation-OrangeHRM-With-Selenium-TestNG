package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(name = "username")
    WebElement txtUserName;
    @FindBy(name ="password")
    WebElement txtPassword;
    @FindBy(css ="[type=submit]")
    WebElement btnLogin;
    @FindBy(tagName = "p")
    WebElement lvlInvalidCreds;


    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void doLogin(String username,String password){
        txtUserName.sendKeys(username);//username
        txtPassword.sendKeys(password);//password
        btnLogin.click();
    }
    public String doLogInWithInvalidCreds(String username, String password){
        txtUserName.sendKeys(username);//username
        txtPassword.sendKeys(password);//password
        btnLogin.click();
        return lvlInvalidCreds.getText();
    }
}
