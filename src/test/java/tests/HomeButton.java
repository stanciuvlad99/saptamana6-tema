package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class HomeButton extends BaseTest{

    @Test
    public void fromLoginToHomePage(){
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.xpath("//a[@href='profile.php#login']")).click();
        assertTrue(driver.getCurrentUrl().contains("#login"),
                "User is not located on the login page.");
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.cssSelector("#sidebar-wrapper > ul > li:nth-child(3) > a")).click();
        assertTrue(driver.getCurrentUrl().contains("herokuapp.com"),
                "User is not located on home page.");

    }

    @Test
    public void fromMakeAppointmentToHomePage(){
        driver.findElement(By.id("btn-make-appointment")).click();
        assertTrue(driver.getCurrentUrl().contains("#login"),
                "User is not located on the login page.");
        WebElement username = driver.findElement(By.id("txt-username"));
        username.click();
        username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.id("txt-password"));
        password.clear();
        password.sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        assertTrue(driver.getCurrentUrl().contains("#appointment"),
                "User is not located on Appointment page");
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[2]/a")).click();
        assertTrue(driver.getCurrentUrl().contains("herokuapp.com"),
                "User is not located on home page");

    }

    @Test
    public void fromHistorryToHome(){
        driver.findElement(By.id("btn-make-appointment")).click();
        assertTrue(driver.getCurrentUrl().contains("#login"),
                "User is not located on the login page.");
        WebElement username = driver.findElement(By.id("txt-username"));
        username.click();
        username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.id("txt-password"));
        password.clear();
        password.sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        assertTrue(driver.getCurrentUrl().contains("#appointment"),
                "User could not log in");
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.xpath("//a[@href='history.php#history']")).click();
        assertTrue(driver.getCurrentUrl().contains("#history"),
                "User is not located on History page");
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[2]/a")).click();
        assertTrue(driver.getCurrentUrl().contains("herokuapp.com"),
                "User is not located on home page");
    }


    @Test
    public void fromProfileToHomePage(){
        driver.findElement(By.id("btn-make-appointment")).click();
        assertTrue(driver.getCurrentUrl().contains("#login"),
                "User is not located on the login page.");
        WebElement username = driver.findElement(By.id("txt-username"));
        username.click();
        username.sendKeys("John Doe");
        WebElement password = driver.findElement(By.id("txt-password"));
        password.clear();
        password.sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();
        assertTrue(driver.getCurrentUrl().contains("#appointment"),
                "User could not log in");
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.xpath("//a[@href='profile.php#profile']")).click();
        assertTrue(driver.getCurrentUrl().contains("profile"),
                "User is not located on profile page.");
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[2]/a")).click();
        assertTrue(driver.getCurrentUrl().contains("herokuapp.com"),
                "User is not located on home page");
    }
}
