package negative;

import components.Search;
import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Home;
import pages.frontend.LogIn;

public class SearchNegativeTests extends BaseTests {

    @Test
    public void searchNoItemsFound(){
        LogIn.goTo();
        LogIn.logIn("smelichkata", "smelichkata123456");
        Search.searchForEmails("barny0");
        Home.verifyNoEmailsFound("Няма намерени писма по зададените критерии.", "The message for no results found is missing");
    }
}
