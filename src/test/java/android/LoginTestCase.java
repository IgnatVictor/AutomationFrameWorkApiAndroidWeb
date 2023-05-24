package android;


import actions.android.mainActivity.MainActivityObject;
import actions.android.secondActivity.SecondActivityObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import common.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestCase extends BaseSetup {

    protected LoginTestCase() throws JsonProcessingException {
    }

    private MainActivityObject createMainActivityObject() {
        return new MainActivityObject(driver);
    }

    private SecondActivityObject createSecondActivityObject() {
        return new SecondActivityObject(driver);
    }

    @Test
    public void checkThatAfterLoginItRedirectsToFirstPage() throws InterruptedException {
        final MainActivityObject mainActivityObject = createMainActivityObject();
        final SecondActivityObject secondActivityObject = createSecondActivityObject();

        mainActivityObject.setEmail(repositoryApplication.getEmail());
        mainActivityObject.setPassword(repositoryApplication.getPassword());
        mainActivityObject.clickOnLoginButton();

        Thread.sleep(2000);

        Assert.assertEquals(secondActivityObject.getSecondPageTitleText(), repositoryApplication.getSecondPageTitle());
    }
}
