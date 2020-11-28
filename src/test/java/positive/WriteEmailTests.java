package positive;

import components.Write;
import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Drafts;
import pages.frontend.Home;
import pages.frontend.LogIn;
import utils.Browser;
import java.util.concurrent.TimeUnit;

public class WriteEmailTests extends BaseTests {
    @Test
    public void createEmail(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        Write.createEmail();
        Write.verifyCreateNewEmail();
    }
    @Test
    public void sendEmail(){
        createEmail();
        Write.sendEmail("putEmail", "Test", "This is a test email");
        Browser.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Write.verifyEmailIsSent("Писмото беше изпратено успешно!", "Confirmation for sent message is not displayed");
    }
    @Test
    public void attachFile(){
        createEmail();
        Write.uploadFile("putEmail", "Attachment Test", "Send email with attachment");
        Write.verifyEmailIsSent("Писмото беше изпратено успешно!", "Confirmation for sent message is not displayed");
    }
    //Това да го оправя, защото ми гърми на асърта - не разпознава "Черновата е записана успешно"
    @Test
    public void saveEmailInDrafts(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        Write.saveDraft("Count in drafts not increased");
        // The verification is into the method itself
    }
    @Test
    public void refuseEmailAccept(){
        createEmail();
        Write.fillInEmailFieldsRequired("putEmail", "Testing refuse email, OK", "Test");
        Write.refuseEmailCreatedOk();
    }
    @Test
    public void refuseEmailDismiss(){
        createEmail();
        Write.fillInEmailFieldsRequired("putEmail", "Testing refuse email, Cancel", "Teeeeeeeest");
        Write.refuseEmailCreatedCancel();
    }
    @Test
    public void editDraftAndSendIt(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        Home.goToDrafts();
        Drafts.editDraftAndSendIt(0);
        Write.verifyEmailIsSent("Писмото беше изпратено успешно!", "Confirmation for sent message is not displayed");
    }

}
