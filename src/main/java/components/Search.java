package components;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Browser;

import java.util.List;

public class Search extends BasePage {
    private static final By UPPER_SEARCH_FIELD = By.cssSelector(".gwt-TextBox");
    private static final By SEARCH_ICON = By.id("searchlens");
    private static final By ADVANCED_SEARCH_BUTTON = By.cssSelector(".advSearch");
    private static final By ADV_SEARCH_FROM = By.xpath("//div[@class='sItem'][1]/input");
    private static final By ADV_SEARCH_TO = By.xpath("//div[@class='sItem'][2]/input");
    private static final By ADV_SEARCH_ABOUT = By.xpath("//div[@class='sItem'][3]/input");
    private static final By ADV_SEARCH_DATE = By.xpath("//div[@class='sItem'][4]/input");
    private static final By ADV_SEARCH_ALL_FOLDERS = By.xpath("//input[@value='on']");
    private static final By ADV_SEARCH_BUTTON = By.xpath("//*[@id=\"main\"]/div/div[4]/div/div[4]/div/div[4]/div/div[2]/div/div[2]/div[6]/div[1]");

    /**
     * Search for emails using the upper component Search field
     */
    public static void searchForEmails(String whatToSearchFor) {
        type(UPPER_SEARCH_FIELD, whatToSearchFor);
        click(SEARCH_ICON);
    }

    /**
     * Advanced search for emails
     */
    public static void advancedSearch(String whatToTypeFrom, String whatToTypeTo, String whatToTypeAbout) {
        click(UPPER_SEARCH_FIELD);
        click(ADVANCED_SEARCH_BUTTON);
        type(ADV_SEARCH_FROM, whatToTypeFrom);
        type(ADV_SEARCH_TO, whatToTypeTo);
        type(ADV_SEARCH_ABOUT, whatToTypeAbout);
        List<WebElement> allFolders = Browser.driver.findElements(ADV_SEARCH_ALL_FOLDERS);
        for (WebElement folder : allFolders) {
            if (!folder.isSelected()) {
                folder.click();
                break;
            }
        }
            click(ADV_SEARCH_BUTTON);
        }
}
