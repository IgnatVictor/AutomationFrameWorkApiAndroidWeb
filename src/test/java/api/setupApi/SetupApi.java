package api.setupApi;

import actions.api.controller.CommentsController;
import com.fasterxml.jackson.core.JsonProcessingException;
import repository.RepositoryApplication;

public abstract class SetupApi {

    protected CommentsController controller = new CommentsController();
    protected RepositoryApplication repositoryApplication = new RepositoryApplication();


    public SetupApi() throws JsonProcessingException {
    }
}
