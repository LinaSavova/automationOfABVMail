package positive;

import components.Search;
import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Home;
import pages.frontend.LogIn;

public class SearchTests extends BaseTests {

    @Test
    public void searchForEmails(){
        LogIn.goTo();
        LogIn.logIn("smelichkata", "smelichkata123456");
        Search.searchForEmails("Barny");
        Home.verifyEmailsAreSearched("Резултати от търсене", "Results message is not displayed");
    }
    @Test
    public void advancedSearch(){
        LogIn.goTo();
        LogIn.logIn("smelichkata", "smelichkata123456");
        Search.advancedSearch("b", "b", "Test");
        Home.verifyEmailsAreSearched("Резултати от търсене", "Results message is not displayed");
    }
}
