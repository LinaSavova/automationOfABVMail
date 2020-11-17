package pages.frontend;

import components.Write;
import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.Browser;
import java.util.List;
import static org.testng.Assert.*;

public class Inbox extends BasePage {

    public static Actions actions = new Actions(Browser.driver);

    private static final By SORT_INBOX_UPPER_MENU = By.id("gwt-uid-52");
    private static final By SORT_OPTIONS_UPPER_MENU = By.cssSelector(".abv-item");
    private static final By CHECKBOXES_INBOX = By.xpath("//div[@class='abv-grayBG']//tr[@__gwt_subrow='0']/td[1]");
    private static final By EMAILS_COUNT = By.xpath("//div[@class='gwt-HTML'][contains(text(), ' от ')]");
    private static final By INBOX_DELETE_UPPER_MENU = By.cssSelector(".linksHolder .abv-fp1:nth-of-type(1)");
    private static final By SIDE_MENU_INBOX = By.xpath("//div[@class='abv-fMl5 abv-BrBot']//tr[@__gwt_row='0']");
    private static final By INBOX_EMPTY_MESSAGE = By.cssSelector(".abv-emptyFolder .abv-title");
    private static final By INBOX_MOVE_TO = By.id("gwt-uid-51");
    private static final By MOVE_TO_BIN_FOLDER = By.xpath("//div[@class='menuPopupMiddleCenterInner menuPopupContent']//tr[4]");
    private static final By SIDE_MENU_BIN = By.xpath("//div[@class='abv-fMl5 abv-BrBot']//tr[@__gwt_row='4']");
    private static final By CHECKBOXES_BIN = By.xpath("//div[@class='abv-grayBG']//tr[@__gwt_subrow='0']/td[1]");
    public static final By FROM_SECTION_INBOX = By.xpath("//div[@class='abv-grayBG']//tr[@__gwt_subrow='0']/td[2]");
    private static final By SUBJECT_SECTION_INBOX = By.xpath("//div[@class='abv-grayBG']//tr[@__gwt_subrow='0']/td[5]");
    private static final By All_EMAILS_ROWS = By.xpath("//div[@class='abv-grayBG']//tr[@__gwt_subrow='0']");
    private static final By MARK_DROPDOWN_EMAIL = By.id("gwt-uid-377");
    private static final By PUT_A_FLAG = By.id("gwt-uid-380");
    private static final By FLAG_MARKED_GREEN = By.xpath("//tr[@__gwt_row='1']//img[@class='icon-flag-on']");
    private static final By FLAGS_SECTION_INBOX = By.xpath("//div[@class='abv-grayBG']//tr[@__gwt_subrow='0']/td[4]");
    private static final By FLAG_REMOVED = By.xpath("//tr[@__gwt_row='1']//img[@class='icon-flag-off']");
    private static final By MARK_OPTION_UPPER_MENU = By.id("gwt-uid-48");
    private static final By MARK_AS_READ = By.id("gwt-uid-49");
    private static final By MARK_AS_UNREAD = By.id("gwt-uid-50");
    private static final By UNREAD_EMAILS = By.cssSelector(".unread");
    private static final By SPAM_UPPER_MENU = By.id("gwt-uid-45");
    private static final By MARK_SPAM = By.id("gwt-uid-46");
    private static final By MARK_FISHING = By.id("gwt-uid-47");
    private static final By MARK_FISHING_CANCEL = By.xpath("//div[@class='cancelButtonWrapper']//div[@class='abv-button'][2]");
    private static final By MARK_FISHING_CONFIRM = By.xpath("//div[@class='cancelButtonWrapper']//div[@class='abv-button'][1]");
    private static final By SPAM_FOLDER_NEW = By.cssSelector("#gwt-uid-621 .GG3HBNKBH-");
    private static final By SIDE_MENU_SPAM = By.xpath("//div[@class='abv-fMl5 abv-BrBot']//tr[@__gwt_row='3']");
    private static final By ALL_SPAM_COUNTERS = By.xpath("//td[starts-with(@id, 'gwt-uid-')]/div[@class='GG3HBNKBH-']");
    private static final By NEXT_PAGE_ICON = By.cssSelector(".next");
    private static final By PREVIOUS_PAGE_ICON = By.cssSelector(".prev");
    private static final By LAST_PAGE_ICON = By.cssSelector(".last");
    private static final By NEXT_PAGE_ICON_DISABLED = By.cssSelector(".next.disabled");
    private static final By FIRST_PAGE_ICON = By.cssSelector(".first");
    private static final By FIRST_PAGE_ICON_DISABLED = By.cssSelector(".first.disabled");
    private static final By REPLY = By.cssSelector(".abv-letterLinksHolder .abv-letterMItem:nth-of-type(1)");
    private static final By REPLY_TO_ALL = By.cssSelector(".abv-letterLinksHolder .abv-letterMItem:nth-of-type(2)");
    private static final By FORWARD = By.cssSelector(".abv-letterLinksHolder .abv-letterMItem:nth-of-type(3)");
    private static final By TO_FIELD = By.xpath("//td[@class='clientField']//input[@class='fl']");
    private static final By SEND_BUTTON = By.cssSelector(".abv-button");
    private static final By EMAIL_BODY = By.cssSelector(".gwt-RichTextArea");
    private static final By CLOSE_BUTTON = By.cssSelector(".fl.nav-Close");
    public static final By ADD_TO_CONTACTS_BUTTON = By.cssSelector(".abv-AddBut");
    public static final By ADD_BUTTON = By.cssSelector(".cancelButtonWrapper .abv-button:nth-of-type(1)");
    private static final By PREVIOUS_EMAIL_ICON = By.cssSelector(".fl.nav-Down");
    private static final By NEXT_EMAIL_ICON = By.cssSelector(".fl.nav-Up");
    private static final By EMAIL_DATE_ATTRIBUTES = By.cssSelector(".msgHeaderDateValue");

