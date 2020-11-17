package core;

import org.openqa.selenium.By;
import utils.Browser;

public class BasePage {

    /**
     * Find an element inside the web page
     * @param locator locator of the element
     */
    protected static void findElement(By locator){
        Browser.driver.findElement(locator);
    }

    /**
     * Method to type parameters into the located element
     * @param locator locator of the element
     * @param whatToType what needs to be typed
     */
    protected static void type(By locator, String whatToType){
        Browser.driver.findElement(locator).sendKeys(whatToType);
    }
    /**
     * Method to click on an element
     * @param locator locator of the element that should be clicked on
     */
    protected static void click(By locator){
        Browser.driver.findElement(locator).click();
    }

    /**
     * Method to clear a field
     * @param locator locator of the element that should be cleared
     */
    protected static void clear(By locator){
        Browser.driver.findElement(locator).clear();
    }

    /**
     * Get the text from element
     * @param locator locator of the element
     * @return the String that should be returned
     */
    protected static String getText(By locator){
        return Browser.driver.findElement(locator).getText();
    }
}
