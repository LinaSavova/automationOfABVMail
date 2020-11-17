package positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Home;
import pages.frontend.LogIn;
import utils.Browser;

public class LoginTests extends BaseTests {
    @Test
    public static void successfulLogIn(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Home.verifyLogIn("Email not displayed when user is logged in");
    }
}
