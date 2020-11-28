package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import utils.Browser;

public class Drafts extends BasePage {
    private static final By DRAFTS_RECEIVERS_COLLECTION = By.xpath("//div[@class='abv-grayBG']//tr[@__gwt_subrow='0']/td[2]");
    private static final By EDIT_DRAFT = By.cssSelector(".abv-exclaimText.abv-cursor");
    private static final By SEND_BUTTON = By.cssSelector(".abv-button");
    
    public static void editDraftAndSendIt(int emailNumber) {
        Browser.driver.findElements(DRAFTS_RECEIVERS_COLLECTION).get(emailNumber).click();
        click(EDIT_DRAFT);
        click(SEND_BUTTON);
    }
}
