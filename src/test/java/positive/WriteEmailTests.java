package positive;

import components.Write;
import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Drafts;
import pages.frontend.LogIn;
import utils.Browser;
import utils.WaitTool;

import java.util.concurrent.TimeUnit;

public class WriteEmailTests extends BaseTests {
    @Test
    public void createEmail(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Write.createEmail();
        Write.verifyCreateNewEmail();
    }
    @Test
    public void sendEmail(){
        createEmail();
        Write.sendEmail("kostata34@abv.bg", "Test", "This is a test email");
        Browser.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Write.verifyEmailIsSent("Писмото беше изпратено успешно!", "Confirmation for sent message is not displayed");
    }
    @Test
    public void attachFile(){
        createEmail();
        Write.uploadFile("kostata34@abv.bg", "Attachment Test", "Send email with attachment");
        Write.verifyEmailIsSent("Писмото беше изпратено успешно!", "Confirmation for sent message is not displayed");
    }
    //Това да го оправя, защото ми гърми на асърта - не разпознава "Черновата е записана успешно"
    @Test
    public void saveEmailInDrafts(){
        createEmail();
        Write.fillInEmailFieldsRequired("smelichkata@abv.bg", "Test", "Testing save email in Drafts");
        Write.saveDraft();
        Drafts.verifyDraftIsSaved("Черновата е записана успешно","Message for saved draft is not displayed");
    }
    @Test
    public void refuseEmailAccept(){
        createEmail();
        Write.fillInEmailFieldsRequired("smelichkata@abv.bg", "Testing refuse email, OK", "Test");
        Write.refuseEmailCreatedOk();
    }
    @Test
    public void refuseEmailDismiss(){
        createEmail();
        Write.fillInEmailFieldsRequired("smelichkata@abv.bg", "Testing refuse email, Cancel", "Teeeeeeeest");
        Write.refuseEmailCreatedCancel();
    }

}
