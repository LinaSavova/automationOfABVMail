package positive;

import components.ABVPost;
import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Home;
import pages.frontend.Inbox;
import pages.frontend.LogIn;
import utils.Browser;

import java.util.concurrent.TimeUnit;

public class ContactsTests extends BaseTests {

    @Test
    public void loadContacts(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        ABVPost.goToContacts();
        ABVPost.verifyContactsLoaded("No row with contacts is displayed");
    }
    @Test
    public void addToContacts(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        ABVPost.addToContacts(0, "Counter not changing after added a new one");
        //Test verification is into the method itself
    }
    @Test
    public void deleteContact(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        ABVPost.goToContacts();
        ABVPost.deleteContact(0, "Contacts' number is not decreased after deletion");
        //Test verification is into the method itself
    }
    @Test
    public void searchForContact(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        Home.searchForContact();
        Home.logOut();
        LogIn.goTo();
        Browser.driver.switchTo().frame("abv-GDPR-frame").manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Browser.driver.switchTo().defaultContent();
        LogIn.logIn("putSecondUsername", "putPassword");
        Home.goToInbox();
        Inbox.verifyInvitationReceived("Barny Rubble ви изпрати покана за чат", "Invitation not received");
    }

}
