package components;

import core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.frontend.LogIn;
import utils.Browser;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

public class Write extends BasePage {
    private static final By WRITE_BUTTON = By.cssSelector(".abv-button");
    private static final By SEND_BUTTON = By.cssSelector(".abv-button");
    private static final By TO_FIELD = By.xpath("//td[@class='clientField']//input[@class='fl']");
    private static final By SUBJECT_FIELD = By.cssSelector(".abv-textField input");
    private static final By EMAIL_BODY = By.cssSelector(".gwt-RichTextArea");
    private static final By CONFIRMATION_MESSAGE_SENT = By.xpath("//*[@id=\"middlePagePanel\"]/div[1]/div[1]");
    private static final By UPLOAD_UPPER_MENU = By.cssSelector(".sendFp1.abv-fileUpload");
    private static final By SAVE_IN_DRAFTS_TAB = By.xpath("//div[@class='sendMenuContent']//div[4]");
    private static final By CONFIRMATION_TO_SEND_WITHOUT_SUBJECT = By.cssSelector(".line-Bottom");
    private static final By DECLINE_BUTTON_EMPTY_SUBJECT = By.cssSelector(".abv-button:nth-of-type(2)");
    private static final By CONFIRM_BUTTON_EMPTY_SUBJECT = By.cssSelector(".dialogMiddleCenterInner td .cancelButtonWrapper .abv-button:nth-of-type(1)");
    private static final By CLOSE_BUTTON_ALERT_EMPTY_TO = By.cssSelector(".dialogMiddleCenterInner .abv-button");
    private static final By WARNING_PLEASE_ENTER_RECEIVER = By.cssSelector(".line-Bottom");
    private static final By WARNING_INVALID_RECEIVER_EMAIL = By.cssSelector(".dialogBoxExt.abv-alertBox .gwt-HTML .line-Bottom");
    private static final By REFUSE_EMAIL_BUTTON = By.cssSelector(".sendFp1:nth-of-type(6)");
    private static final By ATTACHMENT = By.cssSelector(".attachment-b.abv-ico");

    /**
     * Write an email using the form from the upper left corner
     */
    public static void createEmail() {
        click(WRITE_BUTTON);
    }

    /**
     * Verify a form to create new email is open after tap Write button
     */
    public static void verifyCreateNewEmail() {
        WebElement actualSendButton = Browser.driver.findElement(SEND_BUTTON);
        assertTrue(actualSendButton.isDisplayed(), "Missing Send button");
    }

    /**
     * Fill in all the fields required of the email
     * @param emailReceiver email of the receiver of the message
     * @param subject subject of the email
     * @param emailBody body of the email
     */
    public static void fillInEmailFieldsRequired(String emailReceiver, String subject, String emailBody) {
        clear(TO_FIELD);
        type(TO_FIELD, emailReceiver);
        type(SUBJECT_FIELD, subject);
        type(EMAIL_BODY, emailBody);
    }

    /**
     * Fill in all fields required and send the email
     * @param emailReceiver email of the receiver of the message
     * @param subject subject of the email
     * @param emailBody body of the email
     */
    public static void sendEmail(String emailReceiver, String subject, String emailBody) {
        clear(TO_FIELD);
        type(TO_FIELD, emailReceiver);
        type(SUBJECT_FIELD, subject);
        type(EMAIL_BODY, emailBody);
        click(SEND_BUTTON);
    }

