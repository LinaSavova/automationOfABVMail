package positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Gyuvech;
import pages.frontend.Home;
import pages.frontend.LogIn;

public class LogOutTests extends BaseTests {

    @Test
    public static void successfulLogOut(){
        LogIn.goTo();
        LogIn.logIn("putUsername", "putPassword");
        Home.logOut();
        Gyuvech.verifyUserIsLoggedOut("Gyuvech header is not loaded after logout");
    }
}