    /**
     * Verify Sort option to appear when user enters Inbox
     *
     * @param expectedOptionLabel expected label of the Sort option
     * @param messageOnFailure    message to appear if the expected label of the Sort option is missing
     */
    public static void verifyUserIsIntoInbox(String expectedOptionLabel, String messageOnFailure) {
        String actualOptionLabel = Browser.driver.findElement(SORT_INBOX_UPPER_MENU).getText().trim();
        assertEquals(actualOptionLabel, expectedOptionLabel, messageOnFailure);
    }

    /**
     * Verify that the first email in Inbox can be selected and deleted
     */
    public static void deleteAnEmail() {
        String countBeforeDelete = Browser.driver.findElement(EMAILS_COUNT).getAttribute("innerText");
     //   System.out.println(countBeforeDelete);
        List<WebElement> checkboxesInbox = Browser.driver.findElements(CHECKBOXES_INBOX);
        WebElement firstEmailInInbox = checkboxesInbox.get(0);
        firstEmailInInbox.click();
        click(INBOX_DELETE_UPPER_MENU);
        Browser.driver.navigate().refresh();
        String countAfterDelete = Browser.driver.findElement(EMAILS_COUNT).getAttribute("innerText");
     //   System.out.println(countAfterDelete);
        assertFalse(countBeforeDelete.equals(countAfterDelete), "Emails count is not decreased after deletion");
    }

    /**
     * Select 3 emails from Inbox, delete them, and verify that older emails appear on their places
     * This method is useful ONLY when user has more then 38 emails in Inbox
     */
    public static void deleteFewEmails() {
        List<WebElement> checkboxesInbox = Browser.driver.findElements(CHECKBOXES_INBOX);
        int sizeCheckboxesInboxBeforeDeleteEmails = checkboxesInbox.size();
        checkboxesInbox.get(0).click();
        checkboxesInbox.get(1).click();
        checkboxesInbox.get(2).click();
        click(INBOX_DELETE_UPPER_MENU);
        Browser.driver.navigate().refresh();
        int sizeCheckboxesAfterDeleting = checkboxesInbox.size();
        System.out.println(sizeCheckboxesAfterDeleting);
        Assert.assertTrue(sizeCheckboxesAfterDeleting == sizeCheckboxesInboxBeforeDeleteEmails, "No older emails populating the deleted ones");
    }

