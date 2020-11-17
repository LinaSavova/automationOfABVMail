package positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Home;
import pages.frontend.LogIn;

public class ForgotPassTests extends BaseTests {

    @Test
    public static void appearCaptchaWhenForgotPassword(){
        LogIn.goTo();
        LogIn.startChangePassAfterForgotPass("smelichkata");
        LogIn.verifyRecaptchaAppears("Антиспам верификация:", "Missing recaptcha to change pass");
    }

}
