package web.setupWeb;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import repository.RepositoryApplication;

import java.time.Duration;

public abstract class SetupWeb {

    protected WebDriver webDriver;
    protected RepositoryApplication repositoryApplication;
    protected FluentWait<WebDriver> wait;
    protected Actions actionsObject;

    @BeforeMethod
    public void beforeTest() {
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
    public void tearDown() {
        webDriver.close();
        webDriver.quit();
    }
}