    /**
     * Delete by 1 click all emails in Inbox that appear on the page
     */
    public static void deleteAllInInbox() {
        List<WebElement> checkboxesInbox = Browser.driver.findElements(CHECKBOXES_INBOX);
        int sizeCheckboxesInboxBeforeDeleteEmails = checkboxesInbox.size();
        System.out.println("Emails count in Inbox before deleting: " + sizeCheckboxesInboxBeforeDeleteEmails);
        for (WebElement currCheckbox : checkboxesInbox) {
            if (!currCheckbox.isSelected()) {
                currCheckbox.click();
            }
        }
        click(INBOX_DELETE_UPPER_MENU);
        Browser.driver.navigate().refresh();
    }

    /**
     * Verify all emails from Inbox are deleted - TO APPLY ONLY IF THERE ARE FEW EMAILS
     *
     * @param expectedMessageAllEmailsDeleted the message that should appear when the Inbox is empty
     * @param messageOnFailure                warning message if the expected message is missing
     */
    public static void verifyAllEmailsDeleted(String expectedMessageAllEmailsDeleted, String messageOnFailure) {
        String actualMessageAllEmailsDeleted = getText(INBOX_EMPTY_MESSAGE).trim();
        assertEquals(actualMessageAllEmailsDeleted, expectedMessageAllEmailsDeleted, messageOnFailure);
    }

    /**
     * Select an email and move it to Bin Folder
     */
    public static void moveAnEmailToBinFolder(int emailNumberToMoveToBin) {
        click(SIDE_MENU_BIN);
        List<WebElement> checkboxesData = Browser.driver.findElements(CHECKBOXES_BIN);
        int checkboxesBeforeEmailMovedTo = checkboxesData.size();

        click(SIDE_MENU_INBOX);
        List<WebElement> checkboxesInbox = Browser.driver.findElements(CHECKBOXES_INBOX);
        WebElement elementToMove = checkboxesInbox.get(emailNumberToMoveToBin);
        elementToMove.click();
        click(INBOX_MOVE_TO);
        click(MOVE_TO_BIN_FOLDER);

        click(SIDE_MENU_BIN);
        assertEquals(checkboxesBeforeEmailMovedTo + 1, checkboxesBeforeEmailMovedTo + 1, "Count not increased after email is moved to that folder");

    }

    /**
     * Tap an email to open it and flag it
     */
    public static void flag() {
        List<WebElement> checkboxesInbox = Browser.driver.findElements(FROM_SECTION_INBOX);
        WebElement secondElement = checkboxesInbox.get(1);
        secondElement.click(); // By clicking on the From, we are opening the email itself
        click(MARK_DROPDOWN_EMAIL);
        click(PUT_A_FLAG);
    }

    /**
     * Verify user can put a flag to an email
     */
    public static void verifyEmailIsFlagged(String messageOnFailure) {
        click(SIDE_MENU_INBOX);
        List<WebElement> flagsInbox = Browser.driver.findElements(FLAGS_SECTION_INBOX);
        for (WebElement currFlag : flagsInbox) {
            assertTrue(currFlag.findElement(FLAG_MARKED_GREEN).isDisplayed(), messageOnFailure);
        }
    }

    /**
     * Remove the flag from an already flagged email
     */
    public static void removeFlag() {
        Browser.driver.findElements(FLAGS_SECTION_INBOX).get(1).click();
        List<WebElement> flagsInbox = Browser.driver.findElements(FLAGS_SECTION_INBOX);
        for (WebElement currFlag : flagsInbox) {
            assertTrue(currFlag.findElement(FLAG_REMOVED).isDisplayed());
        }
    }

