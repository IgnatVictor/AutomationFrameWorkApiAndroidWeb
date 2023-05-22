package android;


import actions.android.mainActivity.MainActivity;
import android.setupAndroid.SetupAndroid;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailTestCase extends SetupAndroid {

    private MainActivity createMainActivityObject() {
        return new MainActivity(driver);
    }

    @Test
    public void checkIfMessagePopsWhenInsertingWrongMailOrWrongFormat() throws InterruptedException {

        final MainActivity mainActivityObject = createMainActivityObject();

        mainActivityObject.setEmail(repositoryApplication.getWrongEmail());
        mainActivityObject.clickOnLoginButton();

        Thread.sleep(2000);

        Assert.assertEquals(mainActivityObject.getWrongEmailMessageText(), repositoryApplication.getWrongEmailErrorMessage());
    }
}
