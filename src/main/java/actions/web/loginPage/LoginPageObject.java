package actions.web.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class LoginPageObject {

    private final WebDriver webDriver;

    private WebElement usernameInput;
    private WebElement passwordInput;
    private WebElement loginButton;
    private WebElement invalidLoginMessage;

    public LoginPageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private WebElement getUsernameInput() {
        usernameInput = webDriver.findElement(By.id("user-name"));
        return usernameInput;
    }

    private WebElement getPasswordInput() {
        passwordInput = webDriver.findElement(By.id("password"));
        return passwordInput;
    }

    private WebElement getLoginButton() {
        loginButton = webDriver.findElement(By.id("login-button"));
        return loginButton;
    }

    private WebElement getInvalidLoginMessage() {
        invalidLoginMessage = webDriver.findElement(By.cssSelector("h3[data-test=\"error\"]"));
        return invalidLoginMessage;
    }

    public void setUsername(String username) {
        getUsernameInput().sendKeys(username);
    }

    public void setPassword(String password) {
        getPasswordInput().sendKeys(password);
    }

    public void clickOnLoginButton() {
        getLoginButton().click();
    }

    public String getInvalidLoginMessageText() {
        return getInvalidLoginMessage().getText();
    }
}
