package negative;

import core.BaseTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.frontend.LogIn;

public class LogInNegativeTests extends BaseTests {

    @DataProvider
    public Object[][] testData(){
        String[][] testData = {
                {"kikoni", "1234"}, //wrong user, wrong pass
                {"BARNY!@#$", "Barny123456"}, //right credentials, but entered in a CAPSLOCK mode
                {"фьихщ1234", "Фьихщ123456"}, //right credentials, but entered in Cyrillic
                {"barny1234", "123456"}, //right user, wrong pass
                {"barny123", "Barny123456"}, //wrong user, right pass
        };
        return testData;
    }
    @Test(dataProvider = "testData")
    public void unsuccessfulLogIn(String user, String password){
        LogIn.goTo();
        LogIn.logIn(user, password);
        LogIn.verifyWrongCredentialsMessage("Грешен потребител / парола.", "Missing warning message");
    }

}
