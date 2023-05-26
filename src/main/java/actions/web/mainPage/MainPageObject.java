package actions.web.mainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class MainPageObject {

    private final WebDriver webDriver;

    private WebElement mainPageTitle;
    public MainPageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    private WebElement getMainPageTitle() {
        mainPageTitle = webDriver.findElement(By.cssSelector("div[class=\"app_logo\"]"));
        return mainPageTitle;
    }
    public String getMainPageTitleText() {
        return getMainPageTitle().getText();
    }
}
