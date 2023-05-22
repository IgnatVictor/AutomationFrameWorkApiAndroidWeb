package actions.api.controller;

import actions.api.service.CommentsService;
import actions.api.user.CommentsApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class CommentsController {

    private CommentsService commentsService = new CommentsService();
    private CommentsApi commentsApi = new CommentsApi();

    public CommentsController() throws JsonProcessingException {
    }


    public ArrayList<JsonObject> getAllComments() throws JsonProcessingException {

        return commentsApi.getAllComments(commentsService.getAllComments());

    }

}
