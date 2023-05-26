package actions.android.mainActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class MainActivityObject {

    private final WebDriver driver;

    private WebElement email;
    private WebElement loginButton;
    private WebElement password;
    private WebElement wrongEmailMessage;

    private WebElement getWrongEmailMessage() {
        wrongEmailMessage = driver.findElement(By.xpath("//android.widget.Toast[1]"));
        return  wrongEmailMessage;
    }

    public MainActivityObject(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement getEmail() {
        email =  driver.findElement(By.id("inEmail"));
        return email;
    }

    private WebElement getPassword() {
        password =  driver.findElement(By.id("inPassword"));
        return password;
    }

    private WebElement getLoginButton() {
        loginButton =   driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button"));
        return loginButton;
    }

    public void setEmail(String email) {
        getEmail().sendKeys(email);
    }

    public void setPassword(String password) {
        getPassword().sendKeys(password);
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }

    public String getWrongEmailMessageText() {
        return getWrongEmailMessage().getAttribute("name");
    }
}
