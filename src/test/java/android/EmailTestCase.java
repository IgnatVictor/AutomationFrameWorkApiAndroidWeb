package android;


import actions.android.mainActivity.MainActivityObject;
import android.setupAndroid.SetupAndroid;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailTestCase extends SetupAndroid {

    private MainActivityObject createMainActivityObject() {
        return new MainActivityObject(driver);
    }

    @Test
    public void checkIfMessagePopsWhenInsertingWrongMailOrWrongFormat() throws InterruptedException {
        final MainActivityObject mainActivityObject = createMainActivityObject();

        mainActivityObject.setEmail(repositoryApplication.getWrongEmail());
        mainActivityObject.clickOnLoginButton();

        Thread.sleep(2000);

        Assert.assertEquals(mainActivityObject.getWrongEmailMessageText(), repositoryApplication.getWrongEmailErrorMessage());
    }
}
