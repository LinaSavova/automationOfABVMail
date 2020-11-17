package pages.frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.Browser;

public class Gyuvech {
    private static final By GYUVECH_HEADER = By.cssSelector(".navbar");

    /**
     * Verify Gyuvech header is displayed after logout of www.abv.bg
     * @param messageOnFailure message if Gyuvech header is not displayed after logout
     */
    public static void verifyUserIsLoggedOut(String messageOnFailure) {
        WebElement headerLogOutPage = Browser.driver.findElement(GYUVECH_HEADER);
        Assert.assertTrue(headerLogOutPage.isDisplayed(), messageOnFailure);
    }
}
