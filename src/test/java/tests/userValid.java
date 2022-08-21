package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class userValid extends BaseTest {

    @Test
    public void userValid(){
        WebElement menu = driver.findElement(By.id("menu-toggle"));
        assertTrue(isElementPresent(By.id("menu-toggle")), "Menu button is missing");
        menu.click();
        WebElement login = driver.findElement(By.xpath("//a[@href='profile.php#login']"));
        assertTrue(isElementPresent(By.xpath("//a[@href='profile.php#login']")),
                "Login button is missing");
        login.click();
        assertTrue(driver.getCurrentUrl().contains("#login"),
                "User is not on login page.");
        WebElement username = driver.findElement(By.id("txt-username"));
        assertTrue(isElementPresent(By.id("txt-username")),
                "Username box is missing.");
        username.clear();
        username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.id("txt-password"));
        assertTrue(isElementPresent(By.id("txt-password")),
                "Password box is missing.");
        password.clear();
        password.sendKeys("ThisIsNotAPassword");
        assertTrue(isElementPresent(By.id("btn-login")),
                "Login button is missing.");
        driver.findElement(By.id("btn-login")).click();
        assertTrue(driver.getCurrentUrl().contains("#appointment"), "User could not log in.");



    }
}
