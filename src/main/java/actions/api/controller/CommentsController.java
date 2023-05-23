package actions.api.controller;

import actions.api.service.CommentsService;
import actions.api.user.CommentsApi;
import com.fasterxml.jackson.core.JsonProcessingException;

public class CommentsController {

    private CommentsService commentsService = new CommentsService();
    private CommentsApi commentsApi = new CommentsApi();

    public CommentsController() throws JsonProcessingException {
    }


    public String[] getAllComments() {

        return commentsApi.getAllComments(commentsService.getAllComments());
    }
}
