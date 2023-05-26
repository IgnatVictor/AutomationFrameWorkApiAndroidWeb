package api;

import api.setupApi.SetupApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckTheNumberOfCommentsTestCase extends SetupApi {

    private final int NUMBER_OF_COMMENTS = 3;

    public CheckTheNumberOfCommentsTestCase() throws JsonProcessingException {
    }

    @Test
    public void checkTheThreeCommentsFromApi() {

        Assert.assertEquals(controller.getAllComments().length, NUMBER_OF_COMMENTS, "the number of actual comments doesn't match the expected ones");
    }
}
