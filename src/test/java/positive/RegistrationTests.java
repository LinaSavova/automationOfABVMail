package positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Home;
import pages.frontend.LogIn;

public class RegistrationTests extends BaseTests {
    @Test
    public void makeNewReg(){
        LogIn.goTo();
        LogIn.signUp("kostak1234561b5", "aA123456@#aA", "smelichkata@abv.bg", "Mincho", "Stoev");
        Home.verifyLogIn("User is not logged in after registration");
    }
}
