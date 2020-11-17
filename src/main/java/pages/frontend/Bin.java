package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Browser;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;


public class Bin extends BasePage {
    static Actions actions = new Actions(Browser.driver);

    private static final By BIN_SIDE_MENU = By.xpath("//div[@class='abv-fMl5 abv-BrBot']//tr[@__gwt_row='4']");
    private static final By CHECKBOXES_BIN = By.xpath("//div[@class='abv-grayBG']//tr[@__gwt_subrow='0']/td[1]");
    private static final By MOVE_TO_UPPER_MENU = By.id("gwt-uid-51");
    private static final By MOVE_TO_INBOX = By.xpath("//div[@class='menuPopupMiddleCenterInner menuPopupContent']//tr[1]");
    private static final By EMPTY_BIN_FOLDER = By.xpath("//div[@class='popupContent']//td[@class='gwt-MenuItem']");
    private static final By CONFIRM_EMPTY_BIN = By.cssSelector(".cancelButtonWrapper .abv-button:nth-of-type(1)");
    private static final By CONFIRMATION_MESSAGE_BIN_IS_EMPTY = By.cssSelector(".abv-emptyFolder .abv-title");

    /**
     * Move an email from Bin folder to Inbox
     * @param emailNumber number of the email to be moved
     * @param messageOnFailure message that appears if email is not moved back to Inbox
     */
    public static void moveBackToInbox(int emailNumber, String messageOnFailure) {
        int sizeBin = Browser.driver.findElements(CHECKBOXES_BIN).size();
        System.out.println("Emails in Bin: " + sizeBin);
        Browser.driver.findElements(CHECKBOXES_BIN).get(emailNumber).click();
        click(MOVE_TO_UPPER_MENU);
        click(MOVE_TO_INBOX);
        Browser.driver.navigate().refresh();
        int sizeAfterEmailMoved = Browser.driver.findElements(CHECKBOXES_BIN).size();
        System.out.println("Emails in Bin after 1 email is moved to Inbox: " + sizeAfterEmailMoved);
        assertTrue(sizeAfterEmailMoved == sizeBin-1, messageOnFailure);
    }

    /**
     * Delete all emails in Bin folder by one single click
     */
    public static void emptyBinFolder() {
        WebElement binSideMenu = Browser.driver.findElement(BIN_SIDE_MENU);
        actions.contextClick(binSideMenu).perform();
        click(EMPTY_BIN_FOLDER);
        click(CONFIRM_EMPTY_BIN);
    }

    /**
     * Verify Bin folder is actually empty
     * @param expectedMessage expected message that is visualized when Bin folder is empty
     * @param messageOnFailure message to appear if there is no confirmation message that Bin folder is empty
     */
    public static void verifyBinIsEmpty(String expectedMessage, String messageOnFailure) {
        String actualMessage = Browser.driver.findElement(CONFIRMATION_MESSAGE_BIN_IS_EMPTY).getText().trim();
        assertEquals(actualMessage, expectedMessage, messageOnFailure);
    }
}
