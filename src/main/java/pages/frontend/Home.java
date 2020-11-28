package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    private static final By CREATE_FOLDER_BUTTON = By.cssSelector(".abv-addNewFolder");
    private static final By NAME_FOLDER_FIELD = By.cssSelector(".abv-textBoxAdNewFolder");
    private static final By SIDE_MENU_COLLECTION = By.xpath("//div[@class='abv-fMl5 abv-BrBot']//tr");
    private static final By LAST_FOLDER = By.xpath("//div[@class='abv-fMl5 abv-BrBot']//tr[7]");
    private static final By DELETE_FOLDER_OPTION = By.xpath("//div[@class='popupContent']//tr[3]/td");
    private static final By CONFIRM_DELETE_FOLDER = By.ByLinkText.cssSelector(".cancelButtonWrapper .abv-button:nth-of-type(1)");
    private static final By RENAME_FOLDER = By.xpath("//div[@class='popupContent']//tr[1]/td");
    private static final By RENAME_INPUT = By.cssSelector(".GG3HBNKBJX input");
    private static final By STATUS_MENU = By.cssSelector(".chatStatusWrapper .gwt-MenuItem");
    private static final By ONLINE_STATUS = By.xpath("//div[@class='menuPopupMiddleCenterInner menuPopupContent']//tr[1]/td");
    private static final By STATUS_DISPLAY = By.cssSelector(".abv-chatBlock");
    private static final By OFFLINE_STATUS = By.xpath("//div[@class='menuPopupMiddleCenterInner menuPopupContent']//tr[2]/td");
    private static final By INVISIBLE_STATUS = By.xpath("//div[@class='menuPopupMiddleCenterInner menuPopupContent']//tr[3]/td");
    private static final By DRAFTS_SIDE_MENU = By.xpath("//div[@class='abv-fMl5 abv-BrBot']//tr[@__gwt_row='2']");



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
    public static void goToProfile(String password) {
        click(USER_EMAIL_UPPER_MENU);
        click(PROFILE_BUTTON);
        type(PASSWORD_FIELD, password);
        click(SUBMIT_PROFILE_BUTTON);
    }

    /**
     * Create a new folder in the side menu and verify it appears there
     */
    public static void addNewFolder() {
        int numberOfFolders = Browser.driver.findElements(SIDE_MENU_COLLECTION).size();
        System.out.println("The number of folders is: " + numberOfFolders);
        click(CREATE_FOLDER_BUTTON);
        type(NAME_FOLDER_FIELD, "Testing");
        Browser.driver.findElement(NAME_FOLDER_FIELD).sendKeys(Keys.RETURN);
        Browser.driver.navigate().refresh();
        int numberOfFoldersAfterCreation = Browser.driver.findElements(SIDE_MENU_COLLECTION).size();
        System.out.println("The number of folders after a new one is added: " + numberOfFoldersAfterCreation);
        assertFalse(numberOfFoldersAfterCreation==numberOfFolders, "Folders count not increased");

    }

    /**
     * Rename the last folder and verify it is renamed
     */
    public static void renameFolder() {
        String lastFolderName = Browser.driver.findElement(LAST_FOLDER).getText().trim();
        System.out.println("The current name of the last folder is: " + lastFolderName);
        Actions action = new Actions(Browser.driver);
        WebElement elementLocator = Browser.driver.findElement(LAST_FOLDER);
        action.contextClick(elementLocator).perform();
        click(RENAME_FOLDER);
        type(RENAME_INPUT, "NewName");
        Browser.driver.findElement(RENAME_INPUT).sendKeys(Keys.RETURN);
        Browser.driver.navigate().refresh();
        String lastFolderRenamed = Browser.driver.findElement(LAST_FOLDER).getText().trim();
        System.out.println("The new name of the last folder is: " + lastFolderRenamed);
        assertFalse(lastFolderRenamed.equals(lastFolderName), "Folder is not renamed");
    }

    /**
     * Remove an existing folder and verify it disappears
     */
    public static void removeFolder() {
        int currNumberOfFolders = Browser.driver.findElements(SIDE_MENU_COLLECTION).size();
        System.out.println("Number of folders: " + currNumberOfFolders);
        Actions action = new Actions(Browser.driver);
        WebElement elementLocator = Browser.driver.findElement(LAST_FOLDER);
        action.contextClick(elementLocator).perform();
        click(DELETE_FOLDER_OPTION);
        click(CONFIRM_DELETE_FOLDER);
        Browser.driver.navigate().refresh();
        int numberOfFoldersAfterDeletion = Browser.driver.findElements(SIDE_MENU_COLLECTION).size();
        System.out.println("The number of folders after one is deleted: " + numberOfFoldersAfterDeletion);
        assertFalse(numberOfFoldersAfterDeletion==currNumberOfFolders, "Folders count not decreasing after deletion of folder");
    }

    /**
     * Select user's status to be online
     */
    public static void showOnline() {
        click(STATUS_MENU);
        click(ONLINE_STATUS);
    }

    /**
     * Verify online status is displayed
     * @param expectedMessage expected message that user is online
     * @param messageOnFailure a message to appear if user is not showing as online
     */
    public static void verifyStatusAsOnline(String expectedMessage, String messageOnFailure) {
        String actualMessage = Browser.driver.findElement(STATUS_DISPLAY).getText().trim();
        assertEquals(actualMessage, expectedMessage, messageOnFailure);
    }

    /**
     * Select user's status to be offline
     */
    public static void showOffline() {
        click(STATUS_MENU);
        click(OFFLINE_STATUS);
    }

    /**
     * Verify offline status is displayed
     * @param expectedMessage expected message that user is offline
     * @param messageOnFailure a message to appear if user is not showing as offline
     */
    public static void verifyStatusAsOffline(String expectedMessage, String messageOnFailure) {
        String actualMessage = Browser.driver.findElement(STATUS_DISPLAY).getText().trim();
        assertEquals(actualMessage, expectedMessage, messageOnFailure);
    }

    /**
     * Select user's status to be invisible
     */
    public static void showInvisible() {
        click(STATUS_MENU);
        click(INVISIBLE_STATUS);
    }

    /** Verify invisible status is displayed
     *
     * @param expectedMessage expected message that user is invisible
     * @param messageOnFailure a message to appear if user is not showing as invisible
     */
    public static void verifyStatusAsInvisible(String expectedMessage, String messageOnFailure) {
        String actualMessage = Browser.driver.findElement(STATUS_DISPLAY).getText().trim();
        assertEquals(actualMessage, expectedMessage, messageOnFailure);
    }

    /**
     * Go to Drafts folder in the side menu
     */
    public static void goToDrafts() {
        click(DRAFTS_SIDE_MENU);
    }
}
