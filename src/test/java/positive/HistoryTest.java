package positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Home;
import pages.frontend.LogIn;

public class HistoryTest extends BaseTests {

    @Test
    public void historyOfEntrance(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Home.checkHistoryOfEntrance();
        Home.verifyHistoryIsLoaded("История", "Not the proper title is appearing");
    }
}
