package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Browser;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class Profile extends BasePage {
    private static final By BACK_TO_ABV = By.cssSelector(".abv-menu a:nth-of-type(2)");
    private static final By EDIT_PROFILE_BUTTON = By.cssSelector(".fr .abv-button");
    private static final By FIRST_NAME_FIELD = By.name("firstName");
    private static final By LAST_NAME_FIELD = By.name("lastName");
    private static final By ABOUT_ME_SECTION = By.name("aboutMe");
    private static final By SAVE_BUTTON = By.cssSelector(".abv-row.x.abv-submitRow input");
    private static final By CONFIRMATION_EDIT_SUCCESSFUL = By.cssSelector(".abv-messageinfo");


    /**
     * Verify user is actually logged in to his profile
     * @param messageOnFailure message to appear if no Back to ABV option is displayed
     */
    public static void verifyUserIsToProfile(String messageOnFailure) {
        WebElement backButton = Browser.driver.findElement(BACK_TO_ABV);
        assertTrue(backButton.isDisplayed(), messageOnFailure);
    }

    /**
     * Edit a profile
     */
    public static void editProfile() {
        click(EDIT_PROFILE_BUTTON);
        clear(FIRST_NAME_FIELD);
        type(FIRST_NAME_FIELD, "Barny1");
        clear(LAST_NAME_FIELD);
        type(LAST_NAME_FIELD, "Rubble");
        clear(ABOUT_ME_SECTION);
        type(ABOUT_ME_SECTION, "The Flintstones");
        click(SAVE_BUTTON);
    }


    /**
     * Verify profile is successfully edited
     * @param expectedMessage confirmation message that appears after profile is edited
     * @param messageOnFailure message to appear if no confirmation message is displayed
     */
    public static void verifyProfileIsEdited(String expectedMessage, String messageOnFailure) {
        String actualMessage = Browser.driver.findElement(CONFIRMATION_EDIT_SUCCESSFUL).getText().trim();
        assertTrue(actualMessage.contains(expectedMessage), messageOnFailure);
    }
}