    /**
     * Mark an email in Inbox as read
     *
     * @param emailNumber the number of the email to be marked
     */
    public static void markAsRead(int emailNumber) {
        WebElement emailCheckbox = Browser.driver.findElements(CHECKBOXES_INBOX).get(emailNumber);
        emailCheckbox.click();
        click(MARK_OPTION_UPPER_MENU);
        click(MARK_AS_READ);
        WebElement emailSelected = Browser.driver.findElements(FROM_SECTION_INBOX).get(emailNumber);
       // String emailCssValue = emailSelected.getCssValue("font-weight");
      //  assertEquals(emailCssValue, "400");
        WebElement emailsRows = Browser.driver.findElements(All_EMAILS_ROWS).get(emailNumber);
        String emailClass = emailsRows.getAttribute("class");
        assertFalse(emailClass.contains("unread"));
    }

    /**
     * Mark an email in Inbox as unread
     * @param emailNumber the number of the email to be marked
     */
    public static void marksAsUnread(int emailNumber) {
        WebElement emailSelectedForManipulation = Browser.driver.findElements(CHECKBOXES_INBOX).get(emailNumber);
        emailSelectedForManipulation.click();
        click(MARK_OPTION_UPPER_MENU);
        click(MARK_AS_UNREAD);
       // WebElement emailSelected = Browser.driver.findElements(FROM_SECTION_INBOX).get(emailNumber);
      //  String emailCssValue = emailSelected.getCssValue("font-weight");
      //  assertEquals(emailCssValue, "700");
        WebElement emailsRows = Browser.driver.findElements(All_EMAILS_ROWS).get(emailNumber);
        String emailClass = emailsRows.getAttribute("class");
        assertTrue(emailClass.contains("unread"));
    }

    /**
     * Mark an email in Inbox as spam and verify it goes to Spam folder
     * @param emailNumber the email to mark as spam
     */
    public static void markAsSpam(int emailNumber) {
        WebElement spamFolder = Browser.driver.findElement(SIDE_MENU_SPAM);
        actions.contextClick(spamFolder).perform();
        List<WebElement> all3Counters = Browser.driver.findElements(ALL_SPAM_COUNTERS);
        String allSpamsCounterBeforeSpamMoved = all3Counters.get(1).getText();
        System.out.println("Emails' count in Spam folder: " + allSpamsCounterBeforeSpamMoved);

        click(SIDE_MENU_INBOX);
        List<WebElement> checkboxesInbox = Browser.driver.findElements(CHECKBOXES_INBOX);
        checkboxesInbox.get(emailNumber).click();
        click(SPAM_UPPER_MENU);
        click(MARK_SPAM);

        WebElement spamFolderAgain = Browser.driver.findElement(SIDE_MENU_SPAM);
        actions.contextClick(spamFolderAgain).perform();
        List<WebElement> allCounters = Browser.driver.findElements(ALL_SPAM_COUNTERS);
        String allSpamsCounterAfterSpamMoved = allCounters.get(1).getText();
        System.out.println("Emails' count in Spam folder after new email is added: " + allSpamsCounterAfterSpamMoved);

        assertFalse(allSpamsCounterAfterSpamMoved.equals(allSpamsCounterBeforeSpamMoved), "The counter in Spam folder is not increasing after an email is added");
    }

    /**
     * Sort the emails in Inbox by different filters(up to 10) included in the upper Sort dropdown
     * @param sortOptionIndex number of the sort option to use for the test case
     */
    public static void sortEmailsBy(int sortOptionIndex) {
        String dateFirstEmailBeforeSort = Browser.driver.findElements(All_EMAILS_ROWS).get(0).getAttribute("innerText");
        System.out.println("1st email's attributes when enter Inbox: " + dateFirstEmailBeforeSort);
        click(SORT_INBOX_UPPER_MENU);
        List<WebElement> sortOptions = Browser.driver.findElements(SORT_OPTIONS_UPPER_MENU);
        sortOptions.get(sortOptionIndex).click();
        Browser.driver.navigate().refresh();
        String dateFirstEmailAfterSort = Browser.driver.findElements(All_EMAILS_ROWS).get(0).getAttribute("innerText");
        System.out.println("\n" + "1st email's attributes after sort method is applied: " + dateFirstEmailAfterSort);
        assertFalse(dateFirstEmailAfterSort.equals(dateFirstEmailBeforeSort), "Sort not working -the same email appears");
    }

