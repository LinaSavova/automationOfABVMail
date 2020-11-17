package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Browser;
import static org.testng.Assert.*;

public class Home extends BasePage {
    private static final By USER_EMAIL_DISPLAYED = By.id("gwt-uid-406");
    private static final By LOGOUT_BUTTON = By.id("gwt-uid-409");
    private static final By SEARCH_RESULTS_MESSAGE = By.cssSelector(".abv-hmgs .gwt-HTML");
    private static final By SEARCH_RESULTS_NO_ITEMS_FOUND = By.cssSelector(".abv-emptyFolder .abv-title");
    private static final By INBOX_SIDE_MENU = By.xpath("//div[@class='abv-fMl5 abv-BrBot']//tr[@__gwt_row='0']");
    private static final By SPAM_SIDE_MENU = By.xpath("//div[@class='abv-fMl5 abv-BrBot']//tr[@__gwt_row='3']");
    private static final By HISTORY = By.cssSelector(".p .abv-green");
    private static final By HISTORY_TITLE = By.cssSelector(".abv-title");
    private static final By ENTER_CHAT_SIDE_MENU = By.cssSelector(".abv-imRosetMenu.roster-panel .gwt-HTML");
    private static final By SEND_CHAT_INVITATION = By.cssSelector(".cancelButtonWrapper .abv-button:nth-of-type(1)");
    private static final By SEARCH_CONTACTS_TEXTBOX = By.cssSelector(".abv-chatBlock > input");
    private static final By SEARCH_CONTACTS_ICON = By.id("searchlensChat");
    private static final By CONFIRMATION_POPUP = By.cssSelector(".line-Bottom");
    private static final By CONFIRM_BUTTON = By.cssSelector(".cancelButtonWrapper .abv-button:nth-of-type(1)");
    private static final By BIN_SIDE_MENU = By.xpath("//div[@class='abv-fMl5 abv-BrBot']//tr[@__gwt_row='4']");
    private static final By USER_EMAIL_UPPER_MENU = By.id("gwt-uid-406");
    private static final By PROFILE_BUTTON = By.id("gwt-uid-408");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By SUBMIT_PROFILE_BUTTON = By.xpath("//input[@type='submit']");

    /**
     * Verify user is successfully logged in with right credentials by seeing
     * its email in the upper right corner in Home page
     */
    public static void verifyLogIn(String messageOnFailure) {
        WebElement emailDisplayed = Browser.driver.findElement(USER_EMAIL_DISPLAYED);
        assertTrue(emailDisplayed.isDisplayed(), messageOnFailure);
    }

    /**
     * Log out from your account
     */
    public static void logOut() {
        click(USER_EMAIL_DISPLAYED);
        click(LOGOUT_BUTTON);
    }

    /**
     * Verify a text is displayed for searched and found emails
     * @param expectedMessageSearchResults message that is displayed when items are found
     * @param messageOnFailure message to indicate that the text for searched and found items is not displayed
     */
    public static void verifyEmailsAreSearched(String expectedMessageSearchResults, String messageOnFailure) {
        String actualMessageSearchResults = Browser.driver.findElement(SEARCH_RESULTS_MESSAGE).getText();
        assertTrue(actualMessageSearchResults.contains(expectedMessageSearchResults), messageOnFailure);
        WebElement messageNoEmailsFound = Browser.driver.findElement(SEARCH_RESULTS_NO_ITEMS_FOUND);
        assertFalse(messageNoEmailsFound.isDisplayed());
    }

    /**
     * Verify that a message appears if no matching the criteria emails are found
     * @param expectedMessageNotFoundItems message that appears for not found items
     * @param messageOnFailure message to indicate that the expected warning is not displayed
     */
    public static void verifyNoEmailsFound(String expectedMessageNotFoundItems, String messageOnFailure) {
        String actualMessageNotFoundItems = getText(SEARCH_RESULTS_NO_ITEMS_FOUND).trim();
        assertEquals(actualMessageNotFoundItems, expectedMessageNotFoundItems, messageOnFailure);
    }

    /**
     * Go to Inbox
     */
    public static void goToInbox() {
        click(INBOX_SIDE_MENU);
    }

    /**
     * Go to Spam folder
     */
    public static void goToSpam() {
        click(SPAM_SIDE_MENU);
    }

    /**
     * Go to History of entrance
     */
    public static void checkHistoryOfEntrance(){
        click(HISTORY);
    }

    /**
     * Verify user goes to history section
     * @param expectedTitle the title of the section
     * @param messageOnFailure message if the title that appears is not the expected one
     */
    public static void verifyHistoryIsLoaded(String expectedTitle, String messageOnFailure) {
        String actualTitle = Browser.driver.findElement(HISTORY_TITLE).getText();
        assertEquals(actualTitle, expectedTitle, messageOnFailure);
    }

    /**
     * Search for contact to chat with
     */
    public static void searchForContact() {
        WebElement firstEntryOption = Browser.driver.findElement(ENTER_CHAT_SIDE_MENU);
        if(firstEntryOption.isDisplayed()){
            click(ENTER_CHAT_SIDE_MENU);
            click(SEND_CHAT_INVITATION);
        }
        type(SEARCH_CONTACTS_TEXTBOX, "smelichkata@abv.bg");
        click(SEARCH_CONTACTS_ICON);
        click(CONFIRM_BUTTON);
    }

    /**
     * Go to Bin folder
     */
    public static void goToBin() {
        click(BIN_SIDE_MENU);
    }

    /**
     * Go to Profile
     */
    public static void goToProfile() {
        click(USER_EMAIL_UPPER_MENU);
        click(PROFILE_BUTTON);
        type(PASSWORD_FIELD, "Barny123456");
        click(SUBMIT_PROFILE_BUTTON);
    }
}
