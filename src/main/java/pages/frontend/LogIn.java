package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Browser;
import utils.WaitTool;

import javax.print.DocFlavor;

import static org.testng.Assert.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LogIn extends BasePage {
    private static final By USERNAME_FIELD = By.id("username");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("loginBut");
    private static final By WRONG_CREDENTIALS_WARNING = By.id("form.errors");
    private static final By FORGOT_PASS_LINK = By.cssSelector("#loginForm a.abv-ml10");
    private static final By USERNAME_FORGOT_PASS_FIELD = By.id("username");
    private static final By RECAPTCHA = By.cssSelector(".recaptcha-checkbox-checkmark");
    private static final By REGISTRATION_LINK = By.cssSelector("#loginForm a strong");
    private static final By REG_FLOW_USERNAME_FIELD = By.name("username");
    private static final By REG_FLOW_CHECK_BUTTON = By.cssSelector(".abv-button");
    private static final By REG_FLOW_USERNAME_FREE_MESSAGE = By.cssSelector(".abv-messageGray.abv-ok");
    private static final By REG_FLOW_PASSWORD_FIELD = By.name("password");
    private static final By REG_FLOW_PASSWORD_REENTER_FIELD = By.name("password2");
    private static final By REG_FLOW_PHONE_CHECKBOX = By.name("phoneRecovery");
    private static final By REG_FLOW_ALTERNATIVE_EMAIL_FIELD = By.name("altemail");
    private static final By REG_FLOW_QUESTION_FIELD = By.name("question");
    private static final By REG_FLOW_ANSWER_FIELD = By.name("answer");
    private static final By REG_FLOW_FNAME_FIELD = By.name("fname");
    private static final By REG_FLOW_LNAME_FIELD = By.name("lname");
    private static final By REG_FLOW_GENDER_RADIOBUTTON = By.xpath("//div[@class='abv-radio']/label[1]");
    private static final By REG_FLOW_DAY_DROPDOWN = By.id("bDay");
    private static final By REG_FLOW_DAY_3 = By.cssSelector("#bDay .abv-selList >li:nth-of-type(3)");
    private static final By REG_FLOW_MONTH_DROPDOWN = By.id("bMonth");
    private static final By REG_FLOW_MONTH_5 = By.cssSelector("#bMonth .abv-selList >li:nth-of-type(2)");
    private static final By REG_FLOW_YEAR_DROPDOWN = By.id("bYear");
    private static final By REG_FLOW_YEAR_1998 = By.cssSelector("#bYear .abv-selList >li:nth-of-type(9)");
    private static final By REG_FLOW_CAPTCHA_FIELD = By.id("captchaAnswer");
    private static final By REG_FLOW_CREATE_BUTTON = By.xpath("//div[@class='abv-row x abv-submitRow']//input[@type='submit']");
    private static final By GDPR = By.id("abv-GDPR-frame");
    private static final By REG_SUCCESS_MESSAGE = By.xpath("//div[@class='x']//h2");
    private static final By LOGIN_TO_YOUR_EMAIL_BUTTON = By.cssSelector(".abv-button");

    /**
     * Method to open the login page "www.abv.bg" and to maximize the window
     */
    public static void goTo() {
        Browser.driver.get("https://www.abv.bg/");
        Browser.driver.manage().window().maximize();
    }

    /**
     * Logs into the area of https://www.abv.bg/ using the provided credentials
     *
     * @param user     the username or email you would like to log in with
     * @param password the password you would like to login with
     */
    public static void logIn(String user, String password) {
        clear(USERNAME_FIELD);
        type(USERNAME_FIELD, user);
        clear(PASSWORD_FIELD);
        type(PASSWORD_FIELD, password);
        click(LOGIN_BUTTON);
    }

    /**
     * Verify a message to be displayed when trying to log in with incorrect credentials
     *
     * @param expectedWarningMessage warning message to alarm user wrong credentials are entered
     * @param messageOnFailure       message to indicate that the warning message is not displayed
     */
    public static void verifyWrongCredentialsMessage(String expectedWarningMessage, String messageOnFailure) {
        String actualWarningMessage = getText(WRONG_CREDENTIALS_WARNING).trim();
        Assert.assertEquals(actualWarningMessage, expectedWarningMessage, messageOnFailure);
    }

    public static void startChangePassAfterForgotPass(String username) {
        click(FORGOT_PASS_LINK);
        type(USERNAME_FORGOT_PASS_FIELD, username);
    }

    public static void verifyRecaptchaAppears(String expectedMessage, String messageOnFailure) {
        String actualMessage = Browser.driver.findElement(By.cssSelector(".recaptcha-title")).getText().trim();
        Assert.assertEquals(actualMessage, expectedMessage, messageOnFailure);
    }

    /**
     * Make a new registration in www.abv.bg
     * @param username username of the new user
     * @param password password of the new user
     * @param alternativeEmail another existing email required
     * @param firstName first name of the new user
     * @param lastName last name of the new user
     */
    public static void signUp(String username, String password, String alternativeEmail, String firstName, String lastName) {
        click(REGISTRATION_LINK);
        type(REG_FLOW_USERNAME_FIELD, username);
        click(REG_FLOW_CHECK_BUTTON);
//        if (!REG_FLOW_USERNAME_FREE_MESSAGE.toString().contains("Потребителското име е свободно")) {
//            System.out.println("Try another username - the entered one is already in use");
//        }
        type(REG_FLOW_PASSWORD_FIELD, password);
        type(REG_FLOW_PASSWORD_REENTER_FIELD, password);
        WebElement phoneCheckbox = Browser.driver.findElement(REG_FLOW_PHONE_CHECKBOX);
        if (phoneCheckbox.isEnabled()) {
            phoneCheckbox.click(); //that's how we disable it
        }
        type(REG_FLOW_ALTERNATIVE_EMAIL_FIELD, alternativeEmail);
        type(REG_FLOW_QUESTION_FIELD, "To be or not to be?");
        type(REG_FLOW_ANSWER_FIELD, "To beeee.");
        type(REG_FLOW_FNAME_FIELD, firstName);
        type(REG_FLOW_LNAME_FIELD, lastName);
        Browser.driver.switchTo().frame("abv-GDPR-frame").manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // Manually to tap ACCEPT on the GDPR window
        Browser.driver.switchTo().defaultContent();
        click(REG_FLOW_GENDER_RADIOBUTTON); //to choose male
        click(REG_FLOW_DAY_DROPDOWN);
        click(REG_FLOW_DAY_3); // to choose 3th
        click(REG_FLOW_MONTH_DROPDOWN);
        click(REG_FLOW_MONTH_5); // to choose May
        click(REG_FLOW_YEAR_DROPDOWN);
        click(REG_FLOW_YEAR_1998); // to choose 1998

        findElement(REG_FLOW_CAPTCHA_FIELD);
        click(REG_FLOW_CAPTCHA_FIELD);
        // Timeout to enter the CAPTCHA manually
        // EXPLICIT WAIT DA MU TURYA
        click(REG_FLOW_CREATE_BUTTON);
        String successfulRegMessage = Browser.driver.findElement(REG_SUCCESS_MESSAGE).getText().trim();
        assertTrue(successfulRegMessage.contains("Успешна регистрация."), "No SUCCESS message");
        click(LOGIN_TO_YOUR_EMAIL_BUTTON);
    }
}

