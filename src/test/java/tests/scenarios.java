package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class scenarios extends BaseTest{

    @Test
    public void positiveScenarios(){
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
        username.sendKeys("John Doe");
        assertTrue(isElementPresent(By.id("txt-password")),
                "Password box is missing.");
        WebElement password = driver.findElement(By.id("txt-password"));
        password.clear();
        password.sendKeys("ThisIsNotAPassword");
        assertTrue(isElementPresent(By.id("btn-login")),
                "Login button is missing.");
        driver.findElement(By.id("btn-login")).click();
        assertTrue(driver.getCurrentUrl().contains("#appointment"), "User could not log in.");

        Select dropdown = new Select(driver.findElement(By.id("combo_facility")));
        dropdown.selectByIndex(1);

        assertTrue(isElementPresent(By.id("chk_hospotal_readmission")));
        driver.findElement(By.id("chk_hospotal_readmission")).click();

        assertTrue(isElementPresent(By.id("radio_program_none")));
        driver.findElement(By.id("radio_program_none")).click();

        driver.findElement(By.id("txt_visit_date")).click();
        driver.findElement(By.cssSelector("body > div > div.datepicker-days > table > tbody > tr:nth-child(1) > td:nth-child(2)")).click();

        assertTrue(isElementPresent(By.id("txt_comment")),"Text box is missing." );
        WebElement comment = driver.findElement(By.id("txt_comment"));
        comment.clear();
        comment.sendKeys("Hello!");
//        assertEquals(comment.getText().toLowerCase(), "hello!");
        driver.findElement(By.id("txt_comment")).getText();
        System.out.println(driver.findElement(By.id("txt_comment")).getText());
        assertTrue(isElementPresent(By.id("btn-book-appointment")),
                "Appointment button is missing.");
        driver.findElement(By.id("btn-book-appointment")).click();

        assertTrue(driver.getCurrentUrl().contains("summary"),
                "The appointment could not be made");

    }

    @Test
    public void negativeScenario(){
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
        username.sendKeys("John Doe");
        assertTrue(isElementPresent(By.id("txt-password")),
                "Password box is missing.");
        WebElement password = driver.findElement(By.id("txt-password"));
        password.clear();
        password.sendKeys("ThisIsNotAPassword");
        assertTrue(isElementPresent(By.id("btn-login")),
                "Login button is missing.");
        driver.findElement(By.id("btn-login")).click();
        assertTrue(driver.getCurrentUrl().contains("#appointment"), "User could not log in.");


        Select dropdown = new Select(driver.findElement(By.id("combo_facility")));
        dropdown.selectByIndex(1);

        assertTrue(isElementPresent(By.id("chk_hospotal_readmission")));
        driver.findElement(By.id("chk_hospotal_readmission")).click();

        assertTrue(isElementPresent(By.id("radio_program_none")));
        driver.findElement(By.id("radio_program_none")).click();

        driver.findElement(By.id("txt_visit_date")).click();
        driver.findElement(By.cssSelector("body > div > div.datepicker-days > table > tbody > tr:nth-child(1) > td:nth-child(2)")).click();

        assertTrue(isElementPresent(By.id("txt_comment")),"Text box is missing." );
        WebElement comment = driver.findElement(By.id("txt_comment"));
        comment.clear();
        comment.sendKeys("Hello!");
//        assertEquals(comment.getText().toLowerCase(), "hello!");

        assertTrue(isElementPresent(By.id("btn-book-appointmentt")),
                "Appointment button is missing.");
        driver.findElement(By.id("btn-book-appointment")).click();
        assertTrue(driver.getCurrentUrl().contains("summary"),
                "The appointment could not be made");

    }
}