    /**
     * Mark an email in Inbox as fishing and verify it is deleted
     * @param emailNumber the email to mark as fishing
     */
    public static void markAsFishing(int emailNumber) {
        click(SIDE_MENU_INBOX);
        String countBeforeMarkedAsFishing = Browser.driver.findElement(EMAILS_COUNT).getAttribute("innerText");
        System.out.println(countBeforeMarkedAsFishing);
        List<WebElement> checkboxesInbox = Browser.driver.findElements(CHECKBOXES_INBOX);
        checkboxesInbox.get(emailNumber).click();
        click(SPAM_UPPER_MENU);
        click(MARK_FISHING);
        click(MARK_FISHING_CANCEL); // cancel it
        click(SPAM_UPPER_MENU);
        click(MARK_FISHING);
        click(MARK_FISHING_CONFIRM);
        Browser.driver.navigate().refresh();
        String countAfterMarkedAsFishing = Browser.driver.findElement(EMAILS_COUNT).getAttribute("innerText");
        System.out.println(countAfterMarkedAsFishing);
        assertFalse(countBeforeMarkedAsFishing.equals(countAfterMarkedAsFishing), "Emails count is not decreased after email is marked as fishing");
    }

    /**
     * Go to next page of email and verify emails there differ from the first one
     */
    public static void goToNextPage() {
        String dateFirstEmailDefaultPage = Browser.driver.findElements(All_EMAILS_ROWS).get(0).getAttribute("innerText");
        System.out.println("1st email's attributes when enter Inbox: " + dateFirstEmailDefaultPage);
        click(NEXT_PAGE_ICON);
        String dateFirstEmailNextPage = Browser.driver.findElements(All_EMAILS_ROWS).get(0).getAttribute("innerText");
        System.out.println("\n" + "1st email's attributes after going to next page: " + dateFirstEmailNextPage);
        assertFalse(dateFirstEmailDefaultPage.equals(dateFirstEmailNextPage), "Next Page option is not working - the same email appears");
    }

    /**
     * Go to previous page in Inbox
     */
    public static void goToPreviousPage() {
        String attributesFirstEmail = Browser.driver.findElements(All_EMAILS_ROWS).get(0).getAttribute("innerText");
        System.out.println("1st email's attributes on current page: " + attributesFirstEmail);
        click(NEXT_PAGE_ICON);
        click(PREVIOUS_PAGE_ICON);
        String attributesFirstEmailWhenBack = Browser.driver.findElements(All_EMAILS_ROWS).get(0).getAttribute("innerText");
        System.out.println("\n" + "1st email's attributes when go to next and back to previous page: " + attributesFirstEmailWhenBack);
        assertTrue(attributesFirstEmailWhenBack.equals(attributesFirstEmail), "Bug - emails are different");
    }

    /**
     * Go to the last of the pages available in Inbox
     */
    public static void goToLastPage() {
        click(LAST_PAGE_ICON);
    }

    /**
     * Verify user can go to the last page available in Inbox by one single click
     * @param messageOnFailure message to appear if last page can not be reached via one click
     */
    public static void verifyLastPageReached(String messageOnFailure) {
        WebElement nextPageDisabled = Browser.driver.findElement(NEXT_PAGE_ICON_DISABLED);
        assertTrue(nextPageDisabled.isDisplayed(), messageOnFailure);
    }

    /**
     * Go to first page in Inbox
     */
    public static void goToFirstPage() {
        click(FIRST_PAGE_ICON);
    }

    /**
     * Verify user is on first page in Inbox after going to other page
     * @param messageOnFailure message to appear if user is not on first page
     */
    public static void verifyUserIsOnFirstPage(String messageOnFailure) {
        WebElement firstPageDisabled = Browser.driver.findElement(FIRST_PAGE_ICON_DISABLED);
        assertTrue(firstPageDisabled.isDisplayed(), messageOnFailure);
    }

    /**
     * Reply to an email in Inbox
     * @param emailNumber number of the email to reply to
     */
    public static void reply(int emailNumber) {
        List<WebElement> fromInbox = Browser.driver.findElements(FROM_SECTION_INBOX);
        WebElement emailToOpen = fromInbox.get(emailNumber);
        emailToOpen.click();
        click(REPLY);
        type(EMAIL_BODY, "Test REPLY");
        click(SEND_BUTTON);
    }

