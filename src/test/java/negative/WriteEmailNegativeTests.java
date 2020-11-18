package negative;

import components.Write;
import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.LogIn;
import utils.Browser;

import java.util.concurrent.TimeUnit;

public class WriteEmailNegativeTests extends BaseTests {

    @Test
    public void warnIfSubjectIsEmpty(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        Write.createEmail();
        Write.fillInToOnly("putEmailHere");
        Write.verifyWarningEmptySubject("Искате ли да изпратите писмото без тема?", "No warning displayed for empty subject");
    }
    @Test
    public void declineEmailIfSubjectIsEmpty(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        Write.createEmail();
        Write.fillInToOnly("putEmailHere");
        Write.verifyWarningEmptySubject("Искате ли да изпратите писмото без тема?", "No warning displayed for empty subject");
        Write.declineEmailWithoutSubject();
    }
    @Test
    public void sendEmailIfSubjectIsEmpty(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        Write.createEmail();
        Write.fillInToOnly("putEmailHere");
        Write.verifyWarningEmptySubject("Искате ли да изпратите писмото без тема?", "No warning displayed for empty subject");
        Write.confirmEmailWithoutSubject();
        Write.verifyEmailIsSent("Писмото беше изпратено успешно!", "Email not sent after confirmation");
    }
    @Test
    public void warnIfToIsEmpty(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        Write.createEmail();
        Write.canNotSendEmailWithoutTo();
        Write.verifyWarningToEnterRecipient("Моля въведете поне един получател.", "No warning message for empty To field");
    }
    @Test
    public void warnIfInvalidReceiverEmailWritten(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        Write.createEmail();
        Write.fillInSubjectOnly("test");
        Write.fillInToOnly("putEmailHere");
        Write.verifyWarningReceiverInvalidEmail("Писмото съдържа невалиден имейл адрес.", "Missing warning message when receiver's email is invalid");
    }

}
