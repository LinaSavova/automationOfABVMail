package negative;

import components.ABVPost;
import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.LogIn;

public class ContactsNegativeTests extends BaseTests {

    @Test
    public void contactsEmptyFolder(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        ABVPost.goToContacts();
        ABVPost.verifyEmptyContactsMessage("Групата е празна", "Not a warning message displayed");
    }
    @Test
    public void contactNotAddedTwice(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        ABVPost.canNotAddTwice(0, "Counter still increasing");
    }
}
