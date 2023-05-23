package repository.service;


import repository.expectedData.ExpectedData;
import repository.input.InputData;
import repository.model.ExpectedDataModel;

public class RepositoryService {

    private ExpectedDataModel[] expectedDataList;


    private void generateExpectedDataList() {
        expectedDataList = new ExpectedDataModel[14];

        expectedDataList[0] = new ExpectedDataModel(ExpectedData.SECOND_PAGE_TITLE);
        expectedDataList[1] = new ExpectedDataModel(InputData.EMAIL_FOR_ANDROID);
        expectedDataList[2] = new ExpectedDataModel(InputData.PASSWORD_FOR_ANDROID);
        expectedDataList[3] = new ExpectedDataModel(InputData.WRONG_EMAIL_FOR_ANDROID);
        expectedDataList[4] = new ExpectedDataModel(ExpectedData.WRONG_EMAIL_MESSAGE);
        expectedDataList[5] = new ExpectedDataModel(ExpectedData.FIRST_COMMENT);
        expectedDataList[6] = new ExpectedDataModel(ExpectedData.SECOND_COMMENT);
        expectedDataList[7] = new ExpectedDataModel(ExpectedData.THIRD_COMMENT);
        expectedDataList[8] = new ExpectedDataModel(InputData.USERNAME_FOR_WEB);
        expectedDataList[9] = new ExpectedDataModel(InputData.PASSWORD_FOR_WEB);
        expectedDataList[10] = new ExpectedDataModel(ExpectedData.MAIN_PAGE_TITLE_TEXT);
        expectedDataList[11] = new ExpectedDataModel(InputData.WRONG_USERNAME);
        expectedDataList[12] = new ExpectedDataModel(InputData.WRONG_PASSWORD);
        expectedDataList[13] = new ExpectedDataModel(ExpectedData.INVALID_LOGIN_MESSAGE);
    }

    public String getVariableFromExpectedDataList(int indexForVariable) {
        if (expectedDataList == null) {
            generateExpectedDataList();
        }
        return expectedDataList[indexForVariable].getExpectedDataNameField();
    }

}
