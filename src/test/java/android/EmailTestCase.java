package android;


import actions.android.mainActivity.MainActivityObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import common.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailTestCase extends BaseSetup {

    protected EmailTestCase() throws JsonProcessingException {
    }

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
