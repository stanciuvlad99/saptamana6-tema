package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class userInvalid extends BaseTest{
    @Test
    public void userInalid(){
        assertTrue(isElementPresent(By.id("menu-toggle")), "Menu button is missing");
        WebElement menu = driver.findElement(By.id("menu-toggle"));
        menu.click();
        assertTrue(isElementPresent(By.xpath("//a[@href='profile.php#login']")),
                "Login button is missing");
        WebElement login = driver.findElement(By.xpath("//a[@href='profile.php#login']"));
        login.click();
        assertTrue(driver.getCurrentUrl().contains("#login"),
                "User is not on login page.");
        assertTrue(isElementPresent(By.id("txt-username")),
                "Username box is missing.");
        WebElement username = driver.findElement(By.id("txt-username"));
        username.clear();
        username.sendKeys("John Doee");
        assertTrue(isElementPresent(By.id("txt-password")),
                "Password box is missing.");
        WebElement password = driver.findElement(By.id("txt-password"));
        password.clear();
        password.sendKeys("ThisIsNotAPasswordd");
        assertTrue(isElementPresent(By.id("btn-login")),
                "Login button is missing.");
        driver.findElement(By.id("btn-login")).click();
        assertTrue(driver.getCurrentUrl().contains("#appointment"), "User could not log in.");



    }
}
