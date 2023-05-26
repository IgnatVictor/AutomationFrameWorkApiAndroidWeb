package actions.android.secondActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class SecondActivityObject {

    private final WebDriver driver;

    private WebElement secondPageTitle;

    public SecondActivityObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getSecondPageTitle() {
        secondPageTitle = driver.findElement(By.id("textView"));
        return secondPageTitle;
    }

    public String getSecondPageTitleText() {
        return  getSecondPageTitle().getText();
    }
}
