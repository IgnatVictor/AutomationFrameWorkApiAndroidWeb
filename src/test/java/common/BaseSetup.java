import actions.api.controller.CommentsController;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import repository.RepositoryApplication;

public class Setup {

    protected Setup() throws JsonProcessingException {
    }

    protected AppiumDriver driver;
    protected RepositoryApplication repositoryApplication = new RepositoryApplication();
    protected CommentsController controller = new CommentsController();
    protected WebDriver webDriver;
    protected FluentWait<WebDriver> wait;
    protected Actions actionsObject;





}
