package positive;

import core.BaseTests;
import org.testng.annotations.Test;
import pages.frontend.Home;
import pages.frontend.LogIn;
//RECOMMENDED: PERFORM THESE TEST CASES IN A ROW
public class FolderTests extends BaseTests {
    @Test
    public void addNewFolder(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Home.addNewFolder();
        //The verification is into the method itself
    }
    @Test
    public void renameAnExistingFolder(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Home.renameFolder();
   //     Home.verifyFolderIsRenamed();
    }
    @Test
    public void removeFolder(){
        LogIn.goTo();
        LogIn.logIn("barny1234", "Barny123456");
        Home.removeFolder();
        //The verification is into the method itself
    }
}
