package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class makeAppointment extends BaseTest{

    @Test
    public void makeAppointment(){
        WebElement appointmentButton = driver.findElement(By.id("btn-make-appointment"));
        appointmentButton.click();
        assertTrue(driver.getCurrentUrl().contains("#login"), "User is not on the login page.");

    }
}
