package web;

import actions.web.loginPage.LoginPageObject;
import actions.web.mainPage.MainPageObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import common.BaseSetup;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import repository.RepositoryApplication;
import web.setupWeb.SetupWeb;

import java.time.Duration;

public class CheckLoginTestCase extends SetupWeb {

    private LoginPageObject createLoginPage() {
        return new LoginPageObject(webDriver);
    }

    private MainPageObject createMainPage() {
        return new MainPageObject(webDriver);
    }

    @Test
    public void checkInvalidLoginCredentialsMessage() throws InterruptedException {
        final LoginPageObject loginPageObject = createLoginPage();

        loginPageObject.setPassword(repositoryApplication.getWrongPasswordForWeb());
        loginPageObject.setUsername(repositoryApplication.getWrongUsernameForWeb());
        loginPageObject.clickOnLoginButton();

        Thread.sleep(1000);

        Assert.assertEquals(loginPageObject.getInvalidLoginMessageText(), repositoryApplication.getInvalidCredentialsMessageText());
    }

    @Test
    public void checkThatLoginRedirectsYouToMainPage() throws InterruptedException {
        final LoginPageObject loginPageObject = createLoginPage();
        final MainPageObject mainPageObject = createMainPage();

        loginPageObject.setPassword(repositoryApplication.getPasswordForWeb());
        loginPageObject.setUsername(repositoryApplication.getUsernameForWeb());
        loginPageObject.clickOnLoginButton();

        Thread.sleep(2000);

        Assert.assertEquals(mainPageObject.getMainPageTitleText(), repositoryApplication.getMainPageTitleText());
    }
}
