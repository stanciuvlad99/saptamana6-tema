package tests;

import driver.WebdriverConfigs;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseTest {

    protected RemoteWebDriver driver=null;

    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        driver= WebdriverConfigs.getRemoteDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com");

    }
    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        if (driver !=null){
            driver.quit();
        }
    }

    protected boolean isElementPresent(By locator){
        try {
            driver.findElement(locator); {
                return true;
            }
        }catch(NoSuchElementException e){
            return false;
        }
    }
}
