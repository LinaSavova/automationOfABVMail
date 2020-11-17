package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Browser {
    public static WebDriver driver;

    /**
     * Method to set up a Chrome browser
     */
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/Lina/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /**
     * Method to kill the browser
     */
    public static void tearDown() {
        driver.quit();
    }
}
