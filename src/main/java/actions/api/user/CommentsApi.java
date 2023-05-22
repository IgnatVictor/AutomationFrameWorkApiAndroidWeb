package actions.api.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class CommentsApi {

    private JsonObject jsonObject;

    public JsonObject getComment(String comment, int id) {
        this.jsonObject = new JsonObject();
        this.jsonObject.add("comment",new Gson().toJsonTree(comment));
        this.jsonObject.add("id",new Gson().toJsonTree(id));

        return this.jsonObject;
    }

    public ArrayList<JsonObject> getAllComments(ArrayList<String[]> listOfAllCommentsFromService) {
        int id = 0;
        int comment = 1;
        ArrayList<JsonObject> listOfComments =  new ArrayList<>();

        for(int i=0; i<listOfAllCommentsFromService.size(); i++) {
            jsonObject =  new JsonObject();
            this.jsonObject.add("id",new Gson().toJsonTree(listOfAllCommentsFromService.get(i)[id]));
            this.jsonObject.add("comment",new Gson().toJsonTree(listOfAllCommentsFromService.get(i)[comment]));


            listOfComments.add(jsonObject);
        }
        return listOfComments;
    }


}
