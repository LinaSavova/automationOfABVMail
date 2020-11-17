package components;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.frontend.Home;
import pages.frontend.Inbox;
import utils.Browser;

import java.util.List;

import static org.testng.Assert.*;

public class ABVPost extends BasePage {
    private static final By ABV_POST = By.id("gwt-uid-2");
    private static final By CONTACTS = By.id("gwt-uid-5");
    private static final By CONTACTS_UPPER = By.id("gwt-uid-9");
    private static final By ABV_INBOX = By.id("gwt-uid-11");
    private static final By ADD_BUTTON = By.cssSelector(".abv-button");
    private static final By EMPTY_CONTACTS_MESSAGE = By.cssSelector(".abv-title");
    private static final By CONTACTS_FIRST_ROW = By.xpath("//tr[@__gwt_row='0']");
    private static final By CONTACTS_ALL_ROWS = By.xpath("//table[@id='inboxTable']//tr[@__gwt_subrow='0']//td[2]");
    private static final By DELETE_UPPER_MENU = By.cssSelector(".abv-fp1:nth-of-type(3)");
    private static final By CONTACTS_COUNTER_SIDE_MENU = By.cssSelector(".foldersCell.foldersSelectedCell > em");

    /**
     * Go to Contacts
     */
    public static void goToContacts() {
        click(ABV_POST);
        click(CONTACTS);
    }

    /**
     * Verify user is into Contacts folder
     * @param messageOnFailure message that appears no row with contacts is loaded
     */
    public static void verifyContactsLoaded(String messageOnFailure) {
//        String actualAddButtonText = Browser.driver.findElement(ADD_BUTTON).getText().trim();
//        assertEquals(actualAddButtonText, expectedAddButtonText, messageOnFailure);
        List<WebElement> contacts = Browser.driver.findElements(CONTACTS_FIRST_ROW);
        WebElement webElement = contacts.get(1);
        assertTrue(webElement.isDisplayed(), messageOnFailure);
    }

    /**
     * Verify Contacts folder is empty
     * @param expectedEmptyFolderMessage
     * @param messageOnFailure
     */
    public static void verifyEmptyContactsMessage(String expectedEmptyFolderMessage, String messageOnFailure) {
        String actualEmptyFolderMessage = Browser.driver.findElement(EMPTY_CONTACTS_MESSAGE).getText().trim();
        assertEquals(actualEmptyFolderMessage, expectedEmptyFolderMessage, messageOnFailure);
    }

    /**
     * Delete a contact and verify the number of contacts is decreased
     * @param contactNumber number of the contact in Inbox to delete
     * @param messageOnFailure message that appears if contacts number is not decreased after deletion
     */
    public static void deleteContact(int contactNumber, String messageOnFailure) {
        List<WebElement> allContacts = Browser.driver.findElements(CONTACTS_ALL_ROWS);
        int sizeContacts = allContacts.size();
        System.out.println("Contacts' size: " + sizeContacts);
        WebElement firstContact = allContacts.get(contactNumber);
        firstContact.click();
        click(DELETE_UPPER_MENU);
        Browser.driver.navigate().refresh();
        int sizeAfterDeletion = Browser.driver.findElements(CONTACTS_ALL_ROWS).size();
        System.out.println("Contacts's size after a contact is deleted: " + sizeAfterDeletion);
        assertFalse(sizeAfterDeletion==sizeContacts, messageOnFailure);
    }

    /**
     * Add anew contact to Contacts and verify thr number of contacts is increased
     * @param emailNumber number of the contact in Inbox to be added to Contacts
     * @param messageOnFailure message that appears if contacts counter is the same after a new contact is added
     */
    public static void addToContacts(int emailNumber, String messageOnFailure) {
        ABVPost.goToContacts();
        String counterBeforeAddedNew = Browser.driver.findElement(CONTACTS_COUNTER_SIDE_MENU).getText().trim();
        System.out.println("Current Contacts counter: " + counterBeforeAddedNew);

        click(CONTACTS_UPPER);
        click(ABV_INBOX);

        List<WebElement> fromInbox = Browser.driver.findElements(Inbox.FROM_SECTION_INBOX);
        WebElement emailToOpen = fromInbox.get(emailNumber);
        emailToOpen.click();
        click(Inbox.ADD_TO_CONTACTS_BUTTON);
        click(Inbox.ADD_BUTTON);

        ABVPost.goToContacts();
        String counterAfterAddedNew = Browser.driver.findElement(CONTACTS_COUNTER_SIDE_MENU).getText().trim();
        System.out.println("Contacts counter after a new one is added: " + counterAfterAddedNew);
        assertFalse(counterAfterAddedNew.equals(counterBeforeAddedNew), messageOnFailure);

    }

    /**
     * The same contact is not added second time in Contacts - good to perform this test case after the one for adding new contact
     * @param emailNumber number of the contact in Inbox to be added to Contacts
     * @param messageOnFailure
     */
    public static void canNotAddTwice(int emailNumber, String messageOnFailure) {
        ABVPost.goToContacts();
        String counterBeforeAddedNew = Browser.driver.findElement(CONTACTS_COUNTER_SIDE_MENU).getText().trim();
        System.out.println("Current Contacts counter: " + counterBeforeAddedNew);

        click(CONTACTS_UPPER);
        click(ABV_INBOX);

        List<WebElement> fromInbox = Browser.driver.findElements(Inbox.FROM_SECTION_INBOX);
        WebElement emailToOpen = fromInbox.get(emailNumber);
        emailToOpen.click();
        click(Inbox.ADD_TO_CONTACTS_BUTTON);
        click(Inbox.ADD_BUTTON);

        ABVPost.goToContacts();
        String counterAfterAddedTheSame = Browser.driver.findElement(CONTACTS_COUNTER_SIDE_MENU).getText().trim();
        System.out.println("Contacts counter after a new one is added: " + counterAfterAddedTheSame);
        assertTrue(counterAfterAddedTheSame.equals(counterBeforeAddedNew), messageOnFailure);
    }
}