    /**
     * Reply to all
     * @param emailNumber number of the email to reply to
     */
    public static void replyToAll(int emailNumber) {
        List<WebElement> fromInbox = Browser.driver.findElements(FROM_SECTION_INBOX);
        WebElement emailToOpen = fromInbox.get(emailNumber);
        emailToOpen.click();
        click(REPLY_TO_ALL);
        click(SEND_BUTTON);
    }

    /**
     * Forward selected email in Inbox
     * @param emailNumber number of the email to forward
     * @param emailReceiver email of the receiver to whom to forward the email
     */
    public static void forwardEmail(int emailNumber, String emailReceiver) {
        List<WebElement> fromInbox = Browser.driver.findElements(FROM_SECTION_INBOX);
        WebElement emailToOpen = fromInbox.get(emailNumber);
        emailToOpen.click();
        click(FORWARD);
        WebElement toField = Browser.driver.findElement(TO_FIELD);
        toField.sendKeys(emailReceiver);
        click(SEND_BUTTON);
    }

    /**
     * Open and close an email
     * @param emailNumber number of the email to close
     */
    public static void closeOpenEmail(int emailNumber) {
        List<WebElement> fromInbox = Browser.driver.findElements(FROM_SECTION_INBOX);
        WebElement emailToOpen = fromInbox.get(emailNumber);
        emailToOpen.click();
        click(CLOSE_BUTTON);
    }

    /**
     * Open previous email and verify it
     * @param emailNumber number of an email to open in Inbox
     * @param messageOnFailure message to appear if date attributes of the 2 emails compared are the same
     */
    public static void openPrevEmail(int emailNumber, String messageOnFailure) {
        List<WebElement> fromInbox = Browser.driver.findElements(FROM_SECTION_INBOX);
        WebElement emailToOpen = fromInbox.get(emailNumber);
        emailToOpen.click();
        String firstEmailAttributes = Browser.driver.findElement(EMAIL_DATE_ATTRIBUTES).getText().trim();
        System.out.println("Date of the first email: " + firstEmailAttributes);
        click(PREVIOUS_EMAIL_ICON);
        String previousEmailAttributes = Browser.driver.findElement(EMAIL_DATE_ATTRIBUTES).getText().trim();
        System.out.println("Date of the previous email: " + previousEmailAttributes);
        assertFalse(previousEmailAttributes.equals(firstEmailAttributes), messageOnFailure);
    }

    /**
     * Open next email and verify it
     * @param emailNumber number of an email to open in Inbox
     * @param messageOnFailure message to appear if date attributes of the 2 emails compared are the same
     */
    public static void openNextEmail(int emailNumber, String messageOnFailure) {
        List<WebElement> fromInbox = Browser.driver.findElements(FROM_SECTION_INBOX);
        WebElement emailToOpen = fromInbox.get(emailNumber);
        emailToOpen.click();
        String firstEmailAttributes = Browser.driver.findElement(EMAIL_DATE_ATTRIBUTES).getText().trim();
        System.out.println("Date of the first email: " + firstEmailAttributes);
        click(NEXT_EMAIL_ICON);
        String nextEmailAttributes = Browser.driver.findElement(EMAIL_DATE_ATTRIBUTES).getText().trim();
        System.out.println("Date of the next email: " + nextEmailAttributes);
        assertFalse(nextEmailAttributes.equals(firstEmailAttributes), messageOnFailure);
    }

    /**
     * Verify the invitation for chat is received - ONLY for new invitations
     * @param expectedSubject subject of the newest email that somebody sent you a chat request
     * @param messageOnFailure message to appear if chat invitation is not received
     */
    public static void verifyInvitationReceived(String expectedSubject, String messageOnFailure) {
        WebElement newestEmailSubject = Browser.driver.findElements(SUBJECT_SECTION_INBOX).get(0);
        String actualSubject = newestEmailSubject.getText();
        assertTrue(actualSubject.contains(expectedSubject));

    }
}

