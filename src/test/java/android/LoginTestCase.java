package android;


import actions.android.mainActivity.MainActivity;
import actions.android.secondActivity.SecondActivity;
import android.setupAndroid.SetupAndroid;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestCase extends SetupAndroid {

    private MainActivity createMainActivityObject() {
        return new MainActivity(driver);
    }

    private SecondActivity createSecondActivityObject() {
        return new SecondActivity(driver);
    }

    @Test
    public void checkThatAfterLoginItRedirectsToFirstPage() throws InterruptedException {

        final MainActivity mainActivityObject = createMainActivityObject();
        final SecondActivity secondActivityObject = createSecondActivityObject();

        mainActivityObject.setEmail(repositoryApplication.getEmail());
        mainActivityObject.setPassword(repositoryApplication.getPassword());
        mainActivityObject.clickOnLoginButton();

        Thread.sleep(2000);

        Assert.assertEquals(secondActivityObject.getSecondPageTitleText(), repositoryApplication.getSecondPageTitle());
    }
}
