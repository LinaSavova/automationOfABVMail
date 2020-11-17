package core;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Browser;
import utils.WaitTool;

public class BaseTests {
    @BeforeMethod
    public void setUp(){
        Browser.setUp();
    }

    @AfterMethod
    public void tearDown(){
        Browser.tearDown();
    }
}
