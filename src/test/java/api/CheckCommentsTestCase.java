package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import common.BaseSetup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckCommentsTestCase extends BaseSetup {

    private final int FIRST_COMMENT_INDEX = 0;
    private final int SECOND_COMMENT_INDEX = 1;
    private final int THIRD_COMMENT_INDEX = 2;

    public CheckCommentsTestCase() throws JsonProcessingException {
    }

    @BeforeMethod
    @Override
    public void setup() {
    }

    @AfterMethod
    @Override
    public void tearDown() {
    }

    @Test
    public void checkTheThreeCommentsFromApi() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(controller.getAllComments()[FIRST_COMMENT_INDEX], repositoryApplication.getFirstComment());
        softAssert.assertEquals(controller.getAllComments()[SECOND_COMMENT_INDEX], repositoryApplication.getSecondComment());
        softAssert.assertEquals(controller.getAllComments()[THIRD_COMMENT_INDEX], repositoryApplication.getThirdComment());

        softAssert.assertAll();
    }
}
