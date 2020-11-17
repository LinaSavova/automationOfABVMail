package positive;

import components.Write;
import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Home;
import pages.frontend.Inbox;
import pages.frontend.LogIn;

public class InboxTests extends BaseTests {

    @Test
    public void goToInbox(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Home.goToInbox();
        Inbox.verifyUserIsIntoInbox("Сортирай", "Sort option is missing or renamed");
    }
    @Test
    public void deleteAnEmail(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Home.goToInbox();
        Inbox.deleteAnEmail();
        // The verification is into the method itself
    }
    @Test
    public void deleteCoupleOfEmails(){
        goToInbox();
        Inbox.deleteFewEmails();
    }
    @Test
    public void selectAndDeleteAll(){
        LogIn.goTo();
        LogIn.logIn("kostata34", "aA123456$");
        Home.goToInbox();
        Inbox.deleteAllInInbox();
        Inbox.verifyAllEmailsDeleted("Папката е празна", "Message when all emails are deleted is not present");
    }
    @Test
    public void moveEmailToAnotherFolder(){
        LogIn.goTo();
        LogIn.logIn("smelichkata@abv.bg", "smelichkata123456");
        Inbox.moveAnEmailToBinFolder(1);
        // The verification is into the method itself
    }
    @Test
    public void flagAnEmail(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Home.goToInbox();
        Inbox.flag();
        Inbox.verifyEmailIsFlagged("Email not flagged");
    }
    @Test
    public void removeFlag(){
        flagAnEmail();
        Inbox.removeFlag();
        // The verification is into the method itself
    }
    @Test
    public void markAsRead(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Home.goToInbox();
        Inbox.markAsRead(5);
        // The verification is into the method itself
    }
    @Test
    public void markAsUnread(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Home.goToInbox();
        Inbox.marksAsUnread(4);
        // The verification is into the method itself
    }
    @Test
    public void markAsSpam() {
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Inbox.markAsSpam(3);
        // The verification is into the method itself
    }
    @Test
    public void markAsFishing(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Inbox.markAsFishing(2);
        // The verification is into the method itself
    }
    @Test
    public void sortBy(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Home.goToInbox();
        Inbox.sortEmailsBy(8);
    }
    @Test
    public void goToNextPage(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Home.goToInbox();
        Inbox.goToNextPage();
        // The verification is into the method itself
    }
    @Test
    public void goToPreviousPage(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Home.goToInbox();
        Inbox.goToPreviousPage();
        // The verification is into the method itself
    }
    @Test
    public void goToLastPage(){
        goToInbox();
        Inbox.goToLastPage();
        Inbox.verifyLastPageReached("Possible bug here");
    }
    @Test
    public void goToFirstPage(){
        goToNextPage();
        Inbox.goToFirstPage();
        Inbox.verifyUserIsOnFirstPage("Possible bug here");
    }
    @Test
    public void replyToAnEmail(){
        goToInbox();
        Inbox.reply(1);
        Write.verifyEmailIsSent("Писмото беше изпратено успешно!", "Confirmation for sent message is not displayed");
    }
    @Test
    public void replyToAll(){
        goToInbox();
        Inbox.replyToAll(1);
        Write.verifyEmailIsSent("Писмото беше изпратено успешно!", "Confirmation for sent message is not displayed");
    }
    @Test
    public void forwardEmail(){
        goToInbox();
        Inbox.forwardEmail(1, "smelichkata@abv.bg");
        Write.verifyEmailIsSent("Писмото беше изпратено успешно!", "Confirmation for sent message is not displayed");
    }
    @Test
    public void closeEmail(){
        goToInbox();
        Inbox.closeOpenEmail(1);
        Inbox.verifyUserIsIntoInbox("Сортирай", "User is not in Inbox");
    }
    @Test
    public void openPreviousEmail(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Home.goToInbox();
        Inbox.openPrevEmail(4, "The same date attributes appear");
        // Verification is into the method itself
    }
    @Test
    public void openNextEmail(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Home.goToInbox();
        Inbox.openNextEmail(4, "The same date attributes appear");
        // 17111Verification is into the method itself
    }

}
