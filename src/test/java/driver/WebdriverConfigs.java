package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverConfigs {

    public static ChromeDriver getChomeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
