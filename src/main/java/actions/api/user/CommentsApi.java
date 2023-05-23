package actions.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CommentsApi {
    private JsonObject jsonObject;

    public JsonObject getComment(String comment, int id) {
        this.jsonObject = new JsonObject();
        this.jsonObject.add("comment", new Gson().toJsonTree(comment));
        this.jsonObject.add("id", new Gson().toJsonTree(id));

        return this.jsonObject;
    }

    public String[] getAllComments(String[] listOfAllCommentsFromService) {
        String[] listOfComments = new String[3];

        for (int i = 0; i < listOfAllCommentsFromService.length; i++) {
            listOfComments[i] = listOfAllCommentsFromService[i];
        }
        return listOfComments;
    }
}
