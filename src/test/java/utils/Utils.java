package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Utils {
    public static void doScorlling(WebDriver driver, int heightPixel){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+heightPixel+")");

    }
    public static JSONObject loadJSONFile(String fileLocation) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileLocation));
        JSONObject jsonObject = (JSONObject) obj;

        return jsonObject;
    }
    public static void waitForElement(WebDriver driver, WebElement webElement, int timeUnit_sec){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeUnit_sec));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static int generateRandomNumber(int min, int max){

        return (int)Math.round(Math.random()* (max-min)+min);
    }


    public static void addJsonArray(String firstname, String lastname, String username, String password,String employeeId) throws IOException, ParseException {
        String fileName="./src/test/resources/NewUser.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONObject userObj = new JSONObject();
        JSONArray jsonArray=(JSONArray) obj;
        userObj.put("firstname", firstname);
        userObj.put("lastname",lastname);
        userObj.put("username",username);
        userObj.put("password",password);
        userObj.put("employeeId",employeeId);


        jsonArray.add(userObj);
        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();


    }
    public static JSONObject loadJSONFileArray(String fileLocation, int index) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileLocation));
        JSONArray jsonArray = (JSONArray) obj;

        return (JSONObject) jsonArray.get(index);
    }

}