    /**
     * Verify the email is sent and received by displaying a confirmation message
     */
    public static void verifyEmailIsSent(String expectedMessage, String messageOnFailure) {
        String actualMessageText = getText(CONFIRMATION_MESSAGE_SENT);
        assertTrue(actualMessageText.contains(expectedMessage), messageOnFailure);
    }
    /**
     * Attach a file and send the email with this attachment - we need MANUAL INTERVENTION in this test case
     */
    public static void uploadFile(String emailReceiver, String subject, String emailBody) {
        click(UPLOAD_UPPER_MENU);
        //Note that you can not automate the upload of a file itself
        // So, add a wait to attach a file manually:
        Browser.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement attachment = Browser.driver.findElement(ATTACHMENT);
        assertTrue(attachment.isDisplayed());
        type(TO_FIELD, emailReceiver);
        type(EMAIL_BODY, emailBody);
        type(SUBJECT_FIELD, subject);
        click(SEND_BUTTON);
    }
    /**
     * Verify Write button is covered by a dialog window to upload files from
     * @param messageOnFailure message if dialog box is not appearing
     */
    public static void verifyUploadIsTappable(String messageOnFailure) {
        WebElement actualDisplay = Browser.driver.findElement(WRITE_BUTTON);
        assertFalse(actualDisplay.isSelected(), messageOnFailure);
    }
    /**
     * Save a draft
     */
    public static void saveDraft() {
        click(SAVE_IN_DRAFTS_TAB);
        Browser.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    /**
     * Fill in only To field
     * @param emailReceiver
     */
    public static void fillInToOnly(String emailReceiver) {
        type(TO_FIELD, emailReceiver);
        click(SEND_BUTTON);
    }

    /**
     * Fill in only Subject field
     */
    public static void fillInSubjectOnly(String subject) {
        type(SUBJECT_FIELD, subject);
    }

    /**
     * Verify alert pops up if user tries to send an email without a subject
     * @param expectedEmptySubjectMessage message that user sees if try to send an email without a subject
     * @param messageOnFailure message to display if there is no warning message or it is a wrong one
     */
    public static void verifyWarningEmptySubject(String expectedEmptySubjectMessage, String messageOnFailure) {
        String actualEmptySubjectMessage = Browser.driver.findElement(CONFIRMATION_TO_SEND_WITHOUT_SUBJECT).getText().trim();
        assertEquals(actualEmptySubjectMessage, expectedEmptySubjectMessage, messageOnFailure);
    }
    /**
     * Decline an email that has no subject
     */
    public static void declineEmailWithoutSubject() {
        click(DECLINE_BUTTON_EMPTY_SUBJECT);
    }

    /**
     * Verify email is sent after confirmation to send it without subject
     */
    public static void confirmEmailWithoutSubject() {
        click(CONFIRM_BUTTON_EMPTY_SUBJECT);
    }

    /**
     * Warning popup if user tries to send a message without recipient filled in
     */
    public static void canNotSendEmailWithoutTo() {
        click(SEND_BUTTON);
    }

    /**
     * Verify that a warning popup appears if user tries to send an email without recipient filled in
     * @param expectedWarningEmptyToField expected text of the warning message
     * @param messageOnFailure message to appear if the popup is missing
     */
    public static void verifyWarningToEnterRecipient(String expectedWarningEmptyToField, String messageOnFailure) {
        String actualWarningEmptyToField = Browser.driver.findElement(WARNING_PLEASE_ENTER_RECEIVER).getText().trim();
        assertEquals(actualWarningEmptyToField, expectedWarningEmptyToField, messageOnFailure);
        click(CLOSE_BUTTON_ALERT_EMPTY_TO);
    }
    /**
     * Verify that popup appears if the email of the receiver is invalid
     * @param expectedWarningInvalidEmailReceiver
     * @param messageOnFailure
     */
    public static void verifyWarningReceiverInvalidEmail(String expectedWarningInvalidEmailReceiver, String messageOnFailure) {
        Browser.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String actualWarningInvalidEmailReceiver = Browser.driver.findElement(WARNING_INVALID_RECEIVER_EMAIL).getText().trim();
        assertEquals(actualWarningInvalidEmailReceiver, expectedWarningInvalidEmailReceiver, messageOnFailure);
       // Browser.driver.findElement(By.cssSelector(".abv-button")).click();
    }
    /**
     * Refuse an email once created by tapping OK on the alert
     */
    public static void refuseEmailCreatedOk() {
        click(REFUSE_EMAIL_BUTTON);
        Alert alert = Browser.driver.switchTo().alert();
        String alertText = alert.getText().trim();
        assertTrue(alertText.contains("Сигурни ли сте, че искате да прекъснете писането на това писмо?"));
        alert.accept();
    }

    /**
     * Refuse to refuse the email, by tapping Cancel on the alert
     */
    public static void refuseEmailCreatedCancel() {
        click(REFUSE_EMAIL_BUTTON);
        Alert alert = Browser.driver.switchTo().alert();
        String alertText = alert.getText().trim();
        assertTrue(alertText.contains("Сигурни ли сте, че искате да прекъснете писането на това писмо?"));
        alert.dismiss();
    }


}
