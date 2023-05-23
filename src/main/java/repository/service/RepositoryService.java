package repository.service;


import repository.expectedData.ExpectedData;
import repository.input.InputData;
import repository.model.ExpectedDataModel;

public class RepositoryService {

    private ExpectedDataModel[] expectedDataList;


    private void generateExpectedDataList() {
        expectedDataList = new ExpectedDataModel[8];

        expectedDataList[0] = new ExpectedDataModel(ExpectedData.SECOND_PAGE_TITLE);
        expectedDataList[1] = new ExpectedDataModel(InputData.EMAIL);
        expectedDataList[2] = new ExpectedDataModel(InputData.PASSWORD);
        expectedDataList[3] = new ExpectedDataModel(InputData.WRONG_EMAIL);
        expectedDataList[4] = new ExpectedDataModel(ExpectedData.WRONG_EMAIL_MESSAGE);
        expectedDataList[5] = new ExpectedDataModel(ExpectedData.FIRST_COMMENT);
        expectedDataList[6] = new ExpectedDataModel(ExpectedData.SECOND_COMMENT);
        expectedDataList[7] = new ExpectedDataModel(ExpectedData.THIRD_COMMENT);
    }

    public String getVariableFromExpectedDataList(int indexForVariable) {
        if (expectedDataList == null) {
            generateExpectedDataList();
        }
        return expectedDataList[indexForVariable].getExpectedDataNameField();
    }

}
