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

import java.time.Duration;

public class CheckLoginTestCase extends BaseSetup {

    protected CheckLoginTestCase() throws JsonProcessingException {
    }

    private LoginPageObject createLoginPage() {
        return new LoginPageObject(webDriver);
    }

    private MainPageObject createMainPage() {
        return new MainPageObject(webDriver);
    }

    @BeforeMethod
    @Override
    public void setup() {
        final String URL = "https://www.saucedemo.com";
        repositoryApplication = new RepositoryApplication();
        ChromeOptions options = new ChromeOptions().addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(options);

        actionsObject = new Actions(webDriver);
        wait = new FluentWait<>(webDriver).withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofSeconds(5L)).ignoring(NoSuchElementException.class);

        webDriver.manage().window().maximize();
        webDriver.navigate().to(URL);
    }

    @AfterMethod
    @Override
    public void tearDown() {
        webDriver.close();
        webDriver.quit();
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
