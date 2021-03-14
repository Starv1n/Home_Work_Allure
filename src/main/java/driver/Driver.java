package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver driver;

    private static WebDriver startDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver!=null){
            return driver;
        }
        return startDriver();
    }

    public static void closeDriver(){
        driver.close();
    }
}
