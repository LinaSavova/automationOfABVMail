package positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Home;
import pages.frontend.LogIn;
import pages.frontend.Profile;

public class ProfileTests extends BaseTests {
    @Test
    public void goToProfile(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        Home.goToInbox();
        Home.goToProfile();
        Profile.verifyUserIsToProfile("Back to ABV button is not displayed");
    }
    @Test
    public void editProfile(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        Home.goToInbox();
        Home.goToProfile();
        Profile.editProfile();
        Profile.verifyProfileIsEdited("Промените са записани успешно!", "No confirmation message displayed");
    }
    @Test
    public void backToMail(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        Home.goToInbox();
        Home.goToProfile("putPassword");
        Profile.goBackToMail();
        Home.verifyLogIn("User is not to ABV mail");
    }
}
