package common;

import actions.api.controller.CommentsController;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import repository.RepositoryApplication;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseSetup {

    protected BaseSetup() throws JsonProcessingException {
    }

    protected AppiumDriver driver;
    protected RepositoryApplication repositoryApplication = new RepositoryApplication();
    protected CommentsController controller = new CommentsController();
    protected WebDriver webDriver;
    protected FluentWait<WebDriver> wait;
    protected Actions actionsObject;


    @BeforeMethod
    public void setup() throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability(MobileCapabilityType.APP, "C:/AutomationApiWebAndroid/AutomationFrameWorkApiAndroidWeb/src/main/resources/app-debug.apk");
        driver = new AndroidDriver(url, caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
