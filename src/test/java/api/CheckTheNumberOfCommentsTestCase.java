package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import common.BaseSetup;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class CheckTheNumberOfCommentsTestCase extends BaseSetup {

    private final int NUMBER_OF_COMMENTS = 3;

    public CheckTheNumberOfCommentsTestCase() throws JsonProcessingException {
    }

    @AfterMethod
    @Override
    public void setup() {
    }

    @AfterMethod
    @Override
    public void tearDown() {
    }

    @Test
    public void checkTheThreeCommentsFromApi() {

        Assert.assertEquals(controller.getAllComments().length, NUMBER_OF_COMMENTS, "the number of actual comments doesn't match the expected ones");
    }
}
