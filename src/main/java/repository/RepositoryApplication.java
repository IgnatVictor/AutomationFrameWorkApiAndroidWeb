package repository;


import repository.service.RepositoryService;

public class RepositoryApplication {

    RepositoryService service = new RepositoryService();

    public String getEmail() {
        int email = 1;
        return service.getVariableFromExpectedDataList(email);
    }

    public String getWrongEmail() {
        int wrongEmail = 3;
        return service.getVariableFromExpectedDataList(wrongEmail);
    }

    public String getPassword() {
        int password = 2;
        return service.getVariableFromExpectedDataList(password);
    }

    public String getSecondPageTitle() {
        int secondPageTitle = 0;
        return service.getVariableFromExpectedDataList(secondPageTitle);
    }

    public String getWrongEmailErrorMessage() {
        int wrongEmailErrorMessage = 4;
        return service.getVariableFromExpectedDataList(wrongEmailErrorMessage);
    }

    public String getFirstComment() {
        int firstComment = 5;
        return service.getVariableFromExpectedDataList(firstComment);
    }

    public String getSecondComment() {
        int firstComment = 6;
        return service.getVariableFromExpectedDataList(firstComment);
    }

    public String getThirdComment() {
        int firstComment = 7;
        return service.getVariableFromExpectedDataList(firstComment);
    }

    public String getUsernameForWeb() {
        int usernameForWeb = 8;
        return service.getVariableFromExpectedDataList(usernameForWeb);
    }

    public String getPasswordForWeb() {
        int passwordForWeb = 9;
        return service.getVariableFromExpectedDataList(passwordForWeb);
    }

    public String getMainPageTitleText() {
        int mainPageTitleText = 10;
        return service.getVariableFromExpectedDataList(mainPageTitleText);
    }

    public String getWrongUsernameForWeb() {
        int wrongUsernameForWeb = 11;
        return service.getVariableFromExpectedDataList(wrongUsernameForWeb);
    }

    public String getWrongPasswordForWeb() {
        int wrongPasswordForWeb = 12;
        return service.getVariableFromExpectedDataList(wrongPasswordForWeb);
    }

    public String getInvalidCredentialsMessageText() {
        int invalidCredentialsMessage = 13;
        return service.getVariableFromExpectedDataList(invalidCredentialsMessage);
    }
}
