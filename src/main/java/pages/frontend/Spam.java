package pages.frontend;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Browser;

import java.util.List;

public class Spam extends BasePage {
    static Actions actions = new Actions(Browser.driver);

    private static final By SPAM_SIDE_MENU = By.xpath("//div[@class='abv-fMl5 abv-BrBot']//tr[@__gwt_row='3']");
    private static final By ALL_SPAM_COUNTERS = By.xpath("//td[starts-with(@id, 'gwt-uid-')]/div[@class='GG3HBNKBH-']");


}
