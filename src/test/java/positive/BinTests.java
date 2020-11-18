package positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Bin;
import pages.frontend.Home;
import pages.frontend.Inbox;
import pages.frontend.LogIn;

public class BinTests extends BaseTests {
    @Test
    public void moveDeletedEmailBackToInbox(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        Home.goToInbox();
        Inbox.deleteAnEmail();
        Home.goToBin();
        Bin.moveBackToInbox(0, "Emails count in Bin not decreased");
    }

    @Test
    public void emptyBinFolder(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        Bin.emptyBinFolder();
        Bin.verifyBinIsEmpty("Папката е празна", "No or wrong confirmation message for empty folder");
    }
}
