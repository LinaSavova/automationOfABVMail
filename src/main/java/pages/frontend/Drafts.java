package pages.frontend;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.Browser;
import utils.WaitTool;

public class Drafts {
    private static final By DRAFTS_SIDE_MENU_NEW_ITEMS = By.id("gwt-uid-517");
    private static final By DRAFT_SAVED_NOTICE = By.cssSelector(".abv-loadingContainer #topLoader");

    /**
     * Verify draft is saved into Draft folder
     * @param expectedNotice validation message when draft is successfully saved
     * @param messageOnFailure message to display if the validation message is not displayed
     */
    public static void verifyDraftIsSaved(String expectedNotice, String messageOnFailure) {
        WaitTool.waitForElementToBeDisplayed(DRAFT_SAVED_NOTICE);
        String actualNotice = Browser.driver.findElement(DRAFT_SAVED_NOTICE).getText().trim();
        Assert.assertEquals(actualNotice, expectedNotice, messageOnFailure);
    }
}
